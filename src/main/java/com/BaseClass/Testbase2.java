package com.BaseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testbase2 {
	 public static WebDriver driver;

		public static FileInputStream n;
		public static Properties prop;

		String path="./src/main/java/Configarationprpt/ns";
		public Testbase2() {
			prop=new Properties();
			
	 try {
		n= new FileInputStream(path);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	try {
		prop.load(n)
	;
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
		}

	public static void urls() {	
		String Browser=prop.getProperty("Browser");
	if(Browser.equalsIgnoreCase("Chrome")) {
		 driver =new ChromeDriver();
	}
		driver.manage().window().maximize()	;
				driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
			

		}
	}





