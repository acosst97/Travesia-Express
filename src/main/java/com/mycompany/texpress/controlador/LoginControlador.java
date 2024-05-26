package com.mycompany.texpress.controlador;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.mycompany.texpress.daoImp.EnviarEmailImp;
import com.mycompany.texpress.daoImp.UsuarioImp;
import com.mycompany.texpress.model.Usuario;
import com.mycompany.texpress.repositorio.UsuarioRepositorio;
import com.mycompany.texpress.resetcontra.UsuarioNotFoundException;


import net.bytebuddy.utility.RandomString;

@Controller
@RequestMapping
public class LoginControlador {

	@Autowired
	UsuarioImp usuarioImp;
	
	@Autowired
	UsuarioRepositorio usuarioRepositorio;
	
	@Autowired
	private EnviarEmailImp enviarEmailImp;
	
	 
	 @GetMapping ("/index")
     public String index(){
     return "index";   
     }
	
	
	 @GetMapping ("/inicioadmi")
	    public String formulario(Usuario usuario){
	    return "inicioadmi";
	    }
	
	/* @PostMapping("/IniciarSesion")
	 public String iniciarSesion(@Validated Usuario usuario,BindingResult result, Model model) {
		 
		 
		 Usuario validar = usuarioRepositorio.findByidusuarioAndClave(usuario.getIdusuario(), usuario.getClave());
		 if (validar == null) {
			
			return "redirect:/inicioadmi";
		} else if (validar.getRoles().get(0).getNombrerol().equals("administrador")){
				model.addAttribute("lstUsuario", validar);
         return "inicioDash";
		}else if (validar.getRoles().get(0).getNombrerol().equals("cliente")) {
			model.addAttribute("clienteUsuario", validar);
			return "inicioDash2";
		}else if (validar.getRoles().get(0).getNombrerol().equals("empleado")) {
			model.addAttribute("empleadoUsuario", validar);
			return "iniciocondu";
		} else {
			System.out.println("el usuario no puede estar vacio");
			 		
			 return "redirect:/inicioadmi" ;
		}
		 
     
	 } 	 */
	  

	 
	 
  	 /* inicio al dash de administrador */
		@GetMapping ("/inicioDash")
	    public String inicioDash(){
	    return "inicioDash";
	    }
	 
		
		@GetMapping ("/inicioDash2")
	    public String inicioDash2(){
	    return "inicioDash2";
	    }
	 
	

	 
	 
	 
	 
	 
	 
	 
	 
	
	
	 
	 
}
