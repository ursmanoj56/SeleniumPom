package com.DemoQA.qa.Actions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import com.DemoQA.qa.Base.BaseTest;

public class Action extends BaseTest {
	
	public void scrollByVisibilityOfElement(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", ele);

	}

}
