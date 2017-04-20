package br.sceweb.teste;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.sceweb.modelo.Empresa;
import br.sceweb.modelo.EmpresaDAO;

public class UC01CadastrarEmpresa {
	static EmpresaDAO empresaDAO;
	static Empresa empresa;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		empresaDAO = new EmpresaDAO();
		empresa = new Empresa();
		empresa.setNomeDaEmpresa("empresa x");
		empresa.setCnpj("63044195000191");
		empresa.setNomeFantasia("empresa x");
		empresa.setEndereco("rua taquari");
		empresa.setTelefone("2222");
	}
	
	/**
	 * verifica o comportamento do sistema na inclusao de um cnpj valido
	 */
	@Test
	public void CT01UC01FBCadastra_com_sucesso() {
		assertEquals(1,empresaDAO.adiciona(empresa));
	}
	/**
	 * verifica o comportamento do sistema na inclusao de um cnpj ja cad
	 */
	@Test (expected = RuntimeException.class)
	public void CT02UC01A2Cadastra_cnpj_ja_cadastrado(){
		empresaDAO.adiciona(empresa);
		empresaDAO.adiciona(empresa);
	}

	@Test
	public void CT03UC01A3Cadastra_empresa_cnpj_invalido(){
		Empresa empresa2 = new Empresa();
		try{
			empresa2.setCnpj("8942423200018");
			fail("deveria disparar uma expection");
		} catch (Exception e){
			assertEquals("CNPJ inv�lido!", e.getMessage());
		}
	}
	
	@Test
	public void CT04UC01A4Cadastra_empresa_sem_nome(){
		Empresa empresa3 = new Empresa();
		try{
			empresa3.setNomeDaEmpresa("");
			fail("deveria disparar uma expection");
		} catch (Exception e){
			assertEquals("nome da empresa inv�lido!", e.getMessage());
		}
	}
	
	@After
	public void tearDownAfterClass() throws Exception {
		empresaDAO.exclui("63044195000191");
	}



}
