package com.computech.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.computech.utilites.Utility;

public class LogoutPage {

	WebDriver driver;
	public LogoutPage(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(how = How.XPATH, using="//a[@id='welcome']") WebElement linkPanel;
	@FindBy(how = How.XPATH, using="//a[text()='Logout']") WebElement linkLogout;
	
	
	public void logoutFromTheApplicaion() {
		Utility.highLightElement(driver, linkPanel);
		linkPanel.click();
		Utility.waitTo(2);
		Utility.highLightElement(driver, linkLogout);
		linkLogout.click();
	}
	/*
	 public void logoutFromTheApplicaion() {
		linkPanel.click();
		linkLogout.click();
	}
	 */
}
