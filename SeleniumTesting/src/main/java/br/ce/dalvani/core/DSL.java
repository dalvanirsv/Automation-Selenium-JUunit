package br.ce.dalvani.core;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

	public class DSL {
	/******************* textField e TextArea *******************/

		public void escreve(By by, String texto) {
			DriverFactory.getDriver().findElement(by).clear();
			DriverFactory.getDriver().findElement(by).sendKeys(texto);
	}
		public void escreve(String id_campo, String texto) {
			escreve(By.id(id_campo),texto);
	}
		public String obterValorCampo(String id_campo) {
			return DriverFactory.getDriver().findElement(By.id(id_campo)).getAttribute("value");
			
	/***************** Radio e check ********************************/
	}

		public void clicarRadio(By by) {
			DriverFactory.getDriver().findElement(by).click();
	}
		public void clicarRadio(String id) {
			clicarRadio(By.id(id));
	}
		public boolean isRadioMarcado(String id) {
			return DriverFactory.getDriver().findElement(By.id(id)).isSelected();
	}
		public void clicarCheck(String id) {
			DriverFactory.getDriver().findElement(By.id(id)).click();
	}
		public boolean IsCheckMarcado(String id) {
			return DriverFactory.getDriver().findElement(By.id(id)).isSelected();
	}
	
	/**************************** Combo *******************************/
	
		public void selecionarCombo(String id, String valor) {
			WebElement element = DriverFactory.getDriver().findElement(By.id(id));
				Select combo = new Select(element);
					combo.selectByVisibleText(valor);
	}
		public void deselecionarCombo(String id, String valor) {
			WebElement element = DriverFactory.getDriver().findElement(By.id(id));
				Select combo = new Select(element);
					combo.deselectByVisibleText(valor);	
	}
		public String obterValorCombo(String id) {
			WebElement element = DriverFactory.getDriver().findElement(By.id(id));
				Select combo = new Select(element);
					return combo.getFirstSelectedOption().getText();
	}
		public List<String> obterValoresCombo(String id) {
			WebElement element = DriverFactory.getDriver().findElement(By.id("elementosForm:esportes"));
				Select combo = new Select(element);
					List<WebElement> allSelectedOptions = combo.getAllSelectedOptions();
					List<String> valores = new ArrayList<String>();
						for(WebElement opcao: allSelectedOptions) {
								valores.add(opcao.getText());
		}
						return valores;
	}
		public int obterQuantidadeOpcoesCombo(String id) {
			WebElement element = DriverFactory.getDriver().findElement(By.id(id));
				Select combo = new Select(element);
					List<WebElement> options = combo.getOptions();
						return options.size();
		}
		public boolean verificarOpcaoCombo(String id, String opcao) {
			WebElement element = DriverFactory.getDriver().findElement(By.id(id));
				Select combo = new Select(element);
					List<WebElement> options = combo.getOptions();
						for(WebElement option: options) {
							if(option.getText().equals(opcao)) {
									return true;
			}
		}
									return false;
	}
		public void SelecionarComboPrime(String radical, String valor) {
			clicarRadio(By.cssSelector("#j_idt311\\:option > div.ui-selectonemenu-trigger.ui-state-default.ui-corner-right > span"));
			clicarRadio(By.cssSelector("#j_idt311\\:option_2"));
		
	}
	
	/************************************ botao ******************************************/
	
		public void clicarBotao(String id) {
			DriverFactory.getDriver().findElement(By.id(id)).click();
	}
		public String obterValueElemento(String id) {
			return DriverFactory.getDriver().findElement(By.id(id)).getAttribute("value");
	}
	
	/************************************ Link ******************************************/
	
		public void clicarLink(String link) {
			DriverFactory.getDriver().findElement(By.linkText(link)).click();
	}
	
	/************************************ textos ******************************************/
	
		public String ObterTexto(By by) {
			return DriverFactory.getDriver().findElement(by).getText();
	}
		public String ObterTexto(String id) {
			return ObterTexto(By.id(id));
	}
	
	/************************************ Alerts ******************************************/
	
		public String alertaObterTexto() {
			Alert alert = DriverFactory.getDriver().switchTo().alert();
				return alert.getText();
	}
		public String alertaObterTextoEAceita() {
			Alert alert = DriverFactory.getDriver().switchTo().alert();
				String valor = alert.getText();
					alert.accept();
						return valor;
	}
		public String alertaObterTextoENega() {
			Alert alert = DriverFactory.getDriver().switchTo().alert();
				String valor = alert.getText();
					alert.dismiss();
						return valor;	
	}
		public void alertaEscrever(String valor) {
			Alert alert = DriverFactory.getDriver().switchTo().alert();
				alert.sendKeys(valor);
					alert.accept();
	}
	
	/*****************************Frames e Janelas ******************************************/
	
		public void entrarFrame(String id) {
			DriverFactory.getDriver().switchTo().frame(id);
	}
		public void sairFrame() {
			DriverFactory.getDriver().switchTo().defaultContent();	
	}
		public void trocarJanela(String id) {
			DriverFactory.getDriver().switchTo().window(id);
	}
	
	/***************************** JS ****************************************/
	
		public Object executarJS(String cmd, Object ...param) {
			JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
				return js.executeScript(cmd, param);
	
	}
	/******************** TABELA ****************************************/
	
			public void clicarBotaotabela(String colunaBusca, String valor, String colunaBotao) {
				//procurar coluna do registro
				WebElement tabela = DriverFactory.getDriver().findElement(By.xpath("//*[@id='elementosForm:tableUsuarios']"));
					@SuppressWarnings("unused")
						int idColuna = obterindicecoluna(colunaBusca, tabela);
	}
			private int obterindicecoluna(String colunaBusca, WebElement tabela) {
				// TODO Auto-generated method stub
					return 0;
	}
			
}

	
	


   

