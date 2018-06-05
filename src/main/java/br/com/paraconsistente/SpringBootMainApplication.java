package br.com.paraconsistente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import br.com.paraconsistente.configuration.JpaConfiguration;


/**
 * The Class SpringBootMainApplication.
 * Inicial para subir a aplicacao back end
 */
@Import(JpaConfiguration.class)
@SpringBootApplication(scanBasePackages={"br.com.paraconsistente"})
// same as @Configuration @EnableAutoConfiguration @ComponentScan
public class SpringBootMainApplication {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringBootMainApplication.class, args);
	}
}