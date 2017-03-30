package com.msa.ims.pos.pages

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.{ExpectedCondition, ExpectedConditions}

/**
  * Created by mkutilek on 5/31/2016.
  */
class Login extends Base[Login] {
  def initPage: Login = {
    navigateToPage("/id/#/login")
    new Login().initPage(classOf[Login])
  }

  @FindBy(id = "email")
  var loginField: WebElement =_

  @FindBy(id = "password")
  var passwordField: WebElement =_

  @FindBy(className = "btn")
  var loginButton: WebElement =_

  @FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div[2]/form/div[3]")
  var loginError: WebElement =_

  override def getPageLoadCondition: ExpectedCondition[WebElement] = {
    ExpectedConditions.visibilityOf(loginField)
  }

  def check(): Unit ={
    Thread.sleep(5000)
    assert(loginField.isDisplayed)
  }

  def login(userName: String, password: String) {
    loginField.sendKeys(userName)
    passwordField.sendKeys(password)
    loginButton.click()
  }
  def enterCredentials(userName: String, password: String): Unit ={
    loginField.sendKeys(userName)
    passwordField.sendKeys(password)
  }
  def click(): Unit ={
    loginButton.click()
  }

  def clearTheForm(): Unit ={
    loginField.clear()
    passwordField.clear()
  }

  def loginFailed(): Unit ={
    assert(loginError.isDisplayed)
  }
}
