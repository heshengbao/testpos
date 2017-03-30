package com.msa.ims.pos.pages

import org.openqa.selenium.{By, WebElement}
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.{WebDriverWait, ExpectedConditions, ExpectedCondition}

/**
  * Created by mkutilek on 6/6/2016.
  */
class Testing extends Base[Testing]{
  def initPage: Testing = {
    Thread.sleep(2000)
    new Testing().initPage(classOf[Testing])
  }

  @FindBy(xpath = "//*[@id=\"navbar\"]/nav/div/div[1]/img")
  var logo: WebElement =_

  @FindBy(xpath = "//*[@id=\"app\"]/div/div[1]/span[3]")
  var page_itentifier: WebElement =_

  @FindBy(css = "a[href='/accounts/#/users/757c20bc-efec-4870-9e43-cd00a9b09735/list/active']")
  var next_page: WebElement =_

  @FindBy(css = "a[href='#/submitters/757c20bc-efec-4870-9e43-cd00a9b09735/files/39174e3b-0450-4fd6-a135-62d35583c270/conversation']")
  var commentsButton: WebElement =_

  @FindBy(css = "a[href='#/submitters/757c20bc-efec-4870-9e43-cd00a9b09735/files/f6d013cf-02fe-4e22-acab-f8f3279a6939/transaction-summary']")
  var transaction_summary: WebElement =_

  @FindBy(css = "a[href='#/submitters/757c20bc-efec-4870-9e43-cd00a9b09735/files/f6d013cf-02fe-4e22-acab-f8f3279a6939/error-groups']")
  var errorsButton: WebElement =_

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
    else if (arg0.equals("errors")){
      //Driver.element = new WebDriverWait(Driver.getDriver, 30).until(ExpectedConditions.elementToBeClickable(commentsButton))
      errorsButton.click()
    }
    else if (arg0.equals("active users")){
      next_page.click()
    }
    else if (arg0.equals("comments")){
      //Thread.sleep(2000)
      //Driver.element = new WebDriverWait(Driver.getDriver, 30).until(ExpectedConditions.elementToBeClickable(commentsButton))
      commentsButton.click()
    }
  }
}
