package com.hospitality.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.hospitality.Base.TestBase;

public class HomePage extends TestBase {

	@FindBy(id = "userAccountLink")
	WebElement LinkforSignIn;

	@FindBy(id = "SignIn")
	WebElement SignIn;

	@FindBy(id="email")
	WebElement emailID;

	@FindBy(id = "password")
	WebElement pwd;

	@FindBy(id = "signInButton")
	WebElement signINButton;
	
	@FindBy(id="modal_window")
	WebElement frame;

	public void LoginToCleartrip(String username, String password) {
		try {
			LinkforSignIn.click();
			SignIn.click();
			driver.switchTo().frame("modal_window");//switch to frame
			emailID.sendKeys(username);
			pwd.sendKeys(password);
			signINButton.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("not able to login "+e.getMessage());
		}
	}

}
