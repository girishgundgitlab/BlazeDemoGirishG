package com.blazedemo.Pages;

import java.io.IOException;

import com.blazedemo.page.MasterPage;

public class FindFilghtsPage extends MasterPage {

	public FindFilghtsPage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}


	public void findFlights(String deparCity,String destCity) {
		selectDropDown("departureCity_drp",deparCity);
		selectDropDown("destinationCity_drp",destCity);
		click("findFlight_btn");
		click("chooseFlight_btn");
	}
	
	public boolean purchaseFlight() {
		sendData("name_txt", "Jonh");
		sendData("address_txt", "A-101,ABC Apt");
		sendData("city_txt", "Pune");
		sendData("state_txt", "MH");
		sendData("zipCode_txt", "410271");
		sendData("creditCard_txt","1234512345");
		sendData("month_txt", "5");
		sendData("year_txt", "2021");
		sendData("nameOnCard_txt", "Jonh Smith");
		click("purchaseFlight_btn");
		return isIdPresent("idPresent");
	}
	
	
}
