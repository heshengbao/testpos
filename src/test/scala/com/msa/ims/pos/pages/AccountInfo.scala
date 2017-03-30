package com.msa.ims.pos.pages

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.{ExpectedConditions, ExpectedCondition}

/**
  * Created by mkutilek on 6/6/2016.
  */
class AccountInfo extends Base[AccountInfo] {
  def initPage: AccountInfo = {
    Thread.sleep(2000)
    new AccountInfo().initPage(classOf[AccountInfo])
  }

  @FindBy(xpath = "//*[@id=\"navbar\"]/nav/div/div[1]/img")
  var logo: WebElement =_

  @FindBy(css = "a[href='/files/#/submitters/757c20bc-efec-4870-9e43-cd00a9b09735/files-by-quarter/0']")
  var next_page: WebElement =_

  @FindBy(xpath = "//*[@id=\"app\"]/div/div[6]/div[1]/span[1]")
  var page_itentifier: WebElement =_

  @FindBy(css = "a[href='/accounts/#/users/757c20bc-efec-4870-9e43-cd00a9b09735/list/active']")
  var viewUsersButton: WebElement =_

  @FindBy(xpath = "//*[@id=\"app\"]/div/div[6]/div[1]/span[2]")
  var pencil: WebElement =_

  @FindBy(xpath = "//*[@id=\"app\"]/div/div[7]/div[1]/span[2]")
  var pencil2: WebElement =_

  @FindBy(xpath = "//*[@id=\"app\"]/div/div[6]/div[2]/div/button[1]")
  var cancelButton: WebElement =_

  @FindBy(className = "segmented-progress-unit")
  var complexity: WebElement =_

  @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[3]/div[2]/div/div[1]/form/div[2]/div[2]/div/input")
  var addressBar: WebElement =_
  //xpath = "//*[@id=\"app\"]/div/div/div[3]/div[2]/div/div[2]/div/div/button[2]"
  @FindBy(className = "btn-primary")
  var saveButton: WebElement =_

  @FindBy(className = "text-success")
  var active_status: WebElement =_

  @FindBy(className = "text-danger")
  var inactive_status: WebElement =_

  @FindBy(className = "btn-danger")
  var deactivateButton: WebElement =_
  //*[@id="ConfirmDeactivate"]/div/div/div[3]/button[2]
  @FindBy(xpath = "//*[@id=\"ConfirmDeactivate\"]/div/div/div[3]/button[2]")
  var confirmDButton: WebElement =_

  @FindBy(xpath = "//*[@id=\"ConfirmActivate\"]/div/div/div[3]/button[2]")
  var confirmAButton: WebElement =_
  //*[@id="app"]/div/div[5]/div/div/div/div[2]/button
  @FindBy(xpath = "//*[@id=\"app\"]/div/div[5]/div/div/div/div[2]/button")
  var activateButton: WebElement =_

  override def getPageLoadCondition: ExpectedCondition[WebElement] = {
    ExpectedConditions.visibilityOf(logo)
  }

  def check(arg0: String): Unit ={
    if (arg0.equals("page_id")) {
      assert(page_itentifier.isDisplayed)
    }
    else if (arg0.equals("save button")){
      assert(saveButton.isDisplayed)
    }
    else if (arg0.equals("active status")){
      assert(active_status.isDisplayed)
    }
    else if (arg0.equals("inactive status")){
      assert(inactive_status.isDisplayed)
    }
    else if (arg0.equals("deactivate button")){
      assert(deactivateButton.isDisplayed)
    }
    else if (arg0.equals("activate button")){
      assert(activateButton.isDisplayed)
    }
    else if (arg0.equals("confirm d button")){
      Thread.sleep(5000)
      assert(confirmDButton.isDisplayed)
    }
    else if (arg0.equals("confirm a button")){
      Thread.sleep(5000)
      assert(confirmAButton.isDisplayed)
    }
  }

  def click(arg0: String): Unit = {
    if (arg0.equals("View Users")){
      viewUsersButton.click()
    }
    else if (arg0.equals("Pencil")){
      pencil.click()
      assert(cancelButton.isDisplayed)
    }
    else if (arg0.equals("Pencil 2")){
      pencil2.click()
      assert(complexity.isDisplayed)
    }
    else if (arg0.equals("Cancel")){
      cancelButton.click()
    }
    else if (arg0.equals("Deactivate")){
      deactivateButton.click()
    }
    else if (arg0.equals("Activate")){
      Thread.sleep(2000)
      activateButton.click()
    }
    else if (arg0.equals("Confirm D")){
      confirmDButton.click()
      Thread.sleep(1000)
    }
    else if (arg0.equals("Confirm A")){
      confirmAButton.click()
      Thread.sleep(1000)
    }
  }

  def enter(arg0: String): Unit ={
    addressBar.sendKeys(arg0)
  }
}
