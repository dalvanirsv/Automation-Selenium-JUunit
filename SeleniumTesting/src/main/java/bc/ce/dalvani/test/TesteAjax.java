package bc.ce.dalvani.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.ce.dalvani.core.DSL;
import br.ce.dalvani.core.DriverFactory;
	
	public class TesteAjax {

		private DSL dsl;
		
			@Before
			public void inicializa() {
			
				DriverFactory.getDriver().get("https://www.primefaces.org/showcase/ui/ajax/basic.xhtml?jfwid=c8fd4");
				DriverFactory.getDriver().manage().window().setSize(new Dimension(1200, 820));
				dsl = new DSL();
	 }
		
			@After
			public void finaliza() {
				DriverFactory.getDriver();
	}
		
			@Test
			public void testAjax() {
				DriverFactory.getDriver().get("https://www.primefaces.org/showcase/ui/ajax/basic.xhtml?jfwid=c8fd4");
				dsl.escreve("j_idt311:name", "teste");
				dsl.clicarBotao("j_idt311:j_idt315");
				@SuppressWarnings("deprecation")
				WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(),30);
				wait.until(ExpectedConditions.textToBePresentInElement((WebElement) By.id("#j_idt311 > table > tbody > tr > td:nth-child(3)"), "teste"));
				Assert.assertEquals("teste", dsl.ObterTexto("#j_idt311 > table > tbody > tr > td:nth-child(3)"));
			}

	}
