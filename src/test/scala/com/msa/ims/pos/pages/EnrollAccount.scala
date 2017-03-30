package com.msa.ims.pos.pages

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.{ExpectedConditions, ExpectedCondition}

/**
  * Created by mkutilek on 6/6/2016.
  */
class EnrollAccount extends Base[EnrollAccount]{
  def initPage: EnrollAccount = {
    Thread.sleep(2000)
    new EnrollAccount().initPage(classOf[EnrollAccount])
  }

  @FindBy(xpath = "//*[@id=\"navbar\"]/nav/div/div[1]/img")
  var logo: WebElement =_

  @FindBy(id = "retailer-search")
  var searchBar: WebElement =_

  @FindBy(css = "a[href='#/retailers/create/0']")
  var rjRetailerLink: WebElement =_

  override def getPageLoadCondition: ExpectedCondition[WebElement] = {
    ExpectedConditions.visibilityOf(logo)
  }

  def search(): Unit = {
    searchBar.sendKeys("7-eleven corporation")
  }

  def check(): Unit = {
    assert(rjRetailerLink.isDisplayed)
  }

  def click(): Unit ={
    rjRetailerLink.click()
  }


}
