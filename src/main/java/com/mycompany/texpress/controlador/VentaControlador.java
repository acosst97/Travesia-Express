package com.mycompany.texpress.controlador;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mycompany.texpress.daoImp.UploadFile;
import com.mycompany.texpress.daoImp.UsuarioImp;
import com.mycompany.texpress.daoImp.VentaImp;
import com.mycompany.texpress.model.Usuario;
import com.mycompany.texpress.model.Venta;
import com.mycompany.texpress.repositorio.UsuarioRepositorio;
import com.mycompany.texpress.repositorio.VentaRepositorio;

@Controller
@RequestMapping
public class VentaControlador {

	@Autowired
	UploadFile uploadFile;
	
	@Autowired
	VentaImp ventaImp;
	
	@Autowired
	VentaRepositorio ventaRepositorio;
	
	@Autowired
	UsuarioImp usuarioImp;
	
	@Autowired
	UsuarioRepositorio usuarioRepositorio;
	

	@GetMapping("/listarventas")
	public String listarventas (Model model) {
	List<Venta> lstVentas = this.ventaImp.buscartodos();
	model.addAttribute("lstVentas", lstVentas);
	return "inicio";
	}
	
	@GetMapping("/new")
	public String pagos( Model model) {
		model.addAttribute("venta", new Venta());
		List<Venta> lstpaquete = this.ventaImp.buscartodos();
		model.addAttribute("lstpaquete" ,lstpaquete);
		return "pagos";
	}
		
	@PostMapping("/guardarventa")
	public String guardarventa(@Valid  @ModelAttribute("venta")    Venta venta,
			BindingResult result, Usuario usuario,   Model model , RedirectAttributes attribute )
	{
		Usuario validar = usuarioRepositorio.findByidusuario(usuario.getIdusuario());
		
		if(result.hasErrors())
		{			
			return"redirect:/new";
		}		
		if (validar==null) {
			return "redirect:/new";
		}	else {
			ventaImp.crearVenta(venta);	
			attribute.addFlashAttribute("success", "venta guardado con exito");
		}
		return "redirect:/new";
	}
	
	
	@GetMapping("/eliminarventa/{idventa}")
	public String delete (Model model, @PathVariable Integer idventa) {
		ventaImp.eliminarVenta(idventa);
		return "redirect:/listarventas";
	}
				
	
	
	
	
	/* dash board cliente*/
	@GetMapping("/Reporventas")
	public String listven(Usuario usuario, Venta venta, Model model)  {
		
		/*Usuario usuario1 =  usuarioRepositorio.findByidusuario(usuario.getIdusuario());
		usuario1.setIdusuario(556);
	    if (usuario1.getRoles().get(0).getNombrerol().equals("cliente")) {
	    	model.addAttribute("lstUsuario", usuario1);
	    	List<Venta> lstventas = ventaImp.buscartodos();			
			
			model.addAttribute("lstventas", lstventas);
		}*/			
		Usuario usuario1 =  usuarioRepositorio.findByidusuario(usuario.getIdusuario());
		model.addAttribute("lstUsuario", usuario1);
    	List<Venta> lstventas = ventaImp.buscartodos();				
		model.addAttribute("lstventas", lstventas);
		return "tablacompras";
	}
	
}
