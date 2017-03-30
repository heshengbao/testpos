package com.msa.ims.pos.pages

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.{ExpectedConditions, ExpectedCondition}

/**
  * Created by MKutilek on 6/8/2016.
  */
class Errors extends Base[Errors]{
  def initPage: Errors = {
    Thread.sleep(2000)
    new Errors().initPage(classOf[Errors])
  }

  @FindBy(xpath = "//*[@id=\"navbar\"]/nav/div/div[1]/img")
  var logo: WebElement =_

  @FindBy(xpath = "//*[@id=\"app\"]/div/div[1]/span[5]")
  var page_id: WebElement =_

  @FindBy(className = "btn-primary")
  var viewButton: WebElement =_

  @FindBy(className = "btn-default")
  var hideButton: WebElement =_

  override def getPageLoadCondition: ExpectedCondition[WebElement] = {
    ExpectedConditions.visibilityOf(logo)
  }

  def check(arg0: String): Unit ={
    if (arg0.equals("page_id")) {
      //Thread.sleep(1000)
      assert(page_id.isDisplayed)
    }
  }

  def click(): Unit ={
    viewButton.click()
    assert(hideButton.isDisplayed)
  }
}
