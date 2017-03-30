package com.msa.ims.pos.pages

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.{ExpectedConditions, ExpectedCondition}

/**
  * Created by MKutilek on 6/8/2016.
  */
class EnrollRetailer extends Base[EnrollRetailer]{
  def initPage: EnrollRetailer = {
    Thread.sleep(2000)
    new EnrollRetailer().initPage(classOf[EnrollRetailer])
  }

  @FindBy(xpath = "//*[@id=\"navbar\"]/nav/div/div[1]/img")
  var logo: WebElement =_

  @FindBy(className = "btn-default")
  var enrollButton: WebElement =_

  override def getPageLoadCondition: ExpectedCondition[WebElement] = {
    ExpectedConditions.visibilityOf(logo)
  }

  def check(): Unit ={
    assert(enrollButton.isDisplayed)
  }
}
