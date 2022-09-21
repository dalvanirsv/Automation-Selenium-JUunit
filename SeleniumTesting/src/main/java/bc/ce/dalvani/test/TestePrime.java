package bc.ce.dalvani.test;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import br.ce.dalvani.core.DSL;
import br.ce.dalvani.core.DriverFactory;

	public class TestePrime {
	private DSL dsl;
	
		@Before
		public void inicializa() {
			DriverFactory.getDriver().manage().window().setSize(new Dimension(1200, 820));
			dsl = new DSL();
	}
		@After
		public void finaliza() {
			DriverFactory.killDriver();
	}
		@Test
		public void deveInteragirComRadioPrime() {
			DriverFactory.getDriver().get("https://www.primefaces.org/showcase/ui/input/oneRadio.xhtml?jfwid=01fec");
			dsl.clicarRadio(By.cssSelector("#j_idt312\\:console > tbody > tr > td:nth-child(2) > div > div.ui-radiobutton-box.ui-widget.ui-corner-all.ui-state-default > span"));
			Assert.assertTrue(dsl.isRadioMarcado("j_idt312:console:1"));
	}
		@Test
		public void deveInteragirComComboPrime() {
			DriverFactory.getDriver().get("https://www.primefaces.org/showcase/ui/input/oneMenu.xhtml?jfwid=5812d");
			dsl.clicarRadio(By.cssSelector("#j_idt311\\:option > div.ui-selectonemenu-trigger.ui-state-default.ui-corner-right > span"));
			dsl.clicarRadio(By.cssSelector("#j_idt311\\:option_2"));
	}

}

