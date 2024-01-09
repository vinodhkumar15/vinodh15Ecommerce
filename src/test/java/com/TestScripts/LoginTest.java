package com.TestScripts;

import java.sql.Driver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.BaseClass.TestBase;
import com.pom.LoginFunctionality;

public class LoginTest extends TestBase {
	LoginFunctionality login;

	@BeforeMethod

	public void Setup() {

		Initialization();
		login=new LoginFunctionality(driver);

	}

	@Test
	public void verifyLogin() {

		login.doLogin();

		String homepageurl = driver.getCurrentUrl();

		Assert.assertEquals("https://e-quarz.com/", homepageurl);
	}

	@AfterMethod

	public void tearDown() {

		//driver.close();
	}


}
