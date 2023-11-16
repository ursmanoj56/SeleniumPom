package com.DemoQA.qa.Testcases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.DemoQA.qa.Base.BaseTest;
import com.DemoQA.qa.PageObjects.Elements;
import com.DemoQA.qa.PageObjects.HomePage;
import com.DemoQA.qa.Util.ExcelUtil;



public class ElementPageTest extends BaseTest {
	HomePage homepage;
	Elements elements;
	
	@BeforeMethod
	public void setUp() {
		launchApp();
		homepage=new HomePage();
		elements=new Elements();
	}
	
	@DataProvider(name="userdetails")
	public Object[][] excelDataProvider() throws IOException, InvalidFormatException {
		
		Object[][]  data = ExcelUtil.getTestData("G:\\\\eclipse\\\\DemoQa\\\\TestData\\\\TestData1.xlsx", "Sheet1");
		return data;
	}
        
		
	@Test(dataProvider="userdetails")
	public void TextboxTest(String Name,String mail,String CurrentAddress,String PermanentAddress) throws InterruptedException {
		elements=homepage.clickElements();
		Thread.sleep(1000);
		elements.textBoxForm(Name, mail, CurrentAddress, PermanentAddress);
	}
}
