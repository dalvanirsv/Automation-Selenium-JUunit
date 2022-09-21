package bc.ce.dalvani.test;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

	public class TesteGoogle {	
	private WebDriver driver;
	
		@Before
		public void inicializa() {
			System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().setSize(new Dimension(1200, 820));
			driver.get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
	}
		@After
		public void finaliza() {
			driver.quit();
	}
		@Test
		public void teste() {
			System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().setSize(new Dimension(1200, 765));
			Assert.assertEquals("Google", driver.getTitle());
			driver.quit();
	}
}
