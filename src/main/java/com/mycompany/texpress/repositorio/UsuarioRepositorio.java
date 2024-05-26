package com.mycompany.texpress.repositorio;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mycompany.texpress.model.Rol;
import com.mycompany.texpress.model.Usuario;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario,Integer> {

   public Usuario findByidusuarioAndClave(Integer idusuario, String clave);

   
   
   public Usuario findByidusuario(Integer idusuario);
   
   @Query(value="SELECT  nombreUsuario,telefono,idusuario, apellidoUsuario,clave,  correo, direccion, edad,  estadoVehiculo  FROM reportevehiculo   INNER JOIN usuario\r\n"
   		+ "   		ON usuario.idusuario  = reportevehiculo.usuario_idusuario;",nativeQuery = true)
   public List<Usuario>findByreporte();
   
   public Usuario findByClave(String clave);
   
   /*recuperacion de contraseña*/
   
  /* @Query(value = "SELECT correo FROM Usuario c WHERE c.correo = 1?" , nativeQuery = true)*/
   public Usuario findByCorreo(String correo); 
    
   public Usuario findByResetPasswordToken(String token);
   //++++++++++++++
   
   
   /*security*/
    Usuario findBynombreusuario(String nombreusuario);
   
   
  
}


  