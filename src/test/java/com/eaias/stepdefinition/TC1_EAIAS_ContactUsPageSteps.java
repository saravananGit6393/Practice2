package com.eaias.stepdefinition;

import com.eaias.baseclass.CuEAIASBaseClass;
import com.eaias.pageobjectmanager.PageObjectManager;


import io.cucumber.java.en.*;

public class TC1_EAIAS_ContactUsPageSteps extends CuEAIASBaseClass{
	
	
	PageObjectManager pom = new PageObjectManager();
	
	@Given("User is on the facebook Homepage")
	public void userIsOnTheFacebookHomepage() {
	  
   
		
	}
	@When("User click contact us link")
	public void userClickContactUsLink() {
		
		
	   pom.getCuEAIASContactUsPage().ContactUsBusinessLogics();
	
	}
	@When("User enters given field {string}, {string}, {string}, {string}, {string} and {string}")
	public void userEntersGivenFieldAnd(String title, String name, String companyName, String jobTitle, String location, String phNo) {
	
		pom.getCuEAIASContactUsPage().contactUsFieldBusinessLogics("Mr", "ABC", "IASEAS", "Tester", "India", "9876543210");
		
	
	}
	@Then("User should verify success message after enters contact us page {string}")
	public void userShouldVerifySuccessMessageAfterEntersContactUsPage(String expSuccessMsg) {
	
		pom.getCuEAIASContactUsPage().verifyContactUsBusinessLogics(expSuccessMsg);
	
	}
	@Then("User should verify success message or failed message after click send button {string} and {string}")
	public void userShouldVerifySuccessMessageOrFailedMessageAfterClickSendButtonAnd(String successMessage, String failedMessage) {
	 
	pom.getCuEAIASContactUsPage().verifyAfterSendMessageBusinessLogics(successMessage, failedMessage);
	
	}




}
