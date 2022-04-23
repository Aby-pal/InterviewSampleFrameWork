package interviewsampleframework.tests;


import com.interviewsampleframework.automation.TestSessionInitiator;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.interviewsampleframework.automation.utils.YamlReader;

public class ExecuteSampleTest {

    TestSessionInitiator dsl;

    @BeforeClass(groups = {"desktop"})
    private void start_test_session() {
        dsl = new TestSessionInitiator("ExecuteSampleTest");
    }

    @Test(groups = {"desktop"})
    public void TestStep01_Launch_Application_URL() {
        String baseUrl = YamlReader.getData("base_url");
        dsl.launchApplication(baseUrl);
        Assert.assertEquals(baseUrl, dsl.getCurrentURL(), "Unable to launch Amazon website");
        Reporter.log("Successfully Launched Amazon Website");

    }

    @Test(groups = {"desktop"}, dependsOnMethods = "TestStep01_Launch_Application_URL")
    public void TestStep02_ClickOnHamburger() {
        dsl.samplePage.clickOnHamburger();
        Assert.assertTrue(dsl.samplePage.verifyHamburgerMenuExpand(), "Unable to expand Hamburger Menu");
        Reporter.log("Successfully Expand Hamburger Menu");
    }

    @Test(groups = {"desktop"}, dependsOnMethods = "TestStep02_ClickOnHamburger")
    public void TestStep03_SelectHamburgerOption() {
        String hamburgerOption = YamlReader.getData("hamburgerOption");
        dsl.samplePage.selectHamburgerOption(hamburgerOption);
        Assert.assertTrue(dsl.samplePage.verifyHamburgerOptionSelected(), "Unable to click on " + hamburgerOption + " option");
        Reporter.log("Successfully selected " + hamburgerOption + " option");
    }

    @Test(groups = {"desktop"}, dependsOnMethods = "TestStep03_SelectHamburgerOption")
    public void TestStep04_SelectTelevisionOption() {
        dsl.samplePage.selectTelevisonOption();
        String currentUrL = dsl.getCurrentURL();
        Assert.assertTrue(dsl.samplePage.verifyTelevisonOptionSelected(currentUrL), "Unable to click on Television option");
    }

    @Test(groups = {"desktop"}, dependsOnMethods = "TestStep04_SelectTelevisionOption")
    public void TestStep05_SelectSamsungTelevisionBrand() {
        dsl.samplePage.selectSamsungTelevisonBrand();
        String currentUrL = dsl.getCurrentURL();
        Assert.assertTrue(dsl.samplePage.verifySamsungTelevisonBrandSelected(currentUrL), "Unable to select samsung Television brand");
    }

    @Test(groups = {"desktop"}, dependsOnMethods = "TestStep05_SelectSamsungTelevisionBrand")
    public void TestStep05_SortProductResults() {
        dsl.samplePage.SortProductResults();
        String currentUrL = dsl.getCurrentURL();
        Assert.assertTrue(dsl.samplePage.verifySortProductResults(currentUrL), "Unable to sort products results in 'high to low' ");
    }

    @Test(groups = {"desktop"}, dependsOnMethods = "TestStep05_SortProductResults")
    public void TestStep06_SelectSecondProduct() {
        dsl.samplePage.selectSecondProduct();
        Assert.assertTrue(dsl.samplePage.verifyProductSelected(), "Unable to select product");
    }

    @AfterClass(groups = {"desktop"})
    public void stop_test_session() {
//		 dsl.closeBrowserSession();
        Reporter.log("User closes the application");
    }

    @AfterMethod
    public void takeScreenshotOnFailure(ITestResult result) {
        dsl.takeScreenShotOnException(result);
    }

}