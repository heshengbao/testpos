package com.msa.ims.pos.pages

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.{ExpectedConditions, ExpectedCondition}

/**
  * Created by mkutilek on 6/6/2016.
  */
class SubmissionHistory extends Base[SubmissionHistory]{
  def initPage: SubmissionHistory = {
    Thread.sleep(2000)
    new SubmissionHistory().initPage(classOf[SubmissionHistory])
  }

  @FindBy(xpath = "//*[@id=\"navbar\"]/nav/div/div[1]/img")
  var logo: WebElement =_

  @FindBy(xpath = "//*[@id=\"app\"]/div/div[1]/span[3]")
  var page_itentifier: WebElement =_

  @FindBy(css = "a[href='/files/#/submitters/757c20bc-efec-4870-9e43-cd00a9b09735/test-files']")
  var next_page: WebElement =_

  @FindBy(css = "a[href='#/submitters/757c20bc-efec-4870-9e43-cd00a9b09735/files/9232ac8c-6c04-4744-90c8-e552b473b98b/transaction-summary']")
  var transaction_summary: WebElement =_

  @FindBy(css = "a[href='#/submitters/757c20bc-efec-4870-9e43-cd00a9b09735/files/9232ac8c-6c04-4744-90c8-e552b473b98b/error-groups']")
  var errors: WebElement =_

  override def getPageLoadCondition: ExpectedCondition[WebElement] = {
    ExpectedConditions.visibilityOf(logo)
  }

  def check(): Unit ={
    assert(page_itentifier.isDisplayed)
  }

  def click(arg0: String): Unit ={
    if (arg0.equals("transaction summary")){
      transaction_summary.click()
    }
    else if (arg0.equals("testing")){
      next_page.click()
    }
    else if (arg0.equals("errors")){
      errors.click()
    }
  }
}
