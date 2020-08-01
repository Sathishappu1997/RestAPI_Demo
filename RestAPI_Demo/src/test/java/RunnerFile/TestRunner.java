package RunnerFile;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;




@CucumberOptions(
		
		features = "src/test/resources/Feature File/AllMethod.feature",
		glue = "StepDefinition",
		plugin = {"pretty", "html:src/test/resources/Reports/cucumber-html-report",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:src/test/resources/Reports"},
		
		
		monochrome = true
		)




public class TestRunner extends AbstractTestNGCucumberTests {

}
