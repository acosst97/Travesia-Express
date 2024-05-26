package com.mycompany.texpress.controlador;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.texpress.daoImp.ReporteVehiculoImp;
import com.mycompany.texpress.daoImp.UsuarioImp;
import com.mycompany.texpress.daoImp.VehiculoImp;
import com.mycompany.texpress.model.ReporteVehiculo;
import com.mycompany.texpress.model.Usuario;
import com.mycompany.texpress.model.Vehiculo;
import com.mycompany.texpress.repositorio.ReporteVehiculoRepositorio;
import com.mycompany.texpress.repositorio.UsuarioRepositorio;
import com.mycompany.texpress.repositorio.VehiculoRepositorio;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
@RequestMapping
public class VehiculoControlador {

	@Autowired
	VehiculoImp vehiculoImp;
	
	@Autowired
	ReporteVehiculoRepositorio reportevehiculoRepositorio;
	
	@Autowired
	ReporteVehiculoImp reportevehiculoImp;
	
	@Autowired
	VehiculoRepositorio vehiculoRepositorio;
	
	@Autowired
	UsuarioImp usuarioImp;
	
	@Autowired
	UsuarioRepositorio usuarioRepositorio;
	
	/*++ lista de los vehiculos  desde el index ++*/
	@GetMapping("/lstvehiculos")
    public String catalogovehiculos(Model model){     
        List<Vehiculo> lstvehiculo;
        lstvehiculo =  this.vehiculoRepositorio.findAll();
        model.addAttribute("lstvehiculo", lstvehiculo);
        return "lstvehiculos";
    }
	
	
	/* +++  control desde  dash adminsitrador  ++++ */
	
	
	@GetMapping("/vehiculos")
	public String reporteadmin(Model model){
        
		
        List<Vehiculo> lstvehiculo;
        List<ReporteVehiculo> lstreportes;
        lstreportes = this.reportevehiculoRepositorio.findAll();
        lstvehiculo =  this.vehiculoRepositorio.findAll();
        model.addAttribute("lstvehiculo", lstvehiculo);  
        model.addAttribute("lstreportes",lstreportes);
        
        return "vehiculos";
    }
	
	@GetMapping("/regvehiculo")
	public String regvehiculo(Model model) {
	model.addAttribute("vehiculo", new Vehiculo());
		return "regvehiculo";
	}
	
	
	@PostMapping("/guardarvehiculo")
	public String guardav(Vehiculo vehiculo ,Model model) {
		vehiculoImp.crearVehiculo(vehiculo);
		return "redirect:/vehiculos";
	}
	
	@GetMapping("/modificarVehiculo")
	public String modificarvehi(Vehiculo vehiculo, Model model) {
		Vehiculo obvehi = new Vehiculo();
		obvehi=vehiculoImp.buscarById(vehiculo.getMatriculavehiculo());
		model.addAttribute("vehiculo", obvehi);
		
		return "modificarvehiculo";
	}
	
	
	@PostMapping("editarvehiculo")
	public String guardarmodificacion(Vehiculo vehiculo, Model model) {	
		vehiculoImp.actualizarVehiculo(vehiculo);
		return "redirect:/vehiculos";
	}
	
	
  /*  @RequestMapping("/eliminarvehiculo")
    public String eliminarservicio(@RequestParam(name = "matriculavehiculo", defaultValue = "0") String matriculavehiculo) {
        vehiculoImp.eliminarVehiculo(matriculavehiculo);
        return "redirect:/vehiculos"; 
    
    } */
	
	@GetMapping("/eliminar/{matriculavehiculo}")
	public String delete(Model model, @PathVariable String matriculavehiculo) {
		vehiculoImp.eliminarVehiculo(matriculavehiculo);
		return "redirect:/vehiculos";
	}
	
    
    /*+++   reporte de vehiculos "dashboard empleado"   +++*/
	
	
	@GetMapping("/tablareportes")
	public String reportes(Usuario usuario ,Vehiculo vehiculo, ReporteVehiculo reportevehiculo,Model model) {
		
		/*  List<Usuario> lstreporte = this.usuarioRepositorio.findreporte();
         model.addAttribute("lstreporte", lstreporte);*/
         
		List<ReporteVehiculo> lstreportev;
		lstreportev = this.reportevehiculoRepositorio.findAll();     
        model.addAttribute("lstreportev", lstreportev);
		return "tablareportes";
	}
	
	
	
   
	/* ++++++++++++++  reportes  en pdf y exel  ++++++++++++++++++ */
	
	
	@GetMapping("/pdfreporte")
	public ResponseEntity<byte[]> generarPDf() throws FileNotFoundException, JRException{
		JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource( reportevehiculoImp.buscartodos());
		
		JasperReport compileReport =  JasperCompileManager.compileReport(new FileInputStream("src/main/resources/reportespdf.jrxml"));
		
		HashMap<String, Object> map = new HashMap<>();
		JasperPrint report =  JasperFillManager.fillReport(compileReport, null,beanCollectionDataSource);
		/*JasperExportManager.exportReportToPdfFile(report , "Usuarios.pdf");*/
		
		byte [] data = JasperExportManager.exportReportToPdf(report);		
		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=listareporte.pdf");
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data); 
			
		
	}
	
	@GetMapping("/exelreporte")
	public ResponseEntity<String> generarExel() throws FileNotFoundException, JRException{
		JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(vehiculoImp.buscartodos());
		
		JasperReport compileReport =  JasperCompileManager.compileReport(new FileInputStream("src/main/resources/Usuarios.jrxml"));
		
		HashMap<String, Object> map = new HashMap<>();
		JasperPrint report =  JasperFillManager.fillReport(compileReport, null,beanCollectionDataSource);
		/*JasperExportManager.exportReportToPdfFile(report , "Usuarios.pdf");*/
		
		String data = JasperExportManager.exportReportToXml(report);		
		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=Reportes.pdf");
		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(data); 
			
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}













