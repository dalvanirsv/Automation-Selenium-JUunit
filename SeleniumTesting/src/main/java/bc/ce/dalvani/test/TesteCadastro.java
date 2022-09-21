package bc.ce.dalvani.test;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import br.ce.dalvani.core.BaseTest;
import br.ce.dalvani.core.DriverFactory;
import br.ce.dalvani.page.CampoTreinamentoPage;

	public class TesteCadastro extends BaseTest {
	private CampoTreinamentoPage page;
	
		@Before
		public void inicializa() {
		
			DriverFactory.getDriver().get("file:///" + System.getProperty("user.dir") + "/src/main/resources/componentes.html");
			page = new CampoTreinamentoPage();
	}
	
		@Test
		public void DeveRealizarCadastroComSucesso() {
			page.setNome("dalvanir");
			page.setSobrenome("vieira");
			page.setSexoMasculino();
			page.setComidaPizza();
			page.setEscolaridade("Mestrado");
			page.setEsportes("Natacao");
			page.setCadastrar();
			Assert.assertEquals("Cadastrado!", page.obterResultadoCadastro());
			Assert.assertEquals("dalvanir",page.obterNomeCadastro());
			Assert.assertEquals("vieira",page.obterSobrenomeCadastro());
			Assert.assertEquals("Masculino", page.obterSexoCadastro());
			Assert.assertEquals("Pizza", page.obtercomidaCadastro());
			Assert.assertEquals("mestrado", page.obterEscolaridadeCadastro());
			Assert.assertEquals("Natacao", page.obterEsporteCadastro());
	
	}
		
}
