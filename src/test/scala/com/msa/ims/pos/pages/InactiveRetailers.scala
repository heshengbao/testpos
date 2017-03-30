package com.msa.ims.pos.pages

import java.util.concurrent.TimeUnit

import com.msa.ims.pos.PortalUITestStepDefs
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.{WebDriverWait, ExpectedConditions, ExpectedCondition}

/**
  * Created by mkutilek on 6/3/2016.
  */
class InactiveRetailers extends Base[InactiveRetailers]{
  def initPage: InactiveRetailers = {
    Thread.sleep(2000)
    new InactiveRetailers().initPage(classOf[InactiveRetailers])
  }

  @FindBy(xpath = "//*[@id=\"navbar\"]/nav/div/div[1]/img")
  var logo: WebElement =_

  @FindBy(xpath = "//*[@id=\"bs-example-navbar-collapse-1\"]/ul[1]/li/a/span[1]")
  var email: WebElement =_

  @FindBy(id = "retailer-search")
  var searchBar: WebElement =_

  @FindBy(xpath = "//*[@id=\"app\"]/div/div[1]/div/div/div/div/div")
  var page_id: WebElement =_


  override def getPageLoadCondition: ExpectedCondition[WebElement] = {
    ExpectedConditions.visibilityOf(logo)
  }

  def check(): Unit = {
    assert(page_id.isDisplayed)
  }

}
