package com.msa.ims.pos

import java.util
import java.util.Calendar
import java.util.concurrent.TimeUnit

import pages.Driver
import com.msa.ims.pos.pages._
import cucumber.api.{PendingException, Scenario}
import cucumber.api.scala.{EN, ScalaDsl}
import org.openqa.selenium.interactions.Actions
import org.openqa.selenium.support.ui.{ExpectedConditions, WebDriverWait}
import org.openqa.selenium._
import org.scalatest.Matchers
import org.openqa.selenium.JavascriptExecutor

import com.typesafe.config.ConfigFactory

/**
 * Portal UI Test Definitions
 * Technologies used: maven, Selenium WebDriver, cucumber, IntelliJ, etc.
 * Tests developed For POS Portal
 * Created by hbao on 10/19/2015.
 */
class PortalUITestStepDefs extends ScalaDsl with EN with Matchers {

  lazy val wpLogin = new Login().initPage
  lazy val wpRetailers = new Retailers().initPage
  lazy val wpInactiveRetailers = new InactiveRetailers().initPage
  lazy val wpEnrollAccount = new EnrollAccount().initPage
  lazy val wpCurrentQuarter = new CurrentQuarter().initPage
  lazy val wpLastQuarter = new LastQuarter().initPage
  lazy val wpSubmissionHistory = new SubmissionHistory().initPage
  lazy val wpTesting = new Testing().initPage
  lazy val wpActiveUsers = new ActiveUsers().initPage
  lazy val wpAccountInfo = new AccountInfo().initPage
  lazy val wpComments = new Comments().initPage
  lazy val wpTransactionSummary = new TransactionSummary().initPage
  lazy val wpErrors = new Errors().initPage
  lazy val wpEnrollRetailer = new EnrollRetailer().initPage
  lazy val wpAccountTransactions = new AccountTransactions().initPage
  lazy val wpTransactionsByMonth = new TransactionsByMonth().initPage
  lazy val wpJanuary = new January().initPage
  lazy val wpAttachedFiles = new AttachedFiles().initPage
  lazy val wpOutlets = new Outlets().initPage
  lazy val wpCreateUser = new CreateUser().initPage
  lazy val wpChangePassword = new ChangePassword().initPage
  lazy val wpCurrentQuarterRep = new CurrentQuarterRep().initPage
  lazy val wpLastQuarterRep = new LastQuarterRep().initPage
  lazy val wpSubmissionHistoryRep = new SubmissionHistoryRep().initPage
  lazy val wpTestingRep = new TestingRep().initPage
  lazy val wpSubmitLive = new SubmitLive().initPage
  lazy val wpSubmitTest = new SubmitTest().initPage

  Given( """^I login to the portal as a (matching|rsc) user$""") { (negate: String) =>
    val serverType = ConfigFactory.load.getString("my.portal.type")
    Driver.getDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
    if (negate.equals("rsc")) {
      Url.getUrl(serverType, negate)
      Driver.getDriver.navigate().to(PosConstants.ServerUrl(serverType, negate))

      val _userName = ConfigFactory.load.getString("my.RscRep.Username")
      val _passWord = ConfigFactory.load.getString("my.RscRep.Password")
      Driver.getDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
      wpLogin.login(_userName, _passWord)
    } else {
      Url.getUrl(serverType, negate)
      Driver.getDriver.navigate().to(PosConstants.ServerUrl(serverType, "matching"))

      val _userName = ConfigFactory.load.getString("my.Matching.Username")
      val _passWord = ConfigFactory.load.getString("my.Matching.Password")
      wpLogin.login(_userName, _passWord)
    }

  }

  Given("""^I login to vl184 as a (matching|rsc) user$"""){ (negate: String) =>
    val serverType = "QA"
    if (negate.equals("rsc")){

    }
    else if (negate.equals("matching")){
      Driver.getDriver.navigate().to(PosConstants.ServerUrl(serverType, negate))
      wpLogin.login("matching_autotest@msais.com", "5m0kete5t")
    }
  }

  Given("""^I have navigated to the Portal Login Page$"""){
    wpLogin.check()
  }

  When("""^I try to login to the (internal|external) portal$"""){ (arg0: String) =>
    if (arg0.equals("internal")){
      Url.getUrl("prod", "matching")
      Driver.getDriver.navigate().to(PosConstants.ServerUrl("prod", "matching"))
      val _userName = ConfigFactory.load.getString("my.RscRep.Username")
      val _passWord = ConfigFactory.load.getString("my.RscRep.Password")
      wpLogin.login(_userName, _passWord)
    }
    else {
      val serverType = ConfigFactory.load.getString("my.portal.type")
      Driver.getDriver.navigate().to(PosConstants.ServerUrl(serverType, "rsc"))
      val _userName = ConfigFactory.load.getString("my.RscRep.Username")
      val _passWord = ConfigFactory.load.getString("my.RscRep.Password")
      wpLogin.login(_userName, _passWord)
    }
  }

  When("""^I enter username "(.*?)" and password "(.*?)"$"""){ (arg0: String, arg1: String) =>
    wpLogin.enterCredentials(arg0, arg1)
  }

  When("""^click button Login$"""){
    wpLogin.click()
  }

  When("""^I navigate to the (.*?) page$"""){ (arg0: String) =>
    if (arg0.equals("Create Accounts")){
      wpRetailers.navTo("create")
    }
    else if (arg0.equals("Active Accounts")){
      wpRetailers.navTo("active accounts")
    }
    else if (arg0.equals("Inactive Accounts")){
      wpRetailers.navTo("inactive accounts")
    }
    else if (arg0.equals("YTD Report")){
      wpRetailers.navTo("ytd")
    }
    else if (arg0.equals("YTD Report Test")){
      wpRetailers.navTo("ytdtest")
    }
    else if (arg0.equals("Production")){
      wpTestingRep.navTo("production")
    }
    else if (arg0.equals("Production Test")){
      wpTestingRep.navTo("test")
    }
  }

  When ("""^I search for retailer (rj food mart|7-eleven)$"""){ (arg0: String) =>
    if (arg0.equals("rj food mart")){
      wpEnrollAccount.search()
    }
    else{
      Driver.getDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS)
      wpRetailers.search("7-eleven ")
    }
  }

  When ("""^I search accounts for retailer (7-eleven|Dandy)$"""){ (arg0: String) =>
    if (arg0.equals("7-eleven")) {
      Driver.getDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
      wpAccountTransactions.search("7-eleven")
    }
  }

  When ("""^I search for outlet (.*?)$"""){ (arg0: String) =>
    wpOutlets.search(arg0)
  }

  When("""^I enter (.*?) into the comment text area$"""){ (arg0: String) =>
    Driver.getDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS)
    wpComments.addComment(arg0)
  }

  When("""^I enter (.*?) into the address field$"""){ (arg0: String) =>
    wpAccountInfo.enter(arg0)
  }

  When("""^I click on (.*?)$"""){ (arg0: String) =>
    if (arg0.equals("last quarter")){
      wpCurrentQuarter.click("last quarter")
    }
    else if (arg0.equals("submission history")){
      wpLastQuarter.click("submission history")
    }
    else if (arg0.equals("testing")){
      wpSubmissionHistory.click("testing")
    }
    else if (arg0.equals("active users")){
      wpTesting.click("active users")
    }
    else if (arg0.equals("account info")){
      Driver.getDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS)
      wpActiveUsers.click("Account Info")
    }
    else if (arg0.equals("last comments")){
      Driver.getDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS)
      //Driver.getDriver.wait()
      wpTesting.click("comments")
    }
    else if (arg0.equals("previous page")){
      wpTransactionSummary.click("prev page")
    }
    else if (arg0.equals("previous page 2")){
      wpTransactionSummary.click("prev page 2")
    }
    else if (arg0.equals("create")){
      wpActiveUsers.click("Create")
    }
    else if (arg0.equals("enroll retailer link")){
      Driver.getDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
      wpEnrollAccount.click()
    }
    else if (arg0.equals("errors")){
      Driver.getDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS)
      wpTesting.click("errors")
    }
    else if (arg0.equals("January")){
      Thread.sleep(5000)
      wpTransactionsByMonth.click()
    }
    else if (arg0.equals("the first outlet")){
      wpTransactionSummary.click("outlet")
    }
    else if (arg0.equals("testing for Nicks")){
      wpCurrentQuarter.click("testing")
    }
    else if (arg0.equals("Users")){
      wpRetailers.navTo("users")
    }
    else if (arg0.equals("account info for Quality")){
      wpCurrentQuarter.click("account info")
    }
    else if (arg0.equals("the errors tab")){
      wpCurrentQuarterRep.click("errors")
    }
    else if (arg0.equals("the testing tab")){
      wpCurrentQuarterRep.click("testing")
    }
  }

  When ("""^I click the (transaction summary|attached files|comments|errors) for (current quarter|last quarter|submission history|testing|attached files)$"""){ (arg0: String, arg1: String) =>
    if (arg1.equals("current quarter")){
      Driver.getDriver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS)
      wpCurrentQuarter.click(arg0)
    }
    else if (arg1.equals("last quarter")){
      Driver.getDriver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS)
      wpLastQuarter.click(arg0)
    }
    else if (arg1.equals("submission history")){
      Driver.getDriver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS)
      wpSubmissionHistory.click(arg0)
    }
    else if (arg1.equals("testing")){
      Driver.getDriver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS)
      wpTesting.click(arg0)
    }
    else if (arg1.equals("attached files")){
      Driver.getDriver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS)
      wpAttachedFiles.click(arg0)
    }
  }

  When("""^I click button (.*?)$"""){ (arg0: String) =>
    if (arg0.equals("View Errors")){
      wpErrors.click()
    }
    else if (arg0.equals("View Users")){
      wpAccountInfo.click("View Users")
    }
    else if (arg0.equals("View Days")){
      Driver.getDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS)
      wpJanuary.click()
    }
    else if (arg0.equals("Missing")){
      wpOutlets.click("missing")
    }
    else if (arg0.equals("Reported")){
      wpOutlets.click("reported")
    }
    else if (arg0.equals("Clear Comment")){
      wpComments.click("clear button")
    }
    else if (arg0.equals("Add Comment")){
      wpComments.click("add button")
    }
    else if (arg0.equals("Create New Password")){
      wpActiveUsers.click("Create New Password")
    }
    else if (arg0.equals("Create User")){
      wpCreateUser.click("create")
    }
    else if (arg0.equals("deactivate")){
      Driver.getDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS)
      wpAccountInfo.click("Deactivate")
    }
    else if (arg0.equals("activate")){
      Driver.getDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS)
      wpAccountInfo.click("Activate")
    }
  }

  When("""^I click pencil to edit (active users|account info|account complexity)$"""){ (arg0: String) =>
    if (arg0.equals("active users")){
      wpActiveUsers.click("Pencil")
    }
    else if (arg0.equals("account info")){
      wpAccountInfo.click("Pencil")
    }
    else if (arg0.equals("account complexity")){
      wpAccountInfo.click("Pencil 2")
    }
  }

  When ("""^I enter (valid|invalid) information$"""){ (arg0: String) =>
    if (arg0.equals("valid")){
      wpCreateUser.enterFullInfo()
    }
    else if (arg0.equals("invalid")) {
      wpCreateUser.enterInfo()
    }
  }

  When ("""^I change password to (.*?)$"""){ (arg0: String) =>
    wpChangePassword.enterPass(arg0)
  }

  When("""^I click username and choose logout$"""){
    wpRetailers.logout()
  }

  Then("""^the login failed$"""){
    wpLogin.loginFailed()
  }

  Then("""^the login rejected$"""){

  }

  Then("""^I am on the (.*?) page$"""){ (arg0: String) =>
    if (arg0.equals("current quarter")){
      wpCurrentQuarter.check()
    }
    else if (arg0.equals("last quarter")){
      wpLastQuarter.check("page_id")
    }
    else if (arg0.equals("submission history")){
      wpSubmissionHistory.check()
    }
    else if (arg0.equals("testing")){
      wpTesting.check()
    }
    else if (arg0.equals("active users")){
      Driver.getDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS)
      wpActiveUsers.check("page_id")
    }
    else if (arg0.equals("account info")){
      Driver.getDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS)
      wpAccountInfo.check("page_id")
    }
    else if (arg0.equals("account transactions")){
      wpAccountTransactions.check("page_id")
    }
    else if (arg0.equals("transactions by month")){
      Driver.getDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS)
      wpTransactionsByMonth.check()
    }
    else if (arg0.equals("january transactions")){
      wpJanuary.check()
    }
    else if (arg0.equals("outlets")){
      wpOutlets.check("page_id")
    }
    else if (arg0.equals("create user")){
      wpCreateUser.check("page_id")
    }
    else if (arg0.equals("current quarter rep")){
      wpCurrentQuarterRep.check("page_id")
    }
    else if (arg0.equals("last quarter rep")){
      wpLastQuarterRep.check("page_id")
    }
    else if (arg0.equals("submission history rep")){
      wpSubmissionHistoryRep.check("page_id")
    }
    else if (arg0.equals("testing rep")){
      wpTestingRep.check("page_id")
    }
    else if (arg0.equals("submit live file")){
      wpSubmitLive.check("page_id")
    }
    else if (arg0.equals("submit test file")){
      wpSubmitTest.check("page_id")
    }
    else if (arg0.equals("errors")){
      Thread.sleep(2000)
      wpErrors.check("page_id")
    }
    else if (arg0.equals("active retailers")){
      wpRetailers.check("page_id")
    }
    else if (arg0.equals("inactive retailers")){
      wpInactiveRetailers.check()
    }
  }

  Then("""^(.*?) is displaying$"""){ (arg0: String) =>
    if (arg0.equals("my email")){
      Driver.getDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS)
      wpRetailers.check("email")
    }
    else if (arg0.equals("the retailer link")){
      Driver.getDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS)
      wpEnrollAccount.check()
    }
    else if (arg0.equals("the test comment")){
      Driver.getDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS)
      wpComments.check("comments")
    }
    else if (arg0.equals("the comment box")){
      wpComments.check("the comment box")
    }
    else if (arg0.equals("the transaction summary")){
      Driver.getDriver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS)
      wpTransactionSummary.check("page_id")
    }
    else if (arg0.equals("the date")){
      wpTransactionSummary.check("the date")
    }
    else if (arg0.equals("transactions")){
      wpTransactionSummary.check("transactions")
    }
    else if (arg0.equals("outlets")){
      wpTransactionSummary.check("outlets")
    }
    else if (arg0.equals("quantity")){
      wpTransactionSummary.check("quantity")
    }
    else if (arg0.equals("dollars")){
      wpTransactionSummary.check("dollars")
    }
    else if (arg0.equals("the attached file")){
      wpAttachedFiles.check()
    }
    else if (arg0.equals("the enroll button")){
      Driver.getDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS)
      wpEnrollRetailer.check()
    }
    else if (arg0.equals("the reported button")){
      wpOutlets.check("reported")
    }
    else if (arg0.equals("the missing button")){
      wpOutlets.check("missing")
    }
    else if (arg0.equals("an outlet")){
      Driver.getDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS)
      wpOutlets.check("an outlet")
    }
    else if (arg0.equals("no outlet")){
      wpOutlets.check("not an outlet")
    }
    else if (arg0.equals("the last quarter date")){
      Driver.getDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS)
      wpLastQuarter.check("the date")
    }
    else if (arg0.equals("the comment date")){
      Driver.getDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS)
      wpComments.check("the date")
    }
    else if (arg0.equals("the add comment button")){
      Driver.getDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS)
      wpComments.check("add button")
    }
    else if (arg0.equals("the user name")){
      wpComments.check("the user name")
    }
    else if (arg0.equals("the save button")){
      wpActiveUsers.check("the save button")
    }
    else if (arg0.equals("the change password button")){
      wpChangePassword.check("change button")
    }
    else if (arg0.equals("the account info save button")){
      wpAccountInfo.check("save button")
    }
    else if (arg0.equals("the links")){
      wpCurrentQuarterRep.check("current quarter link")
      wpCurrentQuarterRep.check("last quarter link")
    }
    else if (arg0.equals("the search bar")){
      wpAccountTransactions.check("search bar")
    }
    else if (arg0.equals("no search bar")){
      wpAccountTransactions.check("no search bar")
    }
    else if (arg0.equals("10 retailers")){
      wpAccountTransactions.check("card")
    }
    else if (arg0.equals("active status")){
      Driver.getDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS)
      wpAccountInfo.check("active status")
    }
    else if (arg0.equals("inactive status")){
      Driver.getDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS)
      wpAccountInfo.check("inactive status")
    }
    else if (arg0.equals("the deactivate button")){
      Driver.getDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS)
      wpAccountInfo.check("deactivate button")
    }
    else if (arg0.equals("the activate button")){
      Driver.getDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS)
      wpAccountInfo.check("activate button")
    }
    else if (arg0.equals("the confirm deactivate button")){
      Driver.getDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS)
      wpAccountInfo.check("confirm d button")
    }
    else if (arg0.equals("the confirm activate button")){
      Driver.getDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS)
      wpAccountInfo.check("confirm a button")
    }
  }

  Then("""^quantity and dollars are not 0$"""){
    wpTransactionSummary.check("quant not 0")
    wpTransactionSummary.check("dollars not 0")
  }

  Then("""^the first date matches date in the title$"""){
    wpTransactionSummary.check("date matches")
  }

  Then("""^I cannot click button (.*?)$"""){ (arg0: String) =>
    if (arg0.equals("Create")) {
      wpCreateUser.check("create button")
    }
  }

  Then("""^clear the form$"""){
    wpLogin.clearTheForm()
  }

  Then("""^I am redirected to the login page$"""){
    Driver.getDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS)
    wpLogin.check()
  }
  Then("""^I close the browser$"""){
    Driver.close()
  }
}