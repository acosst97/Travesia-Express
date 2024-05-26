package com.mycompany.texpress;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.mycompany.texpress.repositorio.UsuarioRepositorio;

@SpringBootTest
class TexpressApplicationTests { 
	
	@Autowired
	UsuarioRepositorio usurepo;
	
	BCryptPasswordEncoder encoder;
	
	@Test
	public void crearUsuario() {
		
/*		Usuario usuario = new Usuario();
		usuario.setIdusuario(354);
		usuario.setNombreusuario("segun");
		usuario.setClave( encoder.encode("56d"));

		Usuario retorno = usurepo.save(usuario);
		
		assertTrue(retorno.getClave().equalsIgnoreCase(usuario.getClave()));*/
				}
	
	
	
	
	
	

}
