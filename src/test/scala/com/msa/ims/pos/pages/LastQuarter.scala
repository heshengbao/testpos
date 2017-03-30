package com.msa.ims.pos.pages

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.{ExpectedConditions, ExpectedCondition}

/**
  * Created by mkutilek on 6/6/2016.
  */
class LastQuarter extends Base[LastQuarter]{
  def initPage: LastQuarter = {
    Thread.sleep(2000)
    new LastQuarter().initPage(classOf[LastQuarter])
  }

  @FindBy(xpath = "//*[@id=\"navbar\"]/nav/div/div[1]/img")
  var logo: WebElement =_

  @FindBy(xpath = "//*[@id=\"app\"]/div/div[1]/span[3]")
  var page_itentifier: WebElement =_

  @FindBy(css = "a[href='/files/#/submitters/757c20bc-efec-4870-9e43-cd00a9b09735/live-files']")
  var next_page: WebElement =_

  @FindBy(css = "a[href='#/submitters/757c20bc-efec-4870-9e43-cd00a9b09735/transaction-summary/from/2016-12-26/to/2017-01-01']")
  var transaction_summary: WebElement =_
  //*[@id="app"]/div/div[3]/div[1]/div[2]/div/div[2]/div/a[2]
  @FindBy(css = "a[href='#/submitters/757c20bc-efec-4870-9e43-cd00a9b09735/files-from/2016-12-26/to/2017-01-01']")
  var attached_files: WebElement =_

  @FindBy(xpath = "//*[@id=\"app\"]/div/div[3]/div[1]/div[1]/span")
  var date: WebElement =_

  override def getPageLoadCondition: ExpectedCondition[WebElement] = {
    ExpectedConditions.visibilityOf(logo)
  }

  def check(arg0: String): Unit ={
    if (arg0.equals("page_id")) {
      assert(page_itentifier.isDisplayed)
    }
    else if (arg0.equals("the date")){
      assert(date.isDisplayed)
    }
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
    else if (arg0.equals("submission history")){
      next_page.click()
    }
  }
}
