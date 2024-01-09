package com.TestScripts;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.BaseClass.Testbase2;
import com.pom.POMTestBase3;

public class TestScriptsTestbase4  extends Testbase2{
	POMTestBase3 login;
	@BeforeMethod
	public void url() {
		url();
		login=new POMTestBase3(driver);
	}
	@Test
	public void homepage() {
		login.login();
		
	}

}
