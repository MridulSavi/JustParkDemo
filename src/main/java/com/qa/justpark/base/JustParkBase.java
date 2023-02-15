package com.qa.justpark.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JustParkBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public JustParkBase() {
		
		try {
			prop= new Properties();
			FileInputStream ip = new FileInputStream("C:\\Users\\mridul.vashistha\\eclipse-workspace\\JustPark\\src\\main\\java\\com\\qa\\justpark\\config\\config.properties");
			prop.load(ip);
			
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {
		
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\mridul.vashistha\\eclipse-workspace\\JustPark\\src\\main\\java\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(prop.getProperty("url"));
		}
		
		
	}
}
