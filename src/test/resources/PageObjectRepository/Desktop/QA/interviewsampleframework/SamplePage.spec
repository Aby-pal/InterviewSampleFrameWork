Page Title: interviewsampleframework

#Object Definitions
====================================================================================
button_Register             xpath                  //span[@class='signin btn' and text()='Register']
textbox_FirstName			xpath				   //input[@id='dwfrm_profile_customer_firstname']
textbox_LastName			xpath				   //input[@id='dwfrm_profile_customer_lastname']
textbox_eMailAddress		xpath				   //input[@id='dwfrm_profile_customer_email']
textbox_confirmEmail        xpath 				   //input[@id='dwfrm_profile_customer_emailconfirm']
textbox_password			xpath				   //input[@id='dwfrm_profile_login_password']
textbox_confirmPassword		xpath				   //input[@id='dwfrm_profile_login_passwordconfirm']
checkbox_SignMeIN			xpath				   //input[@id='dwfrm_profile_customer_addtoemaillist']
button_SignUp				xpath				   //button[@class='btn btn-default continue' and @name='dwfrm_profile_confirm']
textbox_addressField1		xpath				   //input[@id='dwfrm_profile_address_address1']
textbox_addressField2		xpath                  //input[@id='dwfrm_profile_address_address2']
textbox_postalCode			xpath				   //input[@id='dwfrm_profile_address_zip']
textbox_city				xpath 				   //input[@id='dwfrm_profile_address_city']
textbox_phone				xpath				   //input[@id='dwfrm_profile_address_phone']
button_Complete 			xpath				   //button[@class='apply-button btn' and contains(text(),"Complete")]
textMessage_Welcome			xpath 				   //p[@class='text-center welcome-massage']
page_heading                xpath                  //a[@title='COACH']/span
button_login_register       xpath                  //span[contains(text(),'Sign In/Register')]
login_button                xpath                  (//span[contains(text(),'Sign In')])[2]
username_field              xpath                  //input[contains(@id,'dwfrm_login_username')]
password_field              xpath                  //input[@id='dwfrm_login_password']
signin_button               xpath                  //span[contains(text(),'Sign In') and @class='signin btn']
signin_button2	            xpath                  //button[@class='btn checkout btn-default' and contains(text(),'SIGN IN')]
checkbox_remember		    xpath	   			   //*[contains(text(),'dwfrm_login_rememberme')]
                  