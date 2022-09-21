package bc.ce.dalvani.test;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.ce.dalvani.core.BaseTest;
import br.ce.dalvani.core.DSL;
import br.ce.dalvani.core.DriverFactory;
import br.ce.dalvani.page.CampoTreinamentoPage;

	@RunWith(Parameterized.class)
	public class TesteRegrasCadastro extends BaseTest {
		
		private WebDriver driver;
		private DSL dsl;
		private CampoTreinamentoPage page;
	
			@Parameter
				public String nome;
			@Parameter(value=1)
				public String sobrenome;
			@Parameter(value=2)
				public Object sexo;
			@Parameter(value=3)
				public List<String> comidas;
			@Parameter(value=4)
				public String[] esportes;
			@Parameter(value=5)
				public String msg;

			@Before
			public void inicializa() {
				DriverFactory.getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
				driver = new ChromeDriver();
				driver.manage().window().setSize(new Dimension(1200, 820));
				dsl = new DSL();
				page = new CampoTreinamentoPage();		
	}
			@Parameters
			public static Collection<Object[]> getCollection(){
				return Arrays.asList(new Object[][]{
					{"","","", Arrays.asList(), new String[] {}, "Nome eh obrigatorio"},
					{"dalvani","","", Arrays.asList(), new String[] {}, "Sobrenome eh obrigatorio"},
					{"dalvanir","vieira","", Arrays.asList(), new String[] {}, "Sexo eh obrigatorio"},
					{"dalvanir","vieira","Masculino", Arrays.asList("Carne","Vegetariano"), new String[] {}, "Tem certeza que voce eh vegetariano?"},
					{"dalvanir","vieira","Masculino", Arrays.asList("Carne"), new String[] {"Karate", "O que eh esporte?"}, "Voce faz esporte ou nao?"},
	});
}
	
			@Test
			public void DeveValidaRegras() {
				page.setNome(nome);
				page.setSobrenome(sobrenome);
				if(sexo.equals("Masculino")) {
				page.setSexoMasculino();
	}  
				if(sexo.equals("Feminino")) {
				page.setSexoFeminino(); 
		
	}
		
				if(comidas.contains("Carne")) page.setComidaCarne();
				if(comidas.contains("Pizza")) page.setComidaPizza();
				if(comidas.contains("Vegetariano")) page.setComidaVegetariano();
				page.setEsportes(esportes);
				page.setCadastrar();
				System.out.println(msg);
				Assert.assertEquals(msg, dsl.alertaObterTextoEAceita());
	}
	
}
