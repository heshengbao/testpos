package com.msa.ims.pos.pages

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.{ExpectedConditions, ExpectedCondition}

/**
  * Created by mkutilek on 6/6/2016.
  */
class CurrentQuarter extends Base[CurrentQuarter] {
  def initPage: CurrentQuarter = {
    Thread.sleep(2000)
    new CurrentQuarter().initPage(classOf[CurrentQuarter])
  }

  @FindBy(xpath = "//*[@id=\"navbar\"]/nav/div/div[1]/img")
  var logo: WebElement =_

  @FindBy(xpath = "//*[@id=\"app\"]/div/div[1]/span[3]")
  var page_itentifier: WebElement =_

  @FindBy(css = "a[href='/files/#/submitters/757c20bc-efec-4870-9e43-cd00a9b09735/files-by-quarter/-1']")
  var next_page: WebElement =_ //last quarter

  @FindBy(css = "a[href='/files/#/submitters/757c20bc-efec-4870-9e43-cd00a9b09735/test-files']")
  var testing: WebElement =_

  @FindBy(css = "a[href='/accounts/#/retailers/detail/757c20bc-efec-4870-9e43-cd00a9b09735']")
  var accountinfo: WebElement =_

  @FindBy(css = "a[href='#/submitters/757c20bc-efec-4870-9e43-cd00a9b09735/transaction-summary/from/2017-03-06/to/2017-03-12']")
  var transaction_summary: WebElement =_

  @FindBy(css = "a[href='#/submitters/757c20bc-efec-4870-9e43-cd00a9b09735/files-from/2017-03-06/to/2017-03-12']")
  var attached_files: WebElement =_

  override def getPageLoadCondition: ExpectedCondition[WebElement] = {
    ExpectedConditions.visibilityOf(logo)
  }

  def check(): Unit = {
    assert(page_itentifier.isDisplayed)
  }

  def click(arg0: String): Unit ={
    if (arg0.equals("transaction summary")){
      transaction_summary.click()
    }
    else if (arg0.equals("attached files")){
      attached_files.click()
    }
    else if (arg0.equals("comments")){

    }
    else if (arg0.equals("last quarter")){
      next_page.click()
    }
    else if (arg0.equals("testing")){
      testing.click()
    }
    else if (arg0.equals("account info")){
      accountinfo.click()
    }
  }
}
