package com.DemoQA.qa.PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.DemoQA.qa.Base.BaseTest;

public class Elements extends BaseTest{
	
	Actions actions = new Actions(driver);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	@FindBy(xpath="(//span[@class=\'group-header\'])[position()=1]")
	WebElement headerElement;
	
	@FindBy(xpath="(//li[@id=\'item-0\'])[position()=1]")
	WebElement Textbox;
	
	@FindBy(id="userName")
	WebElement username;
	
	@FindBy(id="userEmail")
	WebElement mail;
	
	@FindBy(id="currentAddress")
	WebElement Caddress;
	
	@FindBy(id="permanentAddress")
	WebElement Paddress;
	
	@FindBy(id="submit")
	WebElement submitbutton;
	
	public Elements() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void textBoxForm(String Name, String Mail,String CurrentAddress, String PermanentAddress) {
	
		Textbox.click();
		username.sendKeys(Name);
		mail.sendKeys(Mail);
		Caddress.sendKeys(CurrentAddress);
		Paddress.sendKeys(PermanentAddress);
		 js.executeScript("window.scrollBy(0,250)", "");
		 actions.moveToElement(submitbutton).build().perform();
		 submitbutton.click();
	}

}
