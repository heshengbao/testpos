package com.msa.ims.pos.pages

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.{ExpectedConditions, ExpectedCondition}

/**
  * Created by mkutilek on 6/6/2016.
  */
class ActiveUsers extends Base[ActiveUsers]{
  def initPage: ActiveUsers = {
    Thread.sleep(2000)
    new ActiveUsers().initPage(classOf[ActiveUsers])
  }

  @FindBy(xpath = "//*[@id=\"navbar\"]/nav/div/div[1]/img")
  var logo: WebElement =_
  //*[@id="app"]/div/div/div[1]/div/div/div/div/span   //*[@id="app"]/div/div/div[1]/div/div/div/div/span/text()[1]
  @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[1]/div/div/div/div/span")
  var page_itentifier: WebElement =_

  @FindBy(css = "a[href='/accounts/#/retailers/detail/757c20bc-efec-4870-9e43-cd00a9b09735']")
  var next_page: WebElement =_

  @FindBy(className = "glyphicon-pencil")
  var pencil: WebElement =_

  @FindBy(className = "btn-primary")
  var save: WebElement =_

  @FindBy(className = "btn-sm")
  var create: WebElement =_

  @FindBy(className = "btn-default")
  var cancel: WebElement =_

  @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[4]/div/div[1]/div[2]/form/div[1]/div/button")
  var createPass: WebElement =_

  override def getPageLoadCondition: ExpectedCondition[WebElement] = {
    ExpectedConditions.visibilityOf(logo)
  }

  def check(arg0: String): Unit ={
    if (arg0.equals("page_id")) {
      assert(page_itentifier.isDisplayed)
    }
    else if (arg0.equals("the save button")){
      assert(save.isDisplayed)
    }
  }

  def click(arg0: String): Unit ={
    if (arg0.equals("Account Info")){
      next_page.click()
    }
    else if (arg0.equals("Pencil")){
      pencil.click()
      assert(save.isDisplayed)
    }
    else if (arg0.equals("Create")){
      create.click()
      assert(cancel.isDisplayed)
    }
    else if (arg0.equals("Create New Password")){
      createPass.click()
    }
  }
}
