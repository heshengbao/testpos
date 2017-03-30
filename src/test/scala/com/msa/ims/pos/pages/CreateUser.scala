package com.msa.ims.pos.pages

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.{ExpectedConditions, ExpectedCondition}

/**
  * Created by mkutilek on 6/21/2016.
  */
class CreateUser extends Base[CreateUser] {
  def initPage: CreateUser = {
    Thread.sleep(2000)
    new CreateUser().initPage(classOf[CreateUser])
  }

  @FindBy(xpath = "//*[@id=\"navbar\"]/nav/div/div[1]/img")
  var logo: WebElement =_

  @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[1]/div/div/div/div/span[3]")
  var page_itentifier: WebElement =_

  @FindBy(className = "btn-primary")
  var createButton: WebElement =_

  @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[1]/form/div[1]/div[1]/div/input")
  var fnameField: WebElement =_

  @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[1]/form/div[1]/div[2]/div/input")
  var mnameField: WebElement =_

  @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[1]/form/div[2]/div[1]/div/input")
  var lnameField: WebElement =_

  @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[1]/form/div[2]/div[2]/div/input")
  var titleField: WebElement =_

  @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[1]/form/div[3]/div[1]/div/input")
  var emailField: WebElement =_

  @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[1]/form/div[3]/div[2]/div/input")
  var phoneField: WebElement =_


  override def getPageLoadCondition: ExpectedCondition[WebElement] = {
    ExpectedConditions.visibilityOf(logo)
  }

  def check(arg0: String): Unit ={
    if (arg0.equals("page_id")) {
      assert(page_itentifier.isDisplayed)
    }
    else if (arg0.equals("create button")){
      try{
        assert(!createButton.isEnabled)
      }
      catch{
        case ex: org.openqa.selenium.NoSuchElementException => assert(true)
      }
    }
  }

  def click(arg0: String): Unit ={
    if (arg0.equals("create")){
      createButton.click()
    }
  }

  def enterInfo(): Unit ={
    titleField.sendKeys("This won't work")
    emailField.sendKeys("dontwork@dontwork.com")
    phoneField.sendKeys("4129999999")
  }

  def enterFullInfo(): Unit ={
    fnameField.sendKeys("Tester")
    mnameField.sendKeys("Ann")
    lnameField.sendKeys("Zzz")
    titleField.sendKeys("Test Engineering Manager")
    emailField.sendKeys("tester@testing.com")
    phoneField.sendKeys("412-924-3243")
  }
}
