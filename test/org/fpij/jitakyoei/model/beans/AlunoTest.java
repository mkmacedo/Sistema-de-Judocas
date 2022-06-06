package org.fpij.jitakyoei.model.beans;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.Date;

public class AlunoTest extends TestCase {
    public static Filiado alunoFiliado = new Filiado();
    public static Endereco enderecoEntidade = new Endereco();
    public static Endereco enderecoProfessor = new Endereco();
    public static Entidade entidade = new Entidade();
    public static Filiado professorFiliado = new Filiado();
    public static Filiado rg = new Filiado();

    public static Professor professor = new Professor();
    public static Aluno aluno = new Aluno();


    public AlunoTest(){

        enderecoEntidade.setBairro("Moema");
        enderecoEntidade.setCep("04122-000");
        enderecoEntidade.setCidade("São Paulo");
        enderecoEntidade.setEstado("SP");
        enderecoEntidade.setRua("Av. Ibirapuera");

        enderecoProfessor.setBairro("Brooklin");
        enderecoProfessor.setCep("02422-020");
        enderecoProfessor.setCidade("São Paulo");
        enderecoProfessor.setEstado("SP");
        enderecoProfessor.setRua("Av. Morumbi");

        entidade = new Entidade();
        entidade.setEndereco(enderecoEntidade);
        entidade.setNome("Academia 1");
        entidade.setTelefone1("(11)9999-5555");
        entidade.setCnpj("01.022.022/0001-22");

        professorFiliado.setNome("Jack");
        professorFiliado.setCpf("66.776.876-45");
        professorFiliado.setDataNascimento(new Date());
        professorFiliado.setDataCadastro(new Date());
        professorFiliado.setId(53434L);
        professorFiliado.setEndereco(enderecoProfessor);

        professor.setFiliado(professorFiliado);

        alunoFiliado.setNome("Jay");
        alunoFiliado.setCpf("065.888.989-18");
        alunoFiliado.setDataNascimento(new Date());
        alunoFiliado.setDataCadastro(new Date());
        alunoFiliado.setId(5678L);


    }

    public void testGetFiliado() {


        aluno.setFiliado(alunoFiliado);
        Assert.assertEquals("Jay", aluno.getFiliado().getNome());
    }

    public void testGetEntidade() {

        aluno.setEntidade(entidade);
        Assert.assertEquals("Academia 1", aluno.getEntidade().getNome());
        Assert.assertEquals("(11)9999-5555", aluno.getEntidade().getTelefone1());
        Assert.assertEquals("Av. Ibirapuera", aluno.getEntidade().getEndereco().getRua());
        Assert.assertEquals("01.022.022/0001-22", aluno.getEntidade().getCnpj());

    }

    public void testGetProfessor() {

        aluno.setProfessor(professor);
        Assert.assertEquals("Av. Morumbi", professor.getFiliado().getEndereco().getRua());
        Assert.assertEquals("66.776.876-45", professor.getFiliado().getCpf());

    }

}