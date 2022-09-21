package br.ce.dalvani.suites;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import bc.ce.dalvani.test.TesteCadastro;
import bc.ce.dalvani.test.TesteRegrasCadastro;
import br.ce.dalvani.core.DriverFactory;

	@RunWith(Suite.class)
	@SuiteClasses({
		TesteCadastro.class,
		TesteRegrasCadastro.class,
	})
	
	public class SuiteTest {
	
	@AfterClass
		public static void finalizaTudo() {
			DriverFactory.killDriver();
		
	}
	
}
