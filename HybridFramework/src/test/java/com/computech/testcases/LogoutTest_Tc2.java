package com.computech.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.computech.pages.LoginPage;
import com.computech.pages.LogoutPage;

public class LogoutTest_Tc2 extends BaseClass{
	
	LoginPage lp;
	LogoutPage lout;
	
	@Test
	public void logout() {
		lp=PageFactory.initElements(driver, LoginPage.class);
		lp.loginToApplication();
		lout=PageFactory.initElements(driver, LogoutPage.class);
		lout.logoutFromTheApplicaion();
	}

}
