
package com.cdoe.ui;

import org.apache.log4j.Logger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.thoughtworks.selenium.*;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.regex.Pattern;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.junit.*;
public class SecuritySeleniumTest {
	/*
		Try to create first a dummy account:
		username: test
		password: test
		
		Or, you can supply the appropriate credentials below.
	*/
	private static final Logger logger = Logger.getLogger(SecuritySeleniumTest.class);
	
	private WebDriver driver;
	private String baseUrl;
	//private StringBuffer verificationErrors = new StringBuffer();
	
	String projectName = "cdoe";
	String username = "test";
	String password = "test";

	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://localhost:8080/" + projectName ;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
   
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
    public void testLogin() {
    	driver.get(baseUrl + "/" + projectName + "/login");
		driver.findElement(By.name("j_username")).clear();
		driver.findElement(By.name("j_username")).sendKeys(username);
		driver.findElement(By.name("j_password")).clear();
		// driver.findElement(By.name("j_password")).sendKeys(test);
		driver.findElement(By.name("submit")).click();
    }
	
}