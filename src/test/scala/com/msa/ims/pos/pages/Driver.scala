package com.msa.ims.pos.pages

import com.typesafe.config.ConfigFactory
import org.openqa.selenium.{WebElement, WebDriver}
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.edge.EdgeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.ie.InternetExplorerDriver
import org.scalatest.selenium.Firefox

/**
  * Created by mkutilek on 5/31/2016.
  */
object Driver {
/*
  var driver: WebDriver = _

  def getDriver: WebDriver = {
    if (driver == null) {
      val _path = "webdrivers/Windows/chromedriver.exe"
      System.setProperty("webdriver.chrome.driver", _path)
      driver = new ChromeDriver()
    }
    driver
  }
  */

  var driver: WebDriver = _
  var element: WebElement =_
  val _os = System.getProperty("os.name")
  val browser = ConfigFactory.load.getString("my.browser.type")

  def getDriver: WebDriver = browser match {
    case "firefox" =>
      if (driver.eq(null)) {
        driver = new FirefoxDriver()
      }
      driver
    case "chrome" =>
      if (_os.contains("Linux")) {
        val _path = "webdrivers/Linux/chromedriver"
        System.setProperty("webdriver.chrome.driver", _path)
      }
      else if (_os.startsWith("Windows")) {
        val _path = "webdrivers/Windows/chromedriver.exe"
        System.setProperty("webdriver.chrome.driver", _path)
      }
      if (driver.eq(null)) {
        driver = new ChromeDriver()
      }
      driver
    case "ie11" =>
      val _path = "webdrivers/Windows/IEDriverServer.exe"
      System.setProperty("webdriver.ie.driver", _path)
      if (driver.eq(null)) {
        driver = new InternetExplorerDriver()
      }
      driver
    case "edge" =>
      val _path = "webdrivers/Windows/MicrosoftWebDriver.exe"
      System.setProperty("webdriver.edge.driver", _path)
      if (driver.eq(null)) {
        driver = new EdgeDriver()
      }
      driver
    case _ => null
  }

  def close(): Unit ={
    driver.close()
  }
}
