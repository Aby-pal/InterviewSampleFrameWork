package com.interviewsampleframework.automation;

import com.interviewsampleframework.automation.utils.YamlReader;
import org.testng.ITestResult;

public class DSL extends TestSessionInitiator {

	public DSL(String testname) {
		super(testname);
	}

	public DSL(String testname, String browserName) {
		super(testname, browserName);
	}

	public void launchApplication(String url) {
		topBanner.launchSpecificUrl(url);
	}

	public void registerANewUser() {
		topBanner.clickOnSignINRegister().clickOnRegisterButton();
		accountPage.enterRegisterInformation();
		accountPage.enterAddressInformationAfterSignUp();
	}

	public void logOutFromTheApplication() {
		topBanner.logout();
	}

	public void loginAsRegisteredUser(String userName, String password) {
		topBanner.clickOnSignINRegister().loginWithRegisteredUser(userName, password);

	}

	public void searchProduct(String product) {
		search.enterProductIntoSeacrhBox(product);
		search.clickOnSearchBox();
	}

	public void takeScreenShotOnException(ITestResult result) {
		takescreenshot.takeScreenShotOnException(result);
	}

	public void goToMenSectionAndSelectItem() {
		homeheader.goToMenSection();
		menSection.select_mens_bag();

	}

	public void selectFirstProduct() {
		prodctresult.select_frst_product();
	}

	public void addTheProductToBag() {
		prodctdetails.Add_To_Bag();
	}

	public void checkoutTheProductFromBag() {
		shopngbagpage.hover_At_shoping_Bag();
		shopngbagpage.clicked_On_Checkout();
	}

	public void selectchekoutasguestbutton() {
		shopngbagpage.select_chekout_as_guest_button();
	}

	public void shipingTheProduct() {
		shipngpage.productShipping();
	}

	public void EntershipingDetails() {
		shipngpage.enterShipingDetails();
	}

	public void makePaymentFromMasterCard() {
		paymentpage.user_enter_card_number(YamlReader.getData("cardtype.master_card"));
		paymentpage.user_select_card_expiry_month_and_year();
		paymentpage.user_enter_securitycode_and_emailid(YamlReader.getData("cardtype.master_security"),
				YamlReader.getData("users.user1.username"));
		paymentpage.user_submit_payment();
	}

	public void placedOrder() {
		ordereviewpage.click_on_place_order();
	}

	public void makePaymentUsingAmericanExpress() {
		paymentpage.user_enter_card_number(YamlReader.getData("cardtype.american_express_card"));
		paymentpage.user_select_card_expiry_month_and_year();
		paymentpage.user_enter_securitycode_and_emailid(YamlReader.getData("cardtype.american_security"),
				YamlReader.getData("users.user1.username"));
		paymentpage.user_submit_payment();

	}

	public void makePaymentUsingVisaCard() {
		paymentpage.user_enter_card_number(YamlReader.getData("cardtype.visa_card"));
		paymentpage.user_select_card_expiry_month_and_year();
		paymentpage.user_enter_securitycode_and_emailid(YamlReader.getData("cardtype.visa_security"),
				YamlReader.getData("users.user1.username"));
		paymentpage.user_submit_payment();

	}

	public void makePaymentUsingCoachGifts() {
		paymentpage.user_enter_gift_card_number(YamlReader.getData("gift_card_no"),
				YamlReader.getData("gift_card_pin"));
		paymentpage.user_enter_emailid(YamlReader.getData("users.user1.username"));
		paymentpage.user_submit_payment();

	}

	public void makePaymentUsingPayPal() {
		paymentpage.select_paypal_radio_button();
		paymentpage.user_enter_email_id_and_confirm_id(YamlReader.getData("email_paypal"));
		paymentpage.user_submit_payment();
		//System.out.println("hang");
		paymentpage.switchToNewWindow();
		paymentpage.switchToFrame("injectedUl");
	//	System.out.println("no hang");
		paymentpage.user_enter_pay_pal_password_and_enter_submit(YamlReader.getData("password_pay_pal"));
		paymentpage.switchToDefaultContent();
		paymentpage.user_press_pay_pal_confirm_button();
		paymentpage.hardWait(5);
		paymentpage.switchtoActiveWindow();
	}

	public void makePaymentUsingJcb() {
		paymentpage.user_enter_card_number(YamlReader.getData("cardtype.jcb_card"));
		paymentpage.user_select_card_expiry_month_and_year();
		paymentpage.user_enter_securitycode_and_emailid(YamlReader.getData("cardtype.jcb_security"),
				YamlReader.getData("users.user1.username"));
		paymentpage.user_submit_payment();
	}

	public void makePaymentUsingDiscoverCard() {
		paymentpage.user_enter_card_number(YamlReader.getData("cardtype.discover_card"));
		paymentpage.user_select_card_expiry_month_and_year();
		paymentpage.user_enter_securitycode_and_emailid(YamlReader.getData("cardtype.discover_security"),
				YamlReader.getData("users.user1.username"));
		paymentpage.user_submit_payment();
	}

	public void makePaymentUsingDinerClub() {
		paymentpage.user_enter_card_number(YamlReader.getData("cardtype.diner_club_card"));
		paymentpage.user_select_card_expiry_month_and_year();
		paymentpage.user_enter_securitycode_and_emailid(YamlReader.getData("cardtype.dinner_club_security"),
				YamlReader.getData("users.user1.username"));
		paymentpage.user_submit_payment();
	}

	public void verifyLandingPage() {
		landingPage.verifyLandingPage();
		homeheader.verifyLogo();
	}

	public void verifySearchDisplayed() {
		search.verifySearchDisplayed();
	}

	public void verifyFooterSection() {
		footer.verifyFooterSection();

	}

	public void verifyTopNavigationBar() {
		topBanner.verifyTopNavigationBar();
	}
	
	public void verifyConnectWithCoachFunctionality() {
		  footer.connectWithCoachByEnteringEmailInFooter();
		 }

}
