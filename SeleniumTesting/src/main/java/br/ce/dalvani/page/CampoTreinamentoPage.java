package br.ce.dalvani.page;

import org.openqa.selenium.By;

import br.ce.dalvani.core.BasePage;

	public class CampoTreinamentoPage extends BasePage {
	
		public void setNome(String nome) {
			dsl.escreve("elementosForm:nome",nome);
	}
		public void setSobrenome(String sobrenome) {
			dsl.escreve("elementosForm:sobrenome",sobrenome);
	}
		public void setSexoMasculino() {
			dsl.clicarRadio("elementosForm:sexo:0");
	}
		public void setSexoFeminino() {
			dsl.clicarRadio("elementosForm:sexo:1");
	}
		public void setComidaPizza() {
			dsl.clicarRadio("elementosForm:comidaFavorita:2");
	}
		public void setComidaCarne() {
			dsl.clicarRadio("elementosForm:comidaFavorita:0");
	}
		public void setComidaVegetariano() {
			dsl.clicarRadio("elementosForm:comidaFavorita:3");
	}
		public void setEscolaridade(String valor) {
			dsl.selecionarCombo("elementosForm:escolaridade",valor);
	}
		public void setEsportes(String... valores) {
			for(String valor: valores)
				dsl.selecionarCombo("elementosForm:esportes",valor);
	}
		public void setCadastrar() {
			dsl.clicarBotao("elementosForm:cadastrar");
	}
		public String obterResultadoCadastro() {
			return dsl.ObterTexto(By.xpath(".//*[@id='resultado']/span"));
	} 
		public String obterNomeCadastro() {
			return dsl.ObterTexto(By.xpath(".//*[@id='descNome']/span"));
	}
		public String obterSobrenomeCadastro(){
			return dsl.ObterTexto(By.xpath(".//*[@id='descSobrenome']/span"));	
	}
		public String obterSexoCadastro(){
			return dsl.ObterTexto(By.xpath(".//*[@id='descSexo']/span"));
	}
		public String obtercomidaCadastro(){
			return dsl.ObterTexto(By.xpath(".//*[@id='descComida']/span"));
	}
		public String obterEscolaridadeCadastro(){
			return dsl.ObterTexto(By.xpath(".//*[@id='descEscolaridade']/span"));
	}
		public String obterEsporteCadastro(){
			return dsl.ObterTexto(By.xpath(".//*[@id='descEsportes']/span"));
	}
	
}