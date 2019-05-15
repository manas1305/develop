package com.facebooklogin.base;

import java.util.ArrayList;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import com.facebooklogin.utilities.Constants;
import com.facebooklogin.utilities.PropertiesUtil;


/**
 * BasePage class is responsible for holding all the page related functionality 
 * that is required for any test to move from one page to another with 
 * screenshot, driver and other common function.
 * 
 *
 */
public class BasePage {
	
	public RemoteWebDriver driver = null;
	public String testcaseName;
	public int screenShotNumber;
	public ArrayList<String> TestStep = new ArrayList<String>();
	public String BROWSER = PropertiesUtil.getProprty("Browser");
	public String browserType = BROWSER;

	/**
	 * Empty Constructor.
	 */
	public BasePage() {

	}

	/**
	 * Constructor with parameters.
	 * 
	 * @param driver {@link RemoteWebDriver}
	 * @param testcaseName String
	 * @param screenShotNumber int
	 * @param TestStep {@link ArrayList}
	 */
	public BasePage(RemoteWebDriver driver, String testcaseName, int screenShotNumber, ArrayList<String> TestStep) {
		this.testcaseName = testcaseName;
		this.screenShotNumber = screenShotNumber;
		this.driver = driver;
		this.TestStep = TestStep;
		PageFactory.initElements(driver,"");
	}

	/**
	 * Function to wait for the duration of seconds passed as parameters. 
	 * 
	 * @param seconds {@link Integer}
	 */
	protected void waitForSeconds(Integer seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
		}
	}

	/**
	 * Validate if element is present or not on screen based on xpath locator.
	 * 
	 * @param locator String xpath key
	 * @return boolean
	 */
	public boolean isElementPresent(String locator) {
		int s = driver.findElements(By.xpath(locator)).size();
		if (s == 0) {
			return false;
		} else {
			return true;
		}

	}

	/**
	 * Get size of element By Id.
	 * 
	 * @param byId String
	 * @return int
	 */
	public int getSizeOfElementById(String byId) {
		try {
			return driver.findElements(By.id(byId)).size();
		} catch (Throwable t) {
			t.printStackTrace();
			return 0;
		}

	}

	/**
	 * this function provide the Web Element details.
	 * 
	 * @param locator locatorId
	 * @return {@link WebElement}
	 */
	public WebElement findObject(WebElement locator) {
		WebElement elementDisplayed = null;
		try {
			int timeOut = Constants.FLUENT_WAIT;
			FluentWait<RemoteWebDriver> wait = new FluentWait<RemoteWebDriver>(driver)
					.withTimeout(timeOut, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS);
			elementDisplayed = wait.until(ExpectedConditions.visibilityOf(locator));

		} catch (Exception t) {

		}
		return elementDisplayed;
	}

	/**
	 * Get Value From Text Field With Attribute Value.
	 * 
	 * @param locator locatorId
	 * @return String
	 */
	public String getValueFromTextFieldWithAttributeValue(WebElement locator) {
		return findObject(locator).getAttribute("value");
	}

	/**
	 * Get Web Element text from locator.
	 * 
	 * @param locator {@link WebElement}
	 * @return String
	 */
	public String getValueFromTextFiel(WebElement locator) {
		String value = findObject(locator).getText();
		return value;
	}

	/**
	 * Validate if the web element is Clickable.
	 * 
	 * @param locator {@link WebElement}
	 * @return {@link WebElement}
	 */
	public WebElement isClickable(WebElement locator) {
		WebElement pageDisplayed = null;
		try {
			Integer timeOut = 10;
			FluentWait<RemoteWebDriver> wait = new FluentWait<RemoteWebDriver>(driver)
					.withTimeout(timeOut, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS);
			pageDisplayed = wait.until(ExpectedConditions.elementToBeClickable(locator));
		} catch (Throwable t) {
			t.printStackTrace();
		}
		return pageDisplayed;
	}

	/**
	 * Check Element displayed or not.
	 * 
	 * @param locator {@link WebElement}
	 * @return boolean
	 */
	public boolean isElementDisplayed(WebElement locator) {
		return locator.isDisplayed();
	}

	/**
	 * Set Value In TextField.
	 * 
	 * @param locator {@link WebElement}
	 * @param value String
	 */
	public void setValueInTextField(WebElement locator, String value) {
		findObject(locator);
		//locator.clear();
		locator.sendKeys(value);
	}

	/**
	 * Function click the locator.
	 * 
	 * @param locator  {@link WebElement}
	 */
	public void click(WebElement locator) {
		
		findObject(locator);
		isClickable(locator);
		locator.click();
	}

	/**
	 * Select Value From Drop Down Field By Count.
	 * 
	 * @param locator {@link WebElement}
	 * @param count int
	 */
	protected void selectValueFromDropDownFieldByCount(WebElement locator, int count) {
		findObject(locator).click();
		for (int i = count; i > 0; i--) {
			driver.getKeyboard().sendKeys(Keys.DOWN);
		}
		driver.getKeyboard().sendKeys(Keys.ENTER);
		waitForSeconds(5);
	}

	/**
	 * Perform Keyboard Operations.
	 * 
	 * @param key {@link Keys}
	 */
	public void performKeyboardOperations(Keys key) {
		waitForSeconds(Constants.EXPLICIT_WAITSHORT);
		driver.getKeyboard().sendKeys(key);
	}

	

	/**
	 * Clear Text Field.
	 * 
	 * @param wbElement {@link WebElement}
	 */
	protected void clearTextField(final WebElement wbElement) {
		findObject(wbElement).clear();
	}

	/**
	 * Get Value From Text Field.
	 * 
	 * @param locator {@link WebElement}
	 * @return String
	 */
	public String getValueFromTextField(WebElement locator) {
		return findObject(locator).getText();
	}
	
	/**
	 * Double Clicking.
	 * 
	 * @param clickResolvedText String
	 */
	public void doubleClicking(String clickResolvedText) {
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(By.xpath(clickResolvedText))).doubleClick().build().perform();
	}

	/**
	 * Check if  Element Disabled.
	 * 
	 * @param locator {@link WebElement}
	 * @return boolean
	 */
	public boolean isElementDisabled(WebElement locator) {
		return locator.isDisplayed();
	}

	/**
	 * Scrolldown.
	 * 
	 */
	public void scrolldown() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, 250);");
	}

	


	/**
	 * Get Title Value From Text Field.
	 * 
	 * @param locator {@link WebElement}
	 * @return String
	 */
	public String getTitleValueFromTextField(WebElement locator) {

		return findObject(locator).getAttribute("title");
	}

	 
}
