package com.mycompany.texpress.controlador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycompany.texpress.daoImp.RolImp;
import com.mycompany.texpress.daoImp.UsuarioImp;
import com.mycompany.texpress.model.Rol;
import com.mycompany.texpress.model.Usuario;
import com.mycompany.texpress.repositorio.RolRepositorio;
import com.mycompany.texpress.repositorio.UsuarioRepositorio;


@Controller
@RequestMapping
public class RolControlador {
  
	
	    @Autowired
	    RolRepositorio rolRepositio;
	
	    @Autowired
	    RolImp rolImp;
	    @Autowired
		UsuarioRepositorio usuarioRepositorio;
		@Autowired
		UsuarioImp usuarioImp;
		
		
		
		
		@GetMapping("/paginarol")
		public String escogerRol(Rol rol , Model model) {
			
			Usuario obj = new Usuario(null, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null);
			Usuario aux;
			List<Usuario> lstusuario = new ArrayList<>();
			lstusuario = (List<Usuario>) usuarioImp.buscartodos();
			model.addAttribute("lstusuario", lstusuario);
			model.addAttribute("Usuario", new Usuario(0, null, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null));
			List<Rol> lstrol = new ArrayList<>();
			lstrol = (List<Rol>) rolImp.buscartodos();
			model.addAttribute("lstrol",lstrol);
			return "listroles";
		}
		
		
		@PostMapping ("/guardarRol")
		public String guardarRol(Usuario UsuarioRol, @RequestBody MultiValueMap<String,String> formData) {
			
			String idUsuario = formData.get("idusuario").get(0);
			String idrol = formData.get("idrol").get(0);
			
			Optional<Rol> rol =   rolRepositio.findById(Integer.parseInt(idrol));
	        Optional<Usuario> usuario =  usuarioRepositorio.findById(Integer.parseInt(idUsuario)); 
			
			Usuario usuariomodrol = usuario.get();
			usuariomodrol.setRoles((List<Rol>) rol.get());
			
			usuarioRepositorio.save(usuariomodrol);
				
	        
			
			
			return "listroles";
			
		}
		
		@RequestMapping(value = "/buscarRol", method = RequestMethod.GET)
	    public @ResponseBody
	    Rol buscarRol(HttpServletRequest request, HttpServletResponse response) throws IOException {
	        String idusuario = request.getParameter("idusuario");
	        Optional<Usuario> usuario =  usuarioRepositorio.findById(Integer.parseInt(idusuario));
	        Rol rol = new Rol();
	        rol = (Rol) usuario.get().getRoles();

	        return rol;
	    }
		
		
		
		
	
}
