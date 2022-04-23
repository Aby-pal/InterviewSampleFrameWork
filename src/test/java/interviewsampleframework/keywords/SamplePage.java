package interviewsampleframework.keywords;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.interviewsampleframework.automation.getpageobjects.GetPage;
import com.interviewsampleframework.automation.utils.PropFileHandler;

public class SamplePage extends GetPage {

    public SamplePage(WebDriver driver) {
        super(driver, "interviewsampleframework/SamplePage");
    }


    public void clickOnHamburger() {
        wait.waitForPageToLoadCompletely();
        element("icon_hamburger").click();
    }

    public boolean verifyHamburgerMenuExpand() {
        wait.waitForPageToLoadCompletely();
        return element("Header_hamburger").isDisplayed();
    }

    public void selectHamburgerOption(String option) {
        wait.waitForPageToLoadCompletely();
        element("option_hamburger", option).click();
    }

    public boolean verifyHamburgerOptionSelected() {
        wait.waitForPageToLoadCompletely();
        return element("option_televison").isDisplayed();

    }

    public void selectTelevisonOption() {
        wait.waitForPageToLoadCompletely();
        element("option_televison").click();
    }

    public boolean verifyTelevisonOptionSelected(String currentUrL) {
        wait.waitForPageToLoadCompletely();
        System.out.println("currentUrL " + currentUrL);
        System.out.println("currentUrL.contains(\"television\") " + currentUrL.contains("television"));
        return currentUrL.contains("television");
    }

    public void selectSamsungTelevisonBrand() {
        wait.waitForPageToLoadCompletely();
        element("checkbox_samsung").click();
    }

    public boolean verifySamsungTelevisonBrandSelected(String currentUrL) {
        wait.waitForPageToLoadCompletely();
        return currentUrL.contains("Samsung");
    }

    public void SortProductResults() {
        wait.waitForPageToLoadCompletely();
//		scrollAtTop();
        clickByJavascript(element("dropdown_sortby"));
        wait.waitForPageToLoadCompletely();
        element("option_sortby_dropdown").click();
    }

    public boolean verifySortProductResults(String currentUrL) {
        wait.waitForPageToLoadCompletely();
        return currentUrL.contains("price-desc");
    }

    public void selectSecondProduct() {
        wait.waitForPageToLoadCompletely();
        element("results_second_product").click();
    }

    public boolean verifyProductSelected() {
        wait.waitForPageToLoadCompletely();
        switchOnWindow();
        wait.waitForPageToLoadCompletely();
        return element("section_buy").isDisplayed();
    }

    public String getPoint1Details() {
        return elements("list_bullets_points").get(0).getText();
    }

    public String getPoint2Details() {
        return elements("list_bullets_points").get(1).getText();

    }

    public String getPoint3Details() {
        return elements("list_bullets_points").get(2).getText();

    }

    public String getPoint4Details() {
        return elements("list_bullets_points").get(3).getText();

    }

    public String getPoint5Details() {
        return elements("list_bullets_points").get(4).getText();

    }
}
