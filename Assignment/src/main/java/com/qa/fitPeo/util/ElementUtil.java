package com.qa.fitPeo.util;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	private WebDriver driver ;
	private Actions actions;
	private WebDriverWait wait;
	private JavascriptExecutor js;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
		actions = new Actions(driver);
		wait = new WebDriverWait(driver , Duration.ofSeconds(20));
		js = (JavascriptExecutor) driver;
	}

	public WebElement getElementByXpath(By locator) {
		/*
		 * Parameter : xpath locator
		 * return : element 
		 */
		WebElement element = driver.findElement(locator);
		return element ;
	}

	public WebElement getElementByCssSelector(By locator) {
		/*
		 * Parameter : Css selector locator
		 * return : element 
		 */
		WebElement element = driver.findElement(locator);
		return element;
	}

	public WebElement getElementByVisibilityOfElementLocated(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void doClick(By locator) {
		getElementByXpath(locator).click();
	}

	public void doSendKeys(By locator,String value) {
		getElementByXpath(locator).sendKeys(value);
	}

	public void doClickWithActionsClass(By locator) {
		actions.moveToElement(getElementByXpath(locator)).click().perform();
	}

	public void doSendKeysWithActionsClass(By locator, String value) {
		actions.sendKeys(getElementByXpath(locator), value).perform();
	}

	public WebElement elementByPresenceOfElementLocated(By locator) {
		/*
		 * presentOfElementLocated this condition checks element present in the DOM or not but that does not necessarily means it is visible
		 */
		return	wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public void doClickWithPresenceOfElementLocatedt(By locator) {
		elementByPresenceOfElementLocated(locator).click();
	}

	public void doSendKeysWithPresenceOfElementLocated(By locator , String value) {
		elementByPresenceOfElementLocated(locator).sendKeys(value);
	}

	public WebElement elementByVisibilityOfElementLocated(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void doClickWithVisibilityOfElementLocated(By locator) {
		elementByVisibilityOfElementLocated(locator).click(); 
	}

	public void doSendKeysWithVisibilityOfElementLocated(By locator , String value) {
		elementByVisibilityOfElementLocated(locator).sendKeys(value);

	}

	public void clickAndHoldWithAction(By locator , int xOffset , int yOffset) {
		actions.clickAndHold(getElementByXpath(locator)).moveByOffset(xOffset,yOffset).moveByOffset(1,0).release().perform();
	}


}
