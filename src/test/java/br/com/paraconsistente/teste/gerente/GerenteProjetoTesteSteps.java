package br.com.paraconsistente.teste.gerente;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import br.com.paraconsistente.models.GerenteProjeto;
import cucumber.api.PendingException;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class GerenteProjetoTesteSteps {

    @Dado("^que exista o  gerente de projeto \"([^\"]*)\", \"([^\"]*)\" e \"([^\"]*)\"$")
    public void que_exista_o_gerente_de_projeto_e(String nome, String cpf, String email) throws Throwable {

        GerenteProjeto gerenteProjeto = new GerenteProjeto(1, nome, cpf, email);

        assertNotNull(gerenteProjeto);
        assertEquals(gerenteProjeto.getNome(), nome);
        assertEquals(gerenteProjeto.getCpf(), cpf);
        assertEquals(gerenteProjeto.getEmail(), email);
    }

    @Quando("^realizar o cadastro do projeto$")
    public void realizar_o_cadastro_do_projeto() throws Throwable {

        throw new PendingException();
    }

    @Entao("^faz a tomada de decisao$")
    public void faz_a_tomada_de_decisao() throws Throwable {

        throw new PendingException();
    }

}