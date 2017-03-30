package com.msa.ims.pos

import net.rcarz.jiraclient._

/**
  * Created by hbao on 3/3/2016.
  */
object LogABugOnJira {
  /* Log a bug for failed automated test.
*/

  val creds: BasicCredentials = new BasicCredentials("hbao", "Me@uwg2015")
  val jira: JiraClient = new JiraClient("https://vl185.msais.com/jira", creds)

  def execute(scenarioName: String) {
    var newIssue: Issue = null

    try {
      newIssue = jira.createIssue("POS", "Bug")
        .field(Field.SUMMARY, "Portal Automation Test Failed: " + scenarioName)
        .field(Field.DESCRIPTION, "Automation on POS - Test Failure" + scenarioName)
        .field(Field.REPORTER, "hbao")
        .field(Field.ASSIGNEE, "hbao")
        .execute()
    } catch {
      case e: JiraException => e.printStackTrace()
    }
  }
}
