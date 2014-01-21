package com.jsfcompref.facelets;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RegisterTest {

	private WebDriver driver;
	private final String PAGE_URL = "http://localhost:8080/book/faces/register.xhtml";
	private String[] errorMessages = {
			"First Name: Validation Error: Value is required.",
			"Last Name: Validation Error: Value is required.",
			"Sex: Validation Error: Value is required.",
			"Date of Birth: Validation Error: Value is required.",
			"Email Address: Validation Error: Value is required." };

	@Before
	public void openDriver() {
		this.driver = new FirefoxDriver();
		this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@After
	public void closeDriver() {
		this.driver.close();
	}

	@Test
	public void submitEmptyForm() throws InterruptedException {
		this.driver.get(PAGE_URL);
		WebElement submitButton = driver.findElement(By
				.cssSelector("input[type='submit']"));
		submitButton.click();
		List<WebElement> messages = this.driver.findElements(By
				.cssSelector("ul li"));
		for (int i = 0; i < errorMessages.length; i++) {
			assertEquals(errorMessages[i], messages.get(i).getText());
		}
	}

	@Test
	public void submitFormWithName() throws InterruptedException {
		this.driver.get(PAGE_URL);
		WebElement nameField = driver.findElement(By.cssSelector("#fname"));
		nameField.sendKeys("Joao");
		WebElement submitButton = driver.findElement(By
				.cssSelector("input[type='submit']"));
		submitButton.click();
		List<WebElement> messages = this.driver.findElements(By
				.cssSelector("ul:nth-child( li"));
		for (int i = 0; i < errorMessages.length; i++) {
			assertEquals(errorMessages[i], messages.get(i).getText());
		}
	}
}
