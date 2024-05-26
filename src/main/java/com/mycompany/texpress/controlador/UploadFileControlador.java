package com.mycompany.texpress.controlador;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.mycompany.texpress.daoImp.UploadFile;
import com.mycompany.texpress.daoImp.VehiculoImp;
import com.mycompany.texpress.daoImp.VentaImp;
import com.mycompany.texpress.model.Vehiculo;
import com.mycompany.texpress.model.Venta;

@Controller
public class UploadFileControlador {

	@Autowired
	UploadFile uploadFile;
	
	@Autowired
	VehiculoImp vehiculoImp;
	
	@Autowired
	VentaImp ventaImp;
	
	
	@RequestMapping("/uploadFile")
	public String SaveFileExcel(MultipartFile file, Model model)throws
	IOException{
	   this.uploadFile.guardarFile(file);
	   List<Venta> lstVentas = this.ventaImp.buscartodos();
	   model.addAttribute("lstVentas", lstVentas);
		return "redirect:listarventas";
	}
	
	@RequestMapping("/uploadFile1")
	public String SaveFileExcelVehiculo(MultipartFile file, Model model)throws
	IOException{
	   this.uploadFile.guardarFileV(file);
	   List<Vehiculo> lstvehiculo = this.vehiculoImp.buscartodos();
	   model.addAttribute("lstvehiculo", lstvehiculo);
		return "redirect:vehiculos";
	}
	
	
}
