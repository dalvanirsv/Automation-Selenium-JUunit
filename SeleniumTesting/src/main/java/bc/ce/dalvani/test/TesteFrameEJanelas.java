package bc.ce.dalvani.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import br.ce.dalvani.core.DSL;
import br.ce.dalvani.core.DriverFactory;

	public class TesteFrameEJanelas {
	private WebDriver driver;
	private DSL dsl;
	
		@Before
		public void inicializa() {
			DriverFactory.getDriver().get("https://user.dir\") + \"/src/main/resources/componentes.html\"");
			DriverFactory.getDriver().manage().window().setSize(new Dimension(1200, 820));
			dsl = new DSL();
	}
		@After
		public void finaliza() {
			DriverFactory.killDriver();
	}
		@Test
		public void DeveInteragirComFrames() {
			dsl.entrarFrame("frame1");
			dsl.clicarBotao("frameButton");
			String msg = dsl.alertaObterTextoEAceita();
			Assert.assertEquals("Frame OK!", msg);
			dsl.sairFrame();
			dsl.escreve("elementosForm:nome",msg);
	}
		@Test
		public void deveInteragirComFrameEscondido() {
			WebElement frame = driver.findElement(By.id("frame2"));
			dsl.executarJS("window.scrollBy(0, arguments[0])",frame.getLocation().y);
			dsl.entrarFrame("frame2");
			dsl.clicarBotao("framebutton");
			String msg = dsl.alertaObterTextoEAceita();
			Assert.assertEquals("Frame OK!", msg);
	}
		@Test
		public void DeveInteragirComJanelas() {
			dsl.clicarBotao("buttonPopUpEasy");
			dsl.trocarJanela("Popup");
			dsl.escreve(By.tagName("textarea"),"Deu certo?");
			driver.close();
			dsl.trocarJanela("");
			dsl.escreve(By.tagName("textarea"),"e agora?");
	}
		@Test
		public void DeveInteragirComJanelasSemTitulo() {	
			dsl.clicarBotao("buttonPopUpHard");
			System.out.println(driver.getWindowHandle());    
			System.out.println(driver.getWindowHandles());  
			dsl.trocarJanela((String) driver.getWindowHandles().toArray()[1]);
			dsl.escreve(By.tagName("textarea"),"Deu certo");
			dsl.trocarJanela((String) driver.getWindowHandles().toArray()[0]);
			dsl.escreve(By.tagName("textarea"),"E agora?");
	}
}
