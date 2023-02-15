package com.qa.justpark.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.qa.justpark.base.JustParkBase;

public class JustParkHomePage extends JustParkBase {

	
	public JustParkHomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String GetTitle() throws InterruptedException {
		Thread.sleep(5000);
		return driver.getTitle();
		
	}
	
	public void ClickOnSearchTextBox() {
		driver.findElement(By.id("search-box")).click();
	}

	public void EnterValueOnSearchTextBox(String city) throws InterruptedException {
		driver.findElement(By.id("search-box")).sendKeys(city);
		Thread.sleep(7000);
		driver.findElement(By.id("search-box")).sendKeys(Keys.RETURN);
		//driver.findElement(By.xpath("//input[@value='London, UK']")).click();
		
	}
	
	public void SelectStartDate() throws InterruptedException {
		driver.findElement(By.xpath("//span[@data-cy='booking-start-date']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//td[@aria-label='Tuesday, August 9, 2022']")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@data-cy='datepicker-close-button']")).click();
		driver.findElement(By.xpath("//button[@data-cy='searchform-submit']")).click();
		
	}
}

