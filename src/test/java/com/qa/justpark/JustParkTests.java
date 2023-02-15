package com.qa.justpark;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.justpark.base.JustParkBase;
import com.qa.justpark.pages.JustParkHomePage;

public class JustParkTests extends JustParkBase {

	JustParkHomePage homepage;
	
	public JustParkTests() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		homepage = new JustParkHomePage();
			}
	
	@Test
	public void verifyHomePageTitle() throws InterruptedException {
		
		String homePageTitle = homepage.GetTitle();
        System.out.println(homePageTitle);
		Assert.assertEquals(homePageTitle,"JustPark - The Parking App | Find parking in seconds");
	}
	
	@Test
	public void EnterText() throws InterruptedException {
		homepage.ClickOnSearchTextBox();
		homepage.EnterValueOnSearchTextBox("London");
		homepage.SelectStartDate();
		String justpaarktitle= homepage.GetTitle();
		Assert.assertEquals(justpaarktitle, "London Parkings | Guaranteed Spaces");
	}
	
	
	@AfterMethod
	public void TearDown() {
	driver.quit();
	}
}

