package com.eaias.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.eaias.baseclass.CuEAIASBaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class HooksClass extends CuEAIASBaseClass{
	
	
	
	@Before
	public void beforeScenario() throws FileNotFoundException, IOException {
		
		browserLaunch(getPropertyFileValue("browserName"));
		maximize();
		getUrl(getPropertyFileValue("url"));
		implicitWait(10);
		
		
	}
	
	@After
	public void afterScenario(Scenario scenario) throws InterruptedException {
		
		if (!scenario.isFailed()) {
			Thread.sleep(3000);
			scenario.attach(screenShotCucumber(), "image/png", "Contact Us Failed Scenario");
			
		}
		
//		quitBorwser();
	}

}
