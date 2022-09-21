package bc.ce.dalvani.test;

import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import br.ce.dalvani.core.DSL;
import br.ce.dalvani.core.DriverFactory;

	public class TesteCampoTreinamento {
	private DSL dsl;
	
		@Before
		public void inicializa() {
			System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
			DriverFactory.getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
			DriverFactory.getDriver().manage().window().setSize(new Dimension(1200, 820));
			dsl = new DSL();
	}
	
		@After
		public void finaliza() {
			DriverFactory.killDriver();
	}
	
		@Test
		public void testeTextField() {
			dsl.escreve("elementosForm:nome", "Teste de escrita");
			Assert.assertEquals("Teste de escrita", dsl.obterValorCampo("elementosForm:nome"));
	}
		@Test
		public void testeTextFieldDuplo() {
			dsl.escreve("elementosForm:nome", "dalvani");
			Assert.assertEquals("dalvani", dsl.obterValorCampo("elementosForm:nome"));
			dsl.escreve("elementosForm:nome", "vieira");
			Assert.assertEquals("vieira", dsl.obterValorCampo("elementosForm:nome"));
	}
		@Test
		public void DeveInteragirComTextArea() {
			dsl.escreve("elementosForm:sugestoes", "teste");
			Assert.assertEquals("teste", dsl.obterValorCampo("elementosForm:sugestoes"));
	}
		@Test
		public void DeveInteragirComRadioButton() {
			dsl.clicarRadio("elementosForm:sexo:0");
			Assert.assertTrue(dsl.isRadioMarcado("elementosForm:sexo:0"));
			
	}
		@Test
		public void DeveInteragirComCheckbox() {
			dsl.clicarRadio("elementosForm:comidaFavorita:2");
			Assert.assertTrue(dsl.isRadioMarcado("elementosForm:comidaFavorita:2"));
	}
		@Test
		public void DeveInteragirComCombo() {
			dsl.selecionarCombo("elementosForm:escolaridade", "2o grau completo");
			Assert.assertEquals("2o grau completo" , dsl.obterValorCombo("elementosForm:escolaridade"));
	}
	
		@Test
		public void DeveVerificarValoresCombo() {
			Assert.assertEquals(8, dsl.obterQuantidadeOpcoesCombo("elementosForm:escolaridade"));
			Assert.assertTrue(dsl.verificarOpcaoCombo("elementosForm:escolaridade", "Mestrado"));	
	}
		@Test
		public void DeveVerificarValoresComboMultiplo() {
			dsl.selecionarCombo("elementosForm:esportes", "Natacao");
			dsl.selecionarCombo("elementosForm:esportes", "Corrida");
			dsl.selecionarCombo("elementosForm:esportes", "O que eh esporte?");
			List<String> opcoesMarcadas = dsl.obterValoresCombo("elementosForm:esportes");
			Assert.assertEquals(3, opcoesMarcadas.size());
			dsl.deselecionarCombo("elementosForm:esportes", "Corrida");
			opcoesMarcadas = dsl.obterValoresCombo("elementosForm:esportes");
			Assert.assertEquals(2, opcoesMarcadas.size());
			Assert.assertTrue(opcoesMarcadas.containsAll(Arrays.asList("Natacao" , "O que eh esporte?" )));
	}
		@Test
		public void DeveInteragirComBotoes() {
			dsl.clicarBotao("buttonSimple");
			Assert.assertEquals("Obrigado!", dsl.obterValueElemento("buttonSimple"));	
	}
		@Test
		public void DeveInteragirComLinks() {
			dsl.clicarLink("Voltar");
			Assert.assertEquals("Voltou!", dsl.ObterTexto("resultado"));
	}
		@Test
		public void DeveBuscarTextosNaPagina() {
//			Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Campo de Treinamento"));
			Assert.assertEquals("Campo de Treinamento", dsl.ObterTexto(By.tagName("h3")));
			Assert.assertEquals("Cuidado onde clica, muitas armadilhas...", dsl.ObterTexto(By.className("facilAchar")));
	}
		@Test
		public void testJavascript() {
			JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
			js.executeScript("document.getElementById('elementosForm:nome').value = 'escrita via js'");
			js.executeScript("document.getElementById('elementosForm:sobrenome').value = 'radio'");
			WebElement element =  DriverFactory.getDriver().findElement(By.id("elementosForm:nome"));
			js.executeScript("arguments[0].style.border = arguments[1]", element, "solid 4px red");
	}
}	
		
		
		
		
		
		
	