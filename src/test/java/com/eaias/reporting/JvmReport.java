package com.eaias.reporting;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.eaias.baseclass.CuEAIASBaseClass;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class JvmReport extends CuEAIASBaseClass{
	

public static void generateJVMReport(String jsonFile) throws FileNotFoundException, IOException {
		
//		1) Mention the path of JVM report, Where to store it?
		File file = new File(getProjectPath()+getPropertyFileValue("jvmPath"));
		
//		2) Create the object for configuration class
		
		Configuration configuration = new Configuration(file, "EAIAS Contact Us Page Automation");
		
//		3) Add the browser name , OS version , Sprint for the designing purpose
		
		configuration.addClassifications("Browser Name", "Edge Browser");
		configuration.addClassifications("Os Version", "Windows 10");
		configuration.addClassifications("Sprint", "01"); 
		
//		4) Create object for ReportBuilder class and pass the json file
		
		List<String> jsonFiles = new ArrayList<String>();
		jsonFiles.add(jsonFile);
		
		ReportBuilder builder = new ReportBuilder(jsonFiles, configuration);
		
//		5) Build the JVM report
		
		builder.generateReports();
		
	}

}
