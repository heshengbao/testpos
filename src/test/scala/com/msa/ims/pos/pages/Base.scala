package com.msa.ims.pos.pages

import java.util.concurrent.TimeUnit

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.ui.{ExpectedCondition, FluentWait}

/**
  * Created by mkutilek on 5/31/2016.
  * Modified by hbao on 8/16/2016.
  */
object Base {
  val BASE_URl = Url.url
  val LOAD_TIMEOUT = 30
  val REFRESH_RATE = 2
}

abstract class Base[T] {

  lazy val webDriver = Driver.getDriver

  def initPage(clazz: Class[T]): T = {
    val page = PageFactory.initElements(Driver.getDriver, clazz)
    val pageLoadCondition = page.asInstanceOf[Base[T]].getPageLoadCondition
    waitForPageToLoad(pageLoadCondition)
    page
  }

  def navigateToPage(url: String) {
    Driver.getDriver.navigate().to(Base.BASE_URl + url)
    Driver.getDriver.manage().window().maximize()
  }

  private def waitForPageToLoad(pageLoadCondition: ExpectedCondition[WebElement]) {
    val wait = new FluentWait(Driver.getDriver).withTimeout(Base.LOAD_TIMEOUT, TimeUnit.SECONDS)
      .pollingEvery(Base.REFRESH_RATE, TimeUnit.SECONDS)
    wait until pageLoadCondition
  }

  def getPageLoadCondition: ExpectedCondition[WebElement]

}

