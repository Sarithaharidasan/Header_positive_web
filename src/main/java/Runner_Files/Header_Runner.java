package Runner_Files;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		features = "C:\\Users\\SARITHA H\\Downloads\\QA_Automation_Framework-main\\src\\main\\java\\Header_Home_Page\\Header_positive.feature",
		glue= {"Header_Home_Page"},
		monochrome = true
		,publish = true
       	)

public class Header_Runner extends AbstractTestNGCucumberTests {

}
