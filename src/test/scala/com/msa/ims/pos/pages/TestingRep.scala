package com.msa.ims.pos.pages

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.{ExpectedConditions, ExpectedCondition}

/**
  * Created by mkutilek on 6/23/2016.
  */
class TestingRep extends Base[TestingRep] {
  def initPage: TestingRep = {
    Thread.sleep(2000)
    new TestingRep().initPage(classOf[TestingRep])
  }

  @FindBy(xpath = "//*[@id=\"navbar\"]/nav/div/div[1]/img")
  var logo: WebElement =_

  @FindBy(xpath = "//*[@id=\"app\"]/div/div[1]/span[3]")
  var page_itentifier: WebElement =_

  @FindBy(className = "dd-6")
  var submitFile_link: WebElement =_

  @FindBy(css = "a[href='/upload/#/file/live']")
  var production_link: WebElement =_

  @FindBy(css = "a[href='/upload/#/file/test']")
  var test_link: WebElement =_

  override def getPageLoadCondition: ExpectedCondition[WebElement] = {
    ExpectedConditions.visibilityOf(logo)
  }

  def check(arg0: String): Unit ={
    if (arg0.equals("page_id")) {
      assert(page_itentifier.isDisplayed)
    }
  }

  def navTo(arg0: String): Unit ={
    if (arg0.equals("production")){
      submitFile_link.click()
      assert(production_link.isDisplayed)
      production_link.click()
    }
    else if (arg0.equals("test")){
      submitFile_link.click()
      assert(test_link.isDisplayed)
      test_link.click()
    }
  }
}
