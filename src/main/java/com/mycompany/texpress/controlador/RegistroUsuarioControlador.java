package com.mycompany.texpress.controlador;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.mycompany.texpress.dao.UsuarioService;
import com.mycompany.texpress.dao.UsuarioServicio;
import com.mycompany.texpress.daoImp.RolImp;
import com.mycompany.texpress.model.Rol;
import com.mycompany.texpress.usuarios.Dto.UsuarioRegistroDto;

@Controller
@RequestMapping("/registro")
public class RegistroUsuarioControlador {

	@Autowired
	private UsuarioService usuarioServicio;
	@Autowired
	private RolImp rolImp;

	@ModelAttribute("usuario")
	public UsuarioRegistroDto retornarnuevoUsuarioRegistroDto() {

		return new UsuarioRegistroDto();
	}

	@GetMapping
	public String mostrarformS(){		
		return "registro";
	}

	@PostMapping
	public String registrarcuentausuario(@ModelAttribute("usuario") @Valid UsuarioRegistroDto registroDto,BindingResult result,Model model ) {

		/* registro desde el index*/
			if (result.hasErrors()) {	
				Collection<Rol> listRol = this.rolImp.buscartodos();
	            model.addAttribute("listRol", listRol);
				return "registro";
			}
		usuarioServicio.guardar(registroDto);
		return "redirect:/registro?exito";
	}
	
	
}
