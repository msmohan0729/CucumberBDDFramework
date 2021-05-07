package testRunner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:\\Users\\M1057371\\Cucumber\\CucumberBDD\\src\\test\\java\\features\\petstore.feature", //the path of the feature files
		glue={"stepDefinitions"}, //the path of the step definition files
		plugin= {"pretty","html:test-output", "json:json_output/cucumber.json", 
				"junit:junit_xml/cucumber.xml", "com.cucumber.listener.ExtentCucumberFormatter:output/report.html"}, //to generate different types of reporting
		monochrome = true, //display console output in proper readable format
		strict = true,
		dryRun = false 	//to verify features and their corresponding test definitions
		)
public class MyTestRunner {
	@AfterClass
	public static void writeExtentReport(){
		Reporter.loadXMLConfig(new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\petstore\\util\\ReportsConfig.xml"));
	}
}
