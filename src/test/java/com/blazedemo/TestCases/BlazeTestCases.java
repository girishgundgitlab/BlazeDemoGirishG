package com.blazedemo.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.blazedemo.Pages.FindFilghtsPage;
import com.blazedemo.page.MasterPage;
import com.blazedemo.utilities.ExcelReadingUtility;


public class BlazeTestCases {

	
	FindFilghtsPage fp;
	@Test(dataProvider="providData")
	public void selectCity(String deparCity,String destCity) throws IOException {
		fp=new FindFilghtsPage();
		fp.findFlights(deparCity, destCity);
		Assert.assertTrue(fp.purchaseFlight(),"****Flight Not Booked****");
	}
	
	@DataProvider
	public Object[][] providData() throws IOException {
		return(ExcelReadingUtility.readData("city"));
	}
	
	@AfterMethod
	public void postActivity()
	{
		MasterPage.driver.close();
	}
}
