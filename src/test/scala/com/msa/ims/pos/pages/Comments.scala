package com.msa.ims.pos.pages

import org.openqa.selenium.{By, WebElement}
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.{WebDriverWait, ExpectedConditions, ExpectedCondition}

/**
  * Created by mkutilek on 6/7/2016.
  */
class Comments extends Base[Comments] {
  def initPage: Comments = {
    Thread.sleep(2000)
    new Comments().initPage(classOf[Comments])
  }

  @FindBy(xpath = "//*[@id=\"navbar\"]/nav/div/div[1]/img")
  var logo: WebElement =_

  @FindBy(css = "a[href='mailto:chorn@msa.com']")
  var comments: WebElement =_

  @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div[2]/div/div[5]/div[1]/div[2]")
  var date: WebElement =_

  @FindBy(className = "btn-primary")
  var addBtn: WebElement =_

  @FindBy(className = "btn-default")
  var clearBtn: WebElement =_

  @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div[2]/div/div[5]/div[1]/div[1]/a")
  var name: WebElement =_

  @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div[1]/div/textarea")
  var textArea: WebElement =_

  override def getPageLoadCondition: ExpectedCondition[WebElement] = {
    ExpectedConditions.visibilityOf(logo)
  }

  def check(arg0: String): Unit ={
    if (arg0.equals("comments")){
      Driver.element = (new WebDriverWait(Driver.getDriver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[href='mailto:chorn@msa.com']")))
      assert(comments.isDisplayed)
    }
    else if (arg0.equals("the comment box")){
      assert(textArea.isDisplayed)
    }
    else if (arg0.equals("the date")){
      assert(date.isDisplayed)
    }
    else if (arg0.equals("add button")){
      assert(addBtn.isEnabled)
    }
    else if (arg0.equals("clear button")){
      assert(clearBtn.isEnabled)
    }
    else if (arg0.equals("the user name")){
      assert(name.isDisplayed)
    }
  }

  def click(arg0: String): Unit ={
    if (arg0.equals("add button")){
      addBtn.click()
    }
    else if (arg0.equals("clear button")){
      clearBtn.click()
    }
  }

  def addComment(arg0: String): Unit ={
    textArea.sendKeys(arg0)
  }
}
