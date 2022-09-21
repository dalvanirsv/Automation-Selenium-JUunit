package bc.ce.dalvani.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import br.ce.dalvani.core.DSL;
import br.ce.dalvani.core.DriverFactory;

	public class TesteAlert {
	
		private DSL dsl;
	
			@Before
			public void inicializa() {
				DriverFactory.getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
				DriverFactory.getDriver().manage().window().setSize(new Dimension(1200, 820));
				dsl = new DSL();	
		}
	
			@After
			public void finaliza() {
				DriverFactory.killDriver();
	
		}
	
			@Test
			public void DeveInteragirComAlertSimples() {
				dsl.clicarBotao("alert");
				String texto = dsl.alertaObterTextoEAceita();
				Assert.assertEquals("Alert Simples", texto);
				dsl.escreve("elementosForm:nome",texto);	
		}
	
			@Test
			public void DeveInteragirComAlertConfirm() {
				dsl.clicarBotao("confirm");
				Assert.assertEquals("Confirm Simples",dsl.alertaObterTextoEAceita());
				Assert.assertEquals("Confirmado", dsl.alertaObterTextoEAceita());
				dsl.clicarRadio("confirm");
				Assert.assertEquals("Confirm Simples", dsl.alertaObterTextoENega());
				Assert.assertEquals("Negado", dsl.alertaObterTextoENega());
		}
			
			@Test
			public void DeveInteragirComAlertPrompt() {
				dsl.clicarBotao("prompt");
				Assert.assertEquals("Digite um numero", dsl.alertaObterTexto());
				dsl.alertaEscrever("12");
				Assert.assertEquals("Era 12?",dsl.alertaObterTextoEAceita());
				Assert.assertEquals(":D", dsl.alertaObterTextoEAceita());
		}
			
	}
		
		
		
		
		
		
		
		
		
		
		
		

   
