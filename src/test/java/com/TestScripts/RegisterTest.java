package com.TestScripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.internal.Utils;

import com.BaseClass.TestBase;
import com.pom.LoginFunctionality;
import com.pom.RegisterUserFunctionality;

public class RegisterTest extends TestBase {

	String Excelsheet_name = "Registration";
	RegisterUserFunctionality register;
	LoginFunctionality login;

	@DataProvider

	public String[][] dataTest() throws Throwable {

		return Utils.setdata(Excelsheet_name);

	}

	@BeforeMethod

	public void setup() {

		Initialization();
		login = new LoginFunctionality(driver);
		register = new RegisterUserFunctionality(driver);

	}

	@Test(priority = 1,dataProvider = "dataTest", dataProviderClass = RegisterTest.class,description = "Registering user")

	public void Verify_Registrationfunctionality(String firstn, String Lastn, String Email, String pnumber,
			String pword, String conpword) {

		register.Register_user(firstn, Lastn, Email, pnumber, pword, conpword);

	}

	@Test(priority = 2,description = "Logining in with newly created user",dependsOnMethods = "Verify_Registrationfunctionality")

	public void Verify_Login() {

		login.doLogin();
		String homepage_url = driver.getCurrentUrl();
		Assert.assertEquals("https://e-quarz.com/", homepage_url);

	}

}