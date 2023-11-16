package com.DemoQA.qa.PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.DemoQA.qa.Base.BaseTest;

public class HomePage extends BaseTest {
	Actions actions = new Actions(driver);
	JavascriptExecutor js = (JavascriptExecutor) driver;

	
	@FindBy(xpath="//div[@class=\'card mt-4 top-card\'][1]")
	WebElement elementbox;
	@FindBy(xpath="//div[@class=\'card mt-4 top-card\'][4]")
	WebElement widgets;
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validaHometitle() {
		return driver.getTitle();
	}
	 public Elements clickElements() {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,250)", "");
		 actions.moveToElement(elementbox).build().perform();
	    elementbox.click();
		 return new Elements();
	 }
	 public Widgets clicWidgets() {
		 js.executeScript("window.scrollBy(0,250)", "");
		 actions.moveToElement(widgets).build().perform();
		widgets.click();
		 return new Widgets();
	 }
	
	

}
