package interviewsampleframework.keywords;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.interviewsampleframework.automation.getpageobjects.GetPage;
import com.interviewsampleframework.automation.utils.PropFileHandler;

public class SamplePage extends GetPage {

	public SamplePage(WebDriver driver)
	{
		super(driver,"interviewsampleframework/SamplePage");
	} 


}
