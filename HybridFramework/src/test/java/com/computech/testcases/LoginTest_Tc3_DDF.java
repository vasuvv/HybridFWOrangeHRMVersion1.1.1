package com.computech.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.computech.factory.DataProviderFactory;
import com.computech.pages.LoginPage;
import com.computech.pages.LogoutPage;

@SuppressWarnings("unused")
public class LoginTest_Tc3_DDF extends BaseClass {

	LoginPage lp;
	LogoutPage lout;

	@Test
	public void login() {
		logger = report.createTest("Ornage HRM Login Test");
		logger.info("Browser and Application is up and running..");
		lp=PageFactory.initElements(driver, LoginPage.class);
		lp.loginToApplication(DataProviderFactory.getExcel().getStringData("LoginTest", 0, 0), 
				DataProviderFactory.getExcel().getStringData("LoginTest", 0, 1));
		logger.pass("Login done successfully..");
	}
	@Test
	public void logout() {
		logger.info("I am Login page ..");
		logger = report.createTest("Ornage HRM Logout Test");
		lout=PageFactory.initElements(driver, LogoutPage.class);
		lout.logoutFromTheApplicaion();
		logger.pass("Logout done successfully..");
	}
	/*
	 @Test
	public void login() {
		ExcelReader excel = new ExcelReader();
		lp=PageFactory.initElements(driver, LoginPage.class);
		lp.loginToApplication(excel.getStringData("LoginTest", 0, 0), excel.getStringData("LoginTest", 0, 1));
	}
	 */
}
