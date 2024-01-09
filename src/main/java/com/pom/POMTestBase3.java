package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BaseClass.Testbase2;

public class POMTestBase3  extends Testbase2{
	@FindBy(name="user_id")
	WebElement name;
		@FindBy(name="password")
		WebElement password;
		@FindBy(xpath="//button[.=\"Sign in\"]")
		WebElement submit;
	public POMTestBase3(WebDriver driver){
		PageFactory.initElements(driver,this);
	}	
	public  HomePage login() {
		name.sendKeys(prop.getProperty("username"));	
		 password.sendKeys(prop.getProperty("password"));
		 submit.click();
		 return new HomePage();
	}
		
		
		}


