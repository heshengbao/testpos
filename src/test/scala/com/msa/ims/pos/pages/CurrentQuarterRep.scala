package com.msa.ims.pos.pages

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.{ExpectedConditions, ExpectedCondition}

/**
  * Created by mkutilek on 6/23/2016.
  */
class CurrentQuarterRep extends Base[CurrentQuarterRep]{
  def initPage: CurrentQuarterRep = {
    Thread.sleep(2000)
    new CurrentQuarterRep().initPage(classOf[CurrentQuarterRep])
  }

  @FindBy(xpath = "//*[@id=\"navbar\"]/nav/div/div[1]/img")
  var logo: WebElement =_

  @FindBy(xpath = "//*[@id=\"app\"]/div/div[1]/span[3]")
  var page_itentifier: WebElement =_

  @FindBy(xpath = "//*[@id=\"bs-example-navbar-collapse-1\"]/ul[2]/li[1]/a")
  var errorsTab: WebElement =_

  @FindBy(css = "a[href='/files/#/submitters/79c0f2da-f34c-477d-bbd0-8e547b1db749/files-by-quarter/0']")
  var currentQuarterLink: WebElement =_

  @FindBy(css = "a[href='/files/#/submitters/79c0f2da-f34c-477d-bbd0-8e547b1db749/files-by-quarter/-1']")
  var lastQuarterLink: WebElement =_

  @FindBy(css = "a[href='/files/#/submitters/79c0f2da-f34c-477d-bbd0-8e547b1db749/test-files']")
  var testingTab: WebElement =_

  override def getPageLoadCondition: ExpectedCondition[WebElement] = {
    ExpectedConditions.visibilityOf(logo)
  }

  def click(arg0: String): Unit ={
    if (arg0.equals("errors")){
      errorsTab.click()
    }
    else if (arg0.equals("testing")){
      testingTab.click()
    }
  }

  def check(arg0: String): Unit ={
    if (arg0.equals("page_id")){
      assert(page_itentifier.isDisplayed)
    }
    else if (arg0.equals("current quarter link")){
      assert(currentQuarterLink.isDisplayed)
    }
    else if (arg0.equals("last quarter link")){
      assert(lastQuarterLink.isDisplayed)
    }
  }
}
