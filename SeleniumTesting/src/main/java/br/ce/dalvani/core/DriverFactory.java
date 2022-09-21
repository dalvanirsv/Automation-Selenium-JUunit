package br.ce.dalvani.core;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

	public class DriverFactory {
	private static WebDriver driver;
	private DriverFactory() {}
		
		public static WebDriver getDriver() {
			if(driver == null) {
				System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
					driver = new ChromeDriver();
					driver.manage().window().setSize(new Dimension(1200, 820));
			
		}
			return driver;
   }
		
		public static void killDriver() {
			if (driver != null) {
					driver.quit();
						driver = null;
		}
			
		
	}
		
}