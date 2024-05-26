package com.mycompany.texpress.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class RegistroControlador {

	
	
	@GetMapping("/login" )
	public String iniciarSesion() {
				
		return "login";
	}
	
	@GetMapping("/")
	public String verinex() {
				
		return "index";
	}
}
