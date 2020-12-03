package salaodebeleza;

import java.util.List;

import org.junit.Test;

import com.salaodebeleza.model.modells.Usuario;
import com.salaodebeleza.model.service.UsuarioService;


public class UsuarioTest {
	
	//@Test(expected = Exception.class)
	public void salvarUsuarioBancoDadosTeste() {
		//GRAVANDO O PRIMEIRO USUARIO
		Usuario usuario = new Usuario();

		//usuario.setId(1);
		usuario.setUsername("Nathalia Maria Urenha Machado");
		usuario.setPassword("123456");
		usuario.setEmail("naty.urenha@gmail.com");
		usuario.setAtivo(false);
		

		UsuarioService usuarioService = new UsuarioService();

		usuarioService.save(usuario);
		System.out.println(usuario.toString());

		System.out.println("Gravando usuário " +usuario.getUsername()+ " no banco de dados");

		//GRAVANDO O SEGUNDO USUARIO
		usuario = new Usuario();

		//usuario.setId(2);
		usuario.setUsername("Igor Solfa Romero");
		usuario.setPassword("12345678");
		usuario.setEmail("igorsolfa@gmail.com");
		usuario.setAtivo(false);
		
		UsuarioService usuarioService1 = new UsuarioService();

		usuarioService1.save(usuario);

		System.out.println(usuario.toString());
		System.out.println("Gravando usuário " +usuario.getUsername()+ " no banco de dados");


		//assertTrue(true);

		//GRAVANDO O TERCEIRO USUARIO

		usuario = new Usuario();

		//usuario.setId(3);
		usuario.setUsername("Leila Marcia Urenha Ferreira");
		usuario.setPassword("14628");
		usuario.setEmail("leila.urenha10@gmail.com");
		usuario.setAtivo(false);
	

		UsuarioService usuarioService2 = new UsuarioService();

		usuarioService2.save(usuario);

		System.out.println(usuario.toString());
		System.out.println("Gravando usuário " +usuario.getUsername()+ " no banco de dados");


		//assertTrue(true);


	}


	//@Test(expected = Exception.class)
	public void alterarUsuarioBancoDadosTeste() {

		Usuario usuario = new Usuario();

		usuario.setId(2);

		UsuarioService usuarioService = new UsuarioService();

		usuario = usuarioService.findById(usuario.getId());

		System.out.println(usuario.toString());

		usuario.setEmail("igor.romero@gmail.com");

		usuarioService.update(usuario);

		System.out.println("Ateração usuário no banco de dados");

		//assertTrue(true);


	}

	//@Test(expected = Exception.class)
	public void listarTodosUsuarioTabelaUsuario() {

		UsuarioService usuarioService = new UsuarioService();

		List<Usuario> listaUsuario = usuarioService.findAll();

		for (Usuario usuario : listaUsuario) {
			System.out.println(usuario.toString());
		}



	}

	//@Test
	public void excluirUsuarioDaTabela() {

		Usuario usuario = new Usuario();

		usuario.setId(2);

		UsuarioService usuarioService = new UsuarioService();

		usuarioService.delete(usuario);

		usuario = new Usuario();


		usuario.setId(3);

		UsuarioService usuarioService1 = new UsuarioService();

		usuarioService1.delete(usuario);

	}

}
