package com.msa.ims.pos.pages

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.{ExpectedConditions, ExpectedCondition}

/**
  * Created by mkutilek on 6/9/2016.
  */
class January extends Base[January] {
  def initPage: January = {
    Thread.sleep(2000)
    new January().initPage(classOf[January])
  }

  @FindBy(xpath = "//*[@id=\"navbar\"]/nav/div/div[1]/img")
  var logo: WebElement =_

  @FindBy(xpath = "//*[@id=\"app\"]/div/div[1]/span[3]")
  var page_id: WebElement =_

  @FindBy(className = "btn-primary")
  var viewDaysButton: WebElement =_

  @FindBy(xpath = "//*[@id=\"app\"]/div/div[5]/div[2]/table/thead/tr/th[1]")
  var trans_id: WebElement =_

  @FindBy(xpath = "//*[@id=\"app\"]/div/div[5]/div[1]/div[1]/div[2]/div")
  var hideDaysButton: WebElement =_

  override def getPageLoadCondition: ExpectedCondition[WebElement] = {
    ExpectedConditions.visibilityOf(logo)
  }

  def check(): Unit = {
    assert(page_id.isDisplayed)
  }

  def click(): Unit ={
    viewDaysButton.click()
    assert(trans_id.isDisplayed)
    hideDaysButton.click()
  }
}
