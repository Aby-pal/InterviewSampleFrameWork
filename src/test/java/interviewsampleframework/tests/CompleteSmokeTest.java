package interviewsampleframework.tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.annotations.*;

public class CompleteSmokeTest {
	 @Test
	    public void executeMethods() {
	        List<String> file = new ArrayList<String>();
	        file.add("smokeTest.xml");
	        TestNG testNG = new TestNG();
	        testNG.setTestSuites(file);
	        testNG.setOutputDirectory("./test-output");
	        testNG.run();
	        try {
	   Thread.sleep(5000);
	  } catch (InterruptedException e) {
	   e.printStackTrace();
	  }
	    }
}
