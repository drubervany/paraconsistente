package br.com.paraconsistente.teste.gerente;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:caracteristicas", 
				 glue = "br.com.paraconsistente.teste.gerente", 
				 monochrome = true, 
				 dryRun = false)
public class GerenteTesteRun {
}