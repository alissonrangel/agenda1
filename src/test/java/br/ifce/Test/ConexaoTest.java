package br.ifce.Test;

import static org.junit.Assert.*;
import br.ifce.Utilitarios.Conect;

import org.junit.Test;

public class ConexaoTest {

	@Test
	public void test() {
		Conect conexao = new Conect();
			
		String resultado = conexao.getContato();
		
		assertEquals("message", "Alisson", resultado);
	}

}
