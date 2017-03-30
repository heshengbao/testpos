package com.msa.ims.pos

import java.sql.Timestamp

import com.typesafe.config.ConfigFactory
import org.json.simple.{JSONObject, JSONArray}
import org.scalatest.Matchers
import cucumber.api.Scenario
import cucumber.api.scala.{EN, ScalaDsl}
import testrail.APIClient

/**
 * Put all definitions for hooks here to have some separation
 * Created by hbao on 10/22/2015.
 *
 */
class CucumberHooks extends ScalaDsl with EN with Matchers {

  /* Below are implementation for the integration with TestRail
*/
  var client:APIClient = _ //new APIClient("https://vl47.msais.com/")
  var testRunID: String = _
  var caseID: String = _
  var testTrail: Int = 0
  var scenarioFailed = false
  var scenarioContextFailed: String = "One or more tests in scenario outline failed:\n "
  var flag: Boolean = false

  Before() { (scenario: Scenario) =>

    val urlTestRail = ConfigFactory.load.getString("my.testrail.Url")
    val userName = ConfigFactory.load.getString("my.testrail.Username")
    val passWord = ConfigFactory.load.getString("my.testrail.Password")
    val emailAddress = userName + "@msa.com"

    def getLocation(detail: Boolean) = "done!"

    client = new APIClient(urlTestRail)
    client.setUser(emailAddress)
    client.setPassword(passWord)

    //WHEN THE ENTIRE FEATURE ISN'T SET TO "SMOKE", ANY TEST THAT IS NOT TAGGED AS "SMOKE" WILL BE SET TO RETEST

    if (flag == false) {
      testRunID = ConfigFactory.load.getString("my.testrail.TestRunID")
      val data = new java.util.HashMap[String, String]()
      //data.put("test_id", testRunID)
      data.put("status_id", "4") //RETEST

      val input = "get_tests/" + testRunID
      val list:JSONArray = client.sendGet(input).asInstanceOf[JSONArray]

      val num: Int = list.size
      for (i <- 0 until num) {
        val x:JSONObject = list.get(i).asInstanceOf[JSONObject]
        val id = x.get("case_id")
        val path =  "add_result_for_case/" + testRunID + "/" + id.toString
        client.sendPost(path, data)
      }
      flag = true
    }
  }

  //
  //this After hook is called after each test completes but the last one.
  //
  After("@ScenarioOutline") { (scenario: Scenario) =>

    if (scenario.isFailed) {
      //FAILED
      scenarioFailed = true
      scenarioContextFailed += scenario.getId + " Failed: for details target/surefire-reports/\n"
      LogABugOnJira.execute(scenario.getName)
    }

  }
  //
  //this After hook is called after the test in the scenario outline
  //
  After("@lastScenario") { (scenario: Scenario) =>

    val data = new java.util.HashMap[String,String]()
    if (!scenario.isFailed && !scenarioFailed) {
      //PASSED
      data.put("status_id", "1") //PASSED
      data.put("comment",  "This test worked fine!")
    } else {
      //FAILED
      scenarioFailed = true
      scenarioContextFailed += "Last test in the scenario outline failed: for details target/surefire-reports/\n"
      data.put("status_id", "5") //FAILED
      data.put("comment",  scenarioContextFailed)
      LogABugOnJira.execute(scenario.getName)
    }

    val title: String = scenario.getName
    val parts = title.split("C#")

    if (parts.length >= 2) {
      caseID = parts(1)
      testRunID = ConfigFactory.load.getString("my.testrail.TestRunID")
      val path = "add_result_for_case/" + testRunID + "/" + caseID
      if (Option(testRunID).exists(_.trim.nonEmpty) && Option(caseID).exists(_.trim.nonEmpty))
      {
        client.sendPost(path, data)
        //reset the scenario
        scenarioFailed = false
        scenarioContextFailed = "One or more tests in scenario outline failed:\n "
      }
    }
  }
  //
  //this After hook is for regular scenario defined in the feature file
  //
  After("~@ScenarioOutline", "~@lastScenario") { scenario: Scenario =>

    val data = new java.util.HashMap[String,String]()

    val _results = scenario.getStatus

    _results match {
      case "passed" =>
        data.put("status_id", "1") //PASSED
        data.put("comment",  "This test worked fine!")
      case default =>
        //FAILED
        scenarioFailed = true
        scenarioContextFailed = "Test in the Scenario failed:\n"
        scenarioContextFailed += scenario.getId
        scenarioContextFailed += " Failed: for details target/surefire-reports/\n"
        data.put("status_id", "5") //FAILED
        data.put("comment",  scenarioContextFailed)

        LogABugOnJira.execute(scenario.getName)
    }

    val title: String = scenario.getName
    val parts = title.split("C#")
    if (parts.length >= 2) {
      caseID = parts(1)
      testRunID = ConfigFactory.load.getString("my.testrail.TestRunID")
      val path = "add_result_for_case/" + testRunID + "/" + caseID
      if (Option(testRunID).exists(_.trim.nonEmpty) && Option(caseID).exists(_.trim.nonEmpty))
      {
        client.sendPost(path, data)
        //reset the scenario
        scenarioFailed = false
        scenarioContextFailed = "One or more tests in scenario outline failed:\n "
      }
    }
  }
}

