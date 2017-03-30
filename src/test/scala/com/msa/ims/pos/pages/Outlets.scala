package com.msa.ims.pos.pages

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.{ExpectedConditions, ExpectedCondition}

/**
  * Created by mkutilek on 6/10/2016.
  */
class Outlets extends Base[Outlets]{
  def initPage: Outlets = {
    Thread.sleep(2000)
    new Outlets().initPage(classOf[Outlets])
  }

  @FindBy(xpath = "//*[@id=\"navbar\"]/nav/div/div[1]/img")
  var logo: WebElement =_

  @FindBy(xpath = "//*[@id=\"app\"]/div/div[1]/span[5]")
  var page_id: WebElement =_

  @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div[1]/button[2]")
  var missingButton: WebElement =_

  @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/div[1]/button[1]")
  var reportedButton: WebElement =_

  @FindBy(xpath = "//*[@id=\"app\"]/div/div[4]/div[1]/div/div/div")
  var anOutlet: WebElement =_

  @FindBy(className = "form-control")
  var searchBar: WebElement =_

  override def getPageLoadCondition: ExpectedCondition[WebElement] = {
    ExpectedConditions.visibilityOf(logo)
  }

  def click(arg0: String): Unit ={
    if (arg0.equals("missing")){
      missingButton.click()
    }
    else if (arg0.equals("reported")){
      reportedButton.click()
    }
  }

  def check(arg0: String): Unit = {
    if (arg0.equals("page_id")) {
      assert(page_id.isDisplayed)
      //missingButton.click()
    }
    else if (arg0.equals("reported")){
      assert(reportedButton.isDisplayed)
    }
    else if (arg0.equals("missing")){
      assert(missingButton.isDisplayed)
    }
    else if (arg0.equals("an outlet")){
      assert(anOutlet.isDisplayed)
    }
    else if (arg0.equals("not an outlet")){
      try{
        assert(!anOutlet.isDisplayed)
      }
      catch{
        case ex: org.openqa.selenium.NoSuchElementException => assert(true)
      }
    }
  }

  def search(arg0: String): Unit ={
      searchBar.sendKeys(arg0)
  }
}
