package Runner_Files;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		features = "C:\\Users\\SARITHA H\\Downloads\\QA_Automation_Framework-main\\src\\main\\java\\Login_Page\\Login_positive.feature",
		glue= {"Login_Page"},
		monochrome = true
		,publish = true
       	)
public class Login_Runner extends AbstractTestNGCucumberTests {

}
