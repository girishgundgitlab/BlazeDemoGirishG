package com.blazedemo.page;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class MasterPage {

	public static WebDriver driver;
	public Properties prop;
	public MasterPage() throws IOException {
		FileInputStream ip=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\com\\blazedemo\\OR\\OR.properties");
		prop=new Properties();
		prop.load(ip);
		
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		
		if(prop.getProperty("browser").equalsIgnoreCase("ff")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\java\\com\\blazedemo\\drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(prop.getProperty("browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\java\\com\\blazedemo\\drivers\\chromedriver.exe");
			driver=new ChromeDriver(option);			
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://blazedemo.com/");
	}
	
	public void sendData(String xKey,String userData) {
		driver.findElement(By.xpath(prop.getProperty(xKey))).sendKeys(userData);
	}
	
	public void click(String xKey) {
		driver.findElement(By.xpath(prop.getProperty(xKey))).click();
	}
	
	public void selectDropDown(String xKey,String userData) {
		WebElement cityDrop=driver.findElement(By.xpath(prop.getProperty(xKey)));
		Select city=new Select(cityDrop);
		city.selectByValue(userData);
	}
	
	public boolean isIdPresent(String xKey) {
		try {
			driver.findElement(By.xpath(prop.getProperty(xKey)));
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}
	
}

	
	
	
	
	
	
	