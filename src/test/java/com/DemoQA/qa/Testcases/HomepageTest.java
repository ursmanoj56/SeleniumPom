package com.DemoQA.qa.Testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.DemoQA.qa.Base.BaseTest;
import com.DemoQA.qa.PageObjects.Elements;
import com.DemoQA.qa.PageObjects.HomePage;
import com.DemoQA.qa.PageObjects.Widgets;


public class HomepageTest extends BaseTest {
	HomePage homepage;
	Elements elements;
	Widgets widgets;
	
	@BeforeMethod
	public void setUp() {
		launchApp();
		homepage=new HomePage();
	}
	@Test
	public void homepageTitleTest() {
		String title=homepage.validaHometitle();
		Assert.assertEquals(title, "DEMOQA");	
	}
	@Test
	public void homeAction1() {
		elements=homepage.clickElements();
		
	}
	@Test
	public void homeAction2() {
	
		widgets=homepage.clicWidgets();
	}

}
