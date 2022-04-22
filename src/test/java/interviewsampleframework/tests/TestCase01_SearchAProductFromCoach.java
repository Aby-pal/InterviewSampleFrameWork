package interviewsampleframework.tests;


import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.interviewsampleframework.automation.DSL;
import com.interviewsampleframework.automation.utils.YamlReader;

public class TestCase01_SearchAProductFromCoach {

	DSL dsl;


	 String[] browserSizes = {"1366x768"}; 
	 String [] layoutTags = {"all"};
	 
	 @BeforeClass(groups={"desktop","mobile"})
	 @Parameters("browser")
	 public void start_test_session(@Optional String browser) {
			dsl = new DSL("coach_Demo", browser);
	 }
	 
	 @Test(groups={"desktop","mobile"})
	 public void TestStep01_Launch_Application_URL(){
		 
		 dsl.launchApplication(YamlReader.getData("base_url"));
			Reporter.log("Successfully Launched Coach Website");
	     
	}
	 
	 @Test(groups={"desktop","mobile"})
	 public void TestStep02_SearchAProduct(){
		 
		 dsl.searchProduct(YamlReader.getData("product"));
		 Reporter.log("Found Search Result");
	     
	}
	 	 
	 @AfterClass(groups={"desktop","mobile"})
	    public void stop_test_session(){
		 dsl.closeBrowserSession();
		 Reporter.log("User closes the application");
	    }
	   
     @AfterMethod
	 public void takeScreenshotonFailure(ITestResult result)
	   {
	        dsl.takeScreenShotOnException(result);
	   }
	 
}
