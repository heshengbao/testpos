package com.msa.ims.pos.pages

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.{ExpectedConditions, ExpectedCondition}

/**
  * Created by mkutilek on 6/9/2016.
  */
class TransactionsByMonth extends Base[TransactionsByMonth]{
  def initPage: TransactionsByMonth = {
    Thread.sleep(2000)
    new TransactionsByMonth().initPage(classOf[TransactionsByMonth])
  }

  @FindBy(xpath = "//*[@id=\"navbar\"]/nav/div/div[1]/img")
  var logo: WebElement =_

  @FindBy(xpath = "//*[@id=\"app\"]/div/div[1]/a/span[1]")
  var page_id: WebElement =_

  @FindBy(xpath = "//*[@id=\"app\"]/div/a[1]/div/div/div/span[1]")
  var januaryLink: WebElement =_

  override def getPageLoadCondition: ExpectedCondition[WebElement] = {
    ExpectedConditions.visibilityOf(logo)
  }

  def check(): Unit = {
    assert(page_id.isDisplayed)
  }

  def click(): Unit ={
    Thread.sleep(2000)
    januaryLink.click()
  }
}
