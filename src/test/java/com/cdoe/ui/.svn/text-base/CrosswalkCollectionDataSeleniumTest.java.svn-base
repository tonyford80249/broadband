
/*
 * Copyright ResQSoft, Inc. 2011
 */
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

public class CrosswalkCollectionDataSeleniumTest {

	private static final Logger logger = Logger.getLogger(CrosswalkCollectionDataSeleniumTest.class);
	
	private WebDriver driver;
	private String baseUrl;
	private StringBuffer verificationErrors = new StringBuffer();
	
	String projectName = "cdoe";
	String securePath = "/secure/CrosswalkCollectionData";
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://localhost:8080/" + projectName + securePath;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
   
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
    public void testIndex() {
       driver.get(baseUrl + "/");
       try {
			assertEquals("CrosswalkCollectionData", driver.getTitle());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}

    }
    
	@Test
    public void testAdd() {
       driver.get(baseUrl + "/create");
       try {
			assertEquals("CrosswalkCollectionData Create Form", driver.getTitle());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}

    } 
   
    @Test
    public void testEdit() {
       driver.get(baseUrl + "/edit/1");
       try {
			assertEquals("CrosswalkCollectionData Edit Form", driver.getTitle());
	   } catch (Error e) {
			verificationErrors.append(e.toString());
	   }
    }
   
    @Test
    public void testList() {
	   driver.get(baseUrl + "/list");
       try {
			assertEquals("CrosswalkCollectionData List", driver.getTitle());
	   } catch (Error e) {
			verificationErrors.append(e.toString());
	   }
    }
	
}