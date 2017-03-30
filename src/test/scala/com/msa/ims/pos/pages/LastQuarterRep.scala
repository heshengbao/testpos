package com.msa.ims.pos.pages

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.{ExpectedConditions, ExpectedCondition}

/**
  * Created by mkutilek on 6/23/2016.
  */
class LastQuarterRep extends Base[LastQuarterRep]{
  def initPage: LastQuarterRep = {
    Thread.sleep(2000)
    new LastQuarterRep().initPage(classOf[LastQuarterRep])
  }

  @FindBy(xpath = "//*[@id=\"navbar\"]/nav/div/div[1]/img")
  var logo: WebElement =_

  @FindBy(xpath = "//*[@id=\"app\"]/div/div[1]/span[3]")
  var page_itentifier: WebElement =_

  override def getPageLoadCondition: ExpectedCondition[WebElement] = {
    ExpectedConditions.visibilityOf(logo)
  }

  def check(arg0: String): Unit ={
    if (arg0.equals("page_id")) {
      assert(page_itentifier.isDisplayed)
    }
  }
}
