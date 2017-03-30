package com.msa.ims.pos.pages

import org.openqa.selenium.{By, WebElement}
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.{ExpectedConditions, ExpectedCondition}

/**
  * Created by mkutilek on 6/9/2016.
  */
class AccountTransactions extends Base[AccountTransactions]{
  def initPage: AccountTransactions = {
    Thread.sleep(2000)
    new AccountTransactions().initPage(classOf[AccountTransactions])
  }

  @FindBy(xpath = "//*[@id=\"navbar\"]/nav/div/div[1]/img")
  var logo: WebElement =_

  @FindBy(xpath = "//*[@id=\"app\"]/div/div[1]/span[1]")
  var page_id: WebElement =_

  @FindBy(className = "form-control")
  var searchBar: WebElement =_

  @FindBy(xpath = "//*[@id=\"app\"]/div/div[3]/a/div/div/span")
  var retailerLink: WebElement =_

  @FindBy(className = "card-content")
  var card: WebElement =_

  override def getPageLoadCondition: ExpectedCondition[WebElement] = {
    ExpectedConditions.visibilityOf(logo)
  }

  def check(arg0: String): Unit = {
    if (arg0.equals("page_id")) {
      assert(page_id.isDisplayed)
    }
    else if (arg0.equals("search bar")){
      assert(searchBar.isDisplayed)
    }
    else if (arg0.equals("no search bar")){
      assert(!searchBar.isDisplayed)
    }
    else if (arg0.equals("card")){
      val elements = webDriver.findElements(By.className("card-content")).size()
      assert(elements == 10)
    }
  }

  def search(arg0: String): Unit = {
    searchBar.sendKeys(arg0)
    assert(retailerLink.isDisplayed)
    retailerLink.click()
  }
}
