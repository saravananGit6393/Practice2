package com.eaias.testrunner;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.eaias.baseclass.CuEAIASBaseClass;
import com.eaias.reporting.JvmReport;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(tags="@Scenario1",snippets=SnippetType.CAMELCASE,dryRun=false,publish=true,monochrome=true,stepNotifications=true,plugin= {"pretty","json:target\\contactUs.json"},features="src\\test\\resources",glue="com.eaias.stepdefinition")


public class TestRunner extends CuEAIASBaseClass{
	
	
	@AfterClass
	public static void afteClass() throws FileNotFoundException, IOException {
		
		JvmReport.generateJVMReport(getProjectPath()+getPropertyFileValue("jsonPath"));
		
	}

}
