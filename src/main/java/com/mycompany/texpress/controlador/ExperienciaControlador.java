package com.mycompany.texpress.controlador;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mycompany.texpress.daoImp.ExperienciaImp;
import com.mycompany.texpress.daoImp.UsuarioImp;

import com.mycompany.texpress.model.Experiencia;
import com.mycompany.texpress.model.Usuario;
import com.mycompany.texpress.repositorio.ExperienciaRepositorio;
import com.mycompany.texpress.repositorio.UsuarioRepositorio;

@Controller
@RequestMapping
public class ExperienciaControlador {

	
	@Autowired
	UsuarioRepositorio usuarioRepositorio;
	
	@Autowired
	ExperienciaImp experienciaImp;
	
	@Autowired
	ExperienciaRepositorio experienciaRepositorio;
	
	@Autowired
    UsuarioImp usuarioImp;
	

	
	
	@GetMapping("/empleos")
	public String empleo() {
		return "empleos";
	}
	
	/* Listar ex */
	@GetMapping("/recursoshumanos")
	public String listaTodosex(Experiencia experiencia,Model model){
	    
		List<Experiencia> lstExperiencia = this.experienciaImp.buscartodos();
		model.addAttribute("lstExperiencia",lstExperiencia);		
		return"recursoshumanos";
		
	}
	
	@GetMapping("/regExperiencia")
	public String crearExperiencia (Experiencia experiencia, Model model){
		
		model.addAttribute("experiencia",new  Experiencia());
		return "experiencia";
	}
	
	@PostMapping("/guardarExperiencia")
    public String guardarExperiencia(Experiencia experiencia , Model model, Usuario usuario) {			
			experienciaImp.CrearExperiencia(experiencia);	
    return "redirect:/index";
    
    
   }
	
	
	
	
	  @RequestMapping("/eliminarexperiencia")
    public String eliminarex(@RequestParam(name = "idexperiencia", defaultValue = "0") int idexperiencia) {
        experienciaImp.EliminarExperiencia(idexperiencia);
        return "redirect:/recursoshumanos"; 
    
    } 
	
	  
	  
	  /* envio de correos masivos*/
	
	
	 
	  
	  
}
