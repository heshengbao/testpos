package com.msa.ims.pos.pages

import java.util.concurrent.TimeUnit

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.{ExpectedConditions, ExpectedCondition}

/**
  * Created by mkutilek on 6/3/2016.
  */
class Retailers extends Base[Retailers]{
  def initPage: Retailers = {
    Thread.sleep(2000)
    new Retailers().initPage(classOf[Retailers])
  }

  @FindBy(xpath = "//*[@id=\"navbar\"]/nav/div/div[1]/img")
  var logo: WebElement =_

  @FindBy(xpath = "//*[@id=\"bs-example-navbar-collapse-1\"]/ul[1]/li/a/span[1]")
  var email: WebElement =_

  @FindBy(xpath = "//*[@id=\"bs-example-navbar-collapse-1\"]/ul[2]/li[2]/a")
  var reports: WebElement =_
  //*[@id="bs-example-navbar-collapse-1"]/ul[2]/li[3]/a
  @FindBy(xpath = "//*[@id=\"bs-example-navbar-collapse-1\"]/ul[2]/li[3]/a")
  var retailers: WebElement =_

  @FindBy(css = "a[href='/accounts/#/retailers/active']")
  var active_accounts: WebElement =_

  @FindBy(css = "a[href='/accounts/#/retailers/inactive']")
  var inactive_accounts: WebElement =_

  @FindBy(css = "a[href='/accounts/#/retailers/search']")
  var create: WebElement =_

  @FindBy(css = "a[href='/files/#/summary/live']")
  var ytd: WebElement =_

  @FindBy(css = "a[href='/files/#/summary/test']")
  var ytdtest: WebElement =_

  @FindBy(css = "a[href='/accounts/#/users/MSA/list/active']")
  var users: WebElement =_

  @FindBy(css = "a[href='/id/#/logout']")
  var logoutLink: WebElement =_

  @FindBy(id = "retailer-search")
  var searchBar: WebElement =_

  @FindBy(css = "a[href='/files/#/submitters/427acb1c-af0e-4afe-8e30-50bc8c177c65/files-by-quarter/0']")
  var nicksRetailerLink: WebElement =_

  @FindBy(css = "a[href='/files/#/submitters/757c20bc-efec-4870-9e43-cd00a9b09735/files-by-quarter/0']")
  var elevenRetailerLink: WebElement =_

  @FindBy(css = "a[href='/files/#/submitters/c8c8e22a-e6b8-4ae1-849b-d262782cc6b6/files-by-quarter/0']")
  var qualityRetailerLink: WebElement =_

  @FindBy(xpath = "//*[@id=\"app\"]/div/div[1]/div/div/div/div/div")
  var page_id: WebElement =_


  override def getPageLoadCondition: ExpectedCondition[WebElement] = {
    ExpectedConditions.visibilityOf(logo)
  }

  def check(arg0: String): Unit = {
    if (arg0.equals("email")){
      assert(email.isDisplayed)
    }
    else if (arg0.equals("page_id")){
      assert(page_id.isDisplayed)
    }
  }

  def search(arg0: String): Unit ={
    Driver.getDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
    Thread.sleep(5000)
    searchBar.sendKeys(arg0)
    if (arg0.equals("Nicks")){
      nicksRetailerLink.click()
    }
    else if (arg0.equals("7-eleven ")){
      Thread.sleep(1000)
      searchBar.sendKeys("c")
      Thread.sleep(1000)
      searchBar.sendKeys("o")
      Thread.sleep(1000)
      elevenRetailerLink.click()
    }
    else if (arg0.equals("Quality")){
      qualityRetailerLink.click()
    }
  }

  def navTo(arg0: String): Unit ={
    if (arg0.equals("create")){
      retailers.click()
      create.click()
    }
    else if (arg0.equals("active accounts")){
      retailers.click()
      active_accounts.click()
    }
    else if (arg0.equals("inactive accounts")){
      retailers.click()
      inactive_accounts.click()
    }
    else if (arg0.equals("ytd")){
      reports.click()
      ytd.click()
    }
    else if (arg0.equals("ytdtest")){
      reports.click()
      ytdtest.click()
    }
    else if (arg0.equals("users")){
      users.click()
    }
  }

  def logout(): Unit ={
    email.click()
    logoutLink.click()
  }

}
