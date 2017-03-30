package com.msa.ims.pos.pages

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.{ExpectedConditions, ExpectedCondition}

/**
  * Created by mkutilek on 6/9/2016.
  */
class AttachedFiles extends Base[AttachedFiles]{
  def initPage: AttachedFiles = {
    Thread.sleep(2000)
    new AttachedFiles().initPage(classOf[AttachedFiles])
  }

  @FindBy(xpath = "//*[@id=\"navbar\"]/nav/div/div[1]/img")
  var logo: WebElement =_

  @FindBy(xpath = "//*[@id=\"app\"]/div/div[3]/div[1]/div[2]/div/div[2]/div/a[1]")
  var transaction_summary: WebElement =_

  @FindBy(xpath = "//*[@id=\"app\"]/div/div[3]/div[1]/div[2]/div/div[2]/div/a[3]")
  var errors: WebElement =_

  @FindBy(xpath = "//*[@id=\"app\"]/div/div[3]/div[1]/div[1]/span")
  var page_id: WebElement =_

  override def getPageLoadCondition: ExpectedCondition[WebElement] = {
    ExpectedConditions.visibilityOf(logo)
  }

  def check(): Unit = {
    assert(page_id.isDisplayed)
  }

  def click(arg0: String): Unit ={
    if (arg0.equals("transaction summary")){
      transaction_summary.click()
    }
    else if (arg0.equals("comments")){

    }
    else if (arg0.equals("errors")){
      errors.click()
    }
  }
}
