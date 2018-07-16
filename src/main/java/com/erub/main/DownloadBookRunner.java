package com.erub.main;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class DownloadBookRunner {
	private static final Logger LOGGER = LogManager.getLogger(DownloadBookRunner.class);

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "chromedriver");

		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("download.default_directory", System.getProperty("user.dir") + File.separator + "books");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		
		LOGGER.info("##################################################################");
		LOGGER.warn("LAUNCHING BROWSER ...");
		WebDriver driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.navigate().to("http://nigioikhatsi.net/kinh-sach-pdf/kinh-sach-pdf.html");

		List<WebElement> webElements = driver.findElements(By.cssSelector(".MsoNormal"));
		for (WebElement element : webElements) {
			// click item
			Actions action = new Actions(driver);
			action.contextClick(element).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
					.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
			
			Actions action2 = new Actions(driver);
			action2.contextClick(element).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
					.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();

			Actions action3 = new Actions(driver);
			action3.contextClick(element).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
					.sendKeys(Keys.ENTER).build().perform();
			
			
			LOGGER.info("Done download the book: " + element.getText());

		}

	}

}
