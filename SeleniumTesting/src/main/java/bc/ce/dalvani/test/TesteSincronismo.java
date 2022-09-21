package bc.ce.dalvani.test;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.ce.dalvani.core.DSL;

	public class TesteSincronismo {

	private WebDriver driver;
	private DSL dsl;
	
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
		public void deveUtilizarEsperaFIxa() throws InterruptedException {
			dsl.clicarBotao("buttonDelay");
			Thread.sleep(5000);
			dsl.escreve("novoCampo", "Deu certo?");
		
	}
		@SuppressWarnings("deprecation")
		@Test
		public void deveUtilizarEsperaImplicita() throws InterruptedException {
			dsl.clicarBotao("buttonDelay");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			dsl.escreve("novoCampo", "Deu certo?");
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	}
		@Test
		public void deveUtilizarEsperaExplicita() throws InterruptedException {
			dsl.clicarBotao("buttonDelay");
			@SuppressWarnings("deprecation")
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("novoCampo"), null));
			dsl.escreve("novoCampo", "Deu certo?");
	}
}
