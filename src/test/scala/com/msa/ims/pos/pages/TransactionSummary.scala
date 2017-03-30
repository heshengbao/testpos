package com.msa.ims.pos.pages

import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.{ExpectedConditions, ExpectedCondition}

/**
  * Created by mkutilek on 6/7/2016.
  */
class TransactionSummary extends Base[TransactionSummary]{
  def initPage: TransactionSummary = {
    Thread.sleep(2000)
    new TransactionSummary().initPage(classOf[TransactionSummary])
  }

  @FindBy(xpath = "//*[@id=\"navbar\"]/nav/div/div[1]/img")
  var logo: WebElement =_
  //*[@id="app"]/div/div[2]/div/table/thead/tr/th[1]
  @FindBy(xpath = "//*[@id=\"app\"]/div/div[1]")
  var page_id: WebElement =_
  //*[@id="app"]/div/div[1]/a[2]
  @FindBy(xpath = "//*[@id=\"app\"]/div/div[1]/a")
  var last_page: WebElement =_

  @FindBy(xpath = "//*[@id=\"app\"]/div/div[1]/a[2]")
  var last_page2: WebElement =_

  @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/table/tbody/tr/td[4]/a")
  var outlet: WebElement =_

  @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/table/thead/tr/th[3]")
  var no_trans: WebElement =_

  @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/table/thead/tr/th[4]")
  var outlets: WebElement =_

  @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/table/thead/tr/th[6]")
  var quantity: WebElement =_

  @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/table/thead/tr/th[7]")
  var dollars: WebElement =_

  @FindBy(xpath = "//*[@id=\"app\"]/div/div[1]/span[4]")
  var element_title: WebElement =_

  @FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/div/table/tbody/tr/td[1]")
  var element_date: WebElement =_

  override def getPageLoadCondition: ExpectedCondition[WebElement] = {
    ExpectedConditions.visibilityOf(logo)
  }

  def check(arg0: String): Unit ={
    if (arg0.equals("page_id")) {
      assert(page_id.isDisplayed)
    }
    else if (arg0.equals("the date")){
      assert(element_date.isDisplayed)
    }
    else if (arg0.equals("transactions")){
      assert(no_trans.isDisplayed)
    }
    else if (arg0.equals("outlets")){
      assert(outlets.isDisplayed)
    }
    else if (arg0.equals("quantity")){
      assert(quantity.isDisplayed)
    }
    else if (arg0.equals("dollars")){
      assert(dollars.isDisplayed)
    }
    else if (arg0.equals("quant not 0")){
      assert(quantity.getAttribute("value") != "0")
    }
    else if (arg0.equals("dollars not 0")){
      assert(dollars.getAttribute("value") != "0")
    }
    else if (arg0.equals("date matches")){
      val _title = element_title.getText
      val _date = element_date.getText
      assert(_date.equals(_title.split("\\s+"){0}))
    }
  }

  def click(arg0: String): Unit ={
    if (arg0.equals("prev page")){
      last_page.click()
    }
    else if (arg0.equals("prev page 2")){
      last_page2.click()
    }
    else if (arg0.equals("outlet")){
      outlet.click()
    }
  }
}
