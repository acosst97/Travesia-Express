package com.mycompany.texpress.controlador;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.texpress.daoImp.RolImp;
import com.mycompany.texpress.daoImp.UsuarioImp;
import com.mycompany.texpress.model.Rol;
import com.mycompany.texpress.model.Usuario;
import com.mycompany.texpress.model.Vehiculo;
import com.mycompany.texpress.repositorio.UsuarioRepositorio;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;



@Controller
@RequestMapping
public class UsuarioControlador {
    
    @Autowired
    RolImp rolImp;
    @Autowired
	UsuarioRepositorio usuarioReposiotorio;
	@Autowired
	UsuarioImp usuarioImp;	
	
	@GetMapping("/lstUsuario")
	public String listaTodos(Usuario usuario,Model model){
	    
		/*Usuario cliente = usuarioReposiotorio.findByidusuario(usuario.getIdusuario());
		model.addAttribute("lstcliente",cliente);*/
		
		List<Usuario> lstUsuario = this.usuarioImp.buscartodos();
		model.addAttribute("lstUsuario",lstUsuario);		
		List<Rol> lstRoles = this.rolImp.buscartodos();
		model.addAttribute("lstRoles", lstRoles);
		return "index1";
		
	}
	
	
	/* registro desde el index*/
	
	/*@GetMapping("/registrousuarios")
    public String formualrioregistro(Model model){
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("rol", new Rol());
    return "registro";   
    }
	
	
	@PostMapping("/guardarusuario")
	public String guardau(@Valid @ModelAttribute("usuario") Usuario usuario , BindingResult result, Model model ) {
		
		if (result.hasErrors()) {
			
			return "registro";
		} 
			
			usuarioImp.crearUsuario(usuario);
			return "redirect:/inicioadmi";	
		
	}
	*/
	
	/* registro  cliente desde administracion*/
	
	
	@GetMapping("/registrousuario2")
    public String formualrioregistro2(Model model){
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("rol", new Rol());
    return "registro2";   
    }
	
	
	/*editar*/
	
	@GetMapping("/modificarusuario")
	public String modifarusuario(Usuario usuario, Model model) {
		Usuario usu = new Usuario();
		usu=  usuarioImp.buscarBYId(usuario.getIdusuario());
		
		model.addAttribute("usuario", usu);
		
		return "modregistro";
	}
	
	
	@PostMapping("editarusuario")
	public String guardarmod(Usuario usuario, Model model) {	
		usuarioImp.actualizarUsuario(usuario);

		return "redirect:/lstUsuario";
	}
	
	
	@GetMapping("index1")
	public String map() {
		
		return "index1";
	}
	
	
	
	@GetMapping("/pdf")
	public ResponseEntity<byte[]> generarPDf() throws FileNotFoundException, JRException{
		JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(usuarioImp.buscartodos());
		
		JasperReport compileReport =  JasperCompileManager.compileReport(new FileInputStream("src/main/resources/Usuarios.jrxml"));
		
		HashMap<String, Object> map = new HashMap<>();
		JasperPrint report =  JasperFillManager.fillReport(compileReport, null,beanCollectionDataSource);
		/*JasperExportManager.exportReportToPdfFile(report , "Usuarios.pdf");*/
		
		byte [] data = JasperExportManager.exportReportToPdf(report);		
		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=Usuarios.pdf");
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data); 
			
		
	}
	
	@GetMapping("/exel")
	public ResponseEntity<byte[]> generarotro() throws FileNotFoundException, JRException{
		JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(usuarioImp.buscartodos());
		
		JasperReport compileReport =  JasperCompileManager.compileReport(new FileInputStream("src/main/resources/exel.jrxml"));
		
		HashMap<String, Object> map = new HashMap<>();
		JasperPrint report =  JasperFillManager.fillReport(compileReport, null,beanCollectionDataSource);
		
		
		byte [] data = JasperExportManager.exportReportToPdf(report);		
		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=Usuariosexel.xlsx");
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data); 
			
		
	}
	
	/*@GetMapping("/exel")
	public ResponseEntity<byte[]> generarExel() throws FileNotFoundException, JRException{
		JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(usuarioImp.buscartodos());
		
		JasperReport compileReport =  JasperCompileManager.compileReport(new FileInputStream("src/main/resources/exel.jrxml"));
		
		HashMap<String, Object> map = new HashMap<>();
		JasperPrint report =  JasperFillManager.fillReport(compileReport, null,beanCollectionDataSource);
		
		
		String data = JasperExportManager.exportReportToXml(report);		
		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=usuariosexel.xls");
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_XML).body(data); 
			
		
	}*/
	
	
	
	
	
	
	
	
	
	
	
}
