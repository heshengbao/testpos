package com.msa.ims.pos.pages

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.{ExpectedConditions, ExpectedCondition}

/**
  * Created by mkutilek on 6/22/2016.
  */
class ChangePassword extends Base[ChangePassword] {
  def initPage: ChangePassword = {
    Thread.sleep(2000)
    new ChangePassword().initPage(classOf[ChangePassword])
  }

  @FindBy(xpath = "//*[@id=\"navbar\"]/nav/div/div[1]/img")
  var logo: WebElement =_

  @FindBy(className = "progress")
  var page_itentifier: WebElement =_

  @FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div/div/form/div[1]/div[1]/div/input")
  var passField: WebElement =_

  @FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div/div/form/div[1]/div[2]/div/input")
  var confirmField: WebElement =_

  @FindBy(className = "btn-primary")
  var changeButton: WebElement =_

  override def getPageLoadCondition: ExpectedCondition[WebElement] = {
    ExpectedConditions.visibilityOf(logo)
  }

  def check(arg0: String): Unit ={
    if (arg0.equals("page_id")){
      assert(page_itentifier.isDisplayed)
    }
    else if (arg0.equals("change button")){
      assert(changeButton.isEnabled)
    }
  }

  def enterPass(arg0: String): Unit ={
    passField.sendKeys(arg0)
    confirmField.sendKeys(arg0)
  }
}
