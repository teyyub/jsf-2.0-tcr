package com.jsfcompref.utils;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumTest {

	private WebDriver driver;

	@Before
	public void openDriver() {
		this.driver = new FirefoxDriver();
	}

	@After
	public void closeDriver() {
		this.driver.close();
	}

	@Test
	public void openWebBrowserAtIndex() {
		driver.get("localhost:8080/book");
	}

	@Test
	public void openRegisterPage() {
		driver.get("localhost:8080/book/faces/register.xhtml");
	}

	@Test
	public void clickLink() {
		driver.get("localhost:8080/book");
		WebElement link = driver.findElements(By.tagName("a")).get(0);
		link.click();
		assertEquals("http://localhost:8080/book/faces/register.xhtml",
				driver.getCurrentUrl());
	}
}
