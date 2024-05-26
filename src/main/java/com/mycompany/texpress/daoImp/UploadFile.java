package com.mycompany.texpress.daoImp;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

import org.apache.commons.collections4.Get;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mycompany.texpress.model.Vehiculo;
import com.mycompany.texpress.model.Venta;

@Service
public class UploadFile {

	@Autowired
	VehiculoImp vehiculoImp;
	List<Vehiculo> listVehiculo = new ArrayList<>();
	
	
	@Autowired
	VentaImp ventaImp;
    List<Venta> listVenta = new ArrayList<>();

	
	public void guardarFile(MultipartFile file)throws IOException{
		System.out.println("fileC" + file.getOriginalFilename());
		InputStream externalFile = file.getInputStream(); 
		XSSFWorkbook libroVenta = new XSSFWorkbook(externalFile);
		XSSFSheet hojaVenta = libroVenta.getSheetAt(0);
		Iterator<Row> filas = hojaVenta.iterator();
		Iterator<Cell> celdas;
		Row fila;
		Cell celda;
		filas.next();
		while(filas.hasNext()) {
			fila = filas.next();
			celdas = fila.cellIterator();
			Venta venta = new Venta();
			while(celdas.hasNext()){
				celda = celdas.next();
				int index=celda.getColumnIndex();
				
				switch (index) {
				case 0:{
					
				}
			
				case 1:{
					venta.setFechaventa(celda.getDateCellValue());
					
				}
				
				case 2:{
					
					venta.setDetalleventa(celda.toString());
				}
				case 3:{
				
					venta.setTotalpago(celda.toString());
				}
				
				
				default:break;
				}
			}
			
			this.listVenta.add(venta);
		}
		libroVenta.close();
		this.ventaImp.saveAll(listVenta);
	}
	
	public void guardarFileV(MultipartFile file)throws IOException{
		System.out.println("fileC" + file.getOriginalFilename());
		InputStream externalFile = file.getInputStream(); 
		XSSFWorkbook libroVenta = new XSSFWorkbook(externalFile);
		XSSFSheet hojaVenta = libroVenta.getSheetAt(0);
		Iterator<Row> filas = hojaVenta.iterator();
		Iterator<Cell> celdas;
		Row fila;
		Cell celda;
		filas.next();
		while(filas.hasNext()) {
			fila = filas.next();
			celdas = fila.cellIterator();
			Vehiculo vehi  = new Vehiculo();
			while(celdas.hasNext()){
				celda = celdas.next();
				int index=celda.getColumnIndex();
				
				switch (index) {
				case 0:{
			        vehi.setMatriculavehiculo(celda.getStringCellValue());	
				}
			
				case 1:{
					
					vehi.setModelo(celda.toString());
					
					break;
					
				}
				
				case 2:{
					
					vehi.setTipovehiculo(celda.toString());
					break;
				}
				case 3:{
				
					vehi.setTarjetaoperacion(celda.toString());
					break;
				}
				
				
				    default:break;
				   
				}
			}
			
			this.listVehiculo.add(vehi);
			
		}
		libroVenta.close();
		this.vehiculoImp.saveAll(listVehiculo);
		
	}
	
	
	
	
	
}

