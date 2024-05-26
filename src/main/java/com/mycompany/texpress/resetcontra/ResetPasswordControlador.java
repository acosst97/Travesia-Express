package com.mycompany.texpress.resetcontra;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycompany.texpress.daoImp.UsuarioImp;
import com.mycompany.texpress.model.Usuario;
import com.mycompany.texpress.repositorio.UsuarioRepositorio;

import net.bytebuddy.utility.RandomString;

@Controller
@Transactional
public class ResetPasswordControlador {
  
	@Autowired
	UsuarioImp usuarioImp;
	
	@Autowired
	UsuarioRepositorio usuarioRepositorio;
	
	@Autowired
	private JavaMailSender mailsender;

	private String idusuario;
	private Usuario usuario;
	
	
	
	/*+++ recuperar contraseña +++*/
	  
	 @GetMapping("/recontrasenia")
	 public String cambiarcontraseña(Model model) {
		  
		 model.addAttribute("titulo","olvido contraseña ");		 
		 return "correocontrase";
		 
	 }
	 
	  @PostMapping("/forgot_password")
		public String procesorecuperarcontra(HttpServletRequest request, Model model) {
		  String correo = request.getParameter("email");
		 String token = RandomString.make(45);
		 
		 System.out.println("email:" + correo);
		 System.out.println("token:" + token);
		 
		 
		 try {
			usuarioImp.updateResetPassword(token, correo);
			String resetPasswordLink = Utility.getSiteUrl(request)+  "/reset_password?token=" + token ;
			sendEmail(correo, resetPasswordLink);
			System.out.println(resetPasswordLink);
			
			model.addAttribute("mensaje" , "Hemos enviado un link de recuperacion de contraseña");
			
			
			
		} catch (UsuarioNotFoundException ex) {
			model.addAttribute("error" , ex.getMessage());
		} catch (UnsupportedEncodingException  | MessagingException  e) {
			model.addAttribute("error", "error cuando se envio el correo ");
			e.printStackTrace();
		} 
		 
		 model.addAttribute("titulo","olvido contraseña ");	
			return "correocontrase";
		}
	  

	private void sendEmail(String correo, String resetPasswordLink) throws UnsupportedEncodingException, MessagingException {
		MimeMessage mensaje = mailsender.createMimeMessage();
		MimeMessageHelper helper =  new MimeMessageHelper(mensaje);
		
		
	  helper.setFrom("pepelolaso64@gmail.com" , "soporte");
	  helper.setTo(correo);
	  
	  String Subject = "Aqui esta el link para restablecer tu contraseña";
	  String content  = " <p> Hola, </p> "
	  		+ "<p>    Encuentra aqui  abajo tu link. </p>"
	  		+ "<p> mensaje de contenido de prueba </p>"		  
	  		+ "<p> <b>  <a href=\"" + resetPasswordLink + "\"> Clik Aqui </a> <b> </p>"
	  		+ "<p> ignora este email si no quieres restablecer tu contraseña </p>";
	  
	  helper.setSubject(Subject);
	  helper.setText(content, true);	  
	  mailsender.send(mensaje);
	  
	}
	
	@GetMapping("/reset_password")
	public String showresetpasswordform(@Param(value="token") String token, Model model) {
		
		Usuario usuario = usuarioImp.getByResetPasswordToken(token);
		if (usuario == null) {			
			model.addAttribute("titulo", "resetea tu contraseña");
			model.addAttribute("mensaje", "token invalido");
			return "mensaje";
		}
		
		model.addAttribute("token", token);
		model.addAttribute("titulo","resetea tu  contraseña");	
		return "formrecuperarcontra";
		
	}
		
	@PostMapping("/reset_password")
	public String Resetpassword(HttpServletRequest request, Model model) {
		String token = request.getParameter("token");
		String clave = request.getParameter("clave");
		
		Usuario usuario = usuarioImp.getByResetPasswordToken(token);
		if(usuario == null) {
			model.addAttribute("titulo", "cambia tu contraseña");
			model.addAttribute("mensaje", "invalido");
			return "mensaje";
		}else {
			usuarioImp.updatePassword(usuario, clave);
		} 
		return "index";
	}
		
		
	/**  recuperar 2+++++ */
	
/*	@GetMapping("/formularioCambioContraseña")
    public String PaginarecuperarContraseña(Model model, @RequestParam(name = "idUsuario") String idusuario) {
        model.addAttribute("idusuario", idusuario);
        this.idusuario = idusuario;
        return "formularioCambioContraseña";
    }
	
	
	
	
	@PostMapping("/ModificarContraseña")
    public String ModificarContra(Model model, @RequestBody MultiValueMap<String, String> formData) {
        String clave = formData.get("clave").get(0);
        String idUsuarioA = this.idusuario;
        Usuario usuario = usuarioRepositorio.findByidusuario(Integer.parseInt(idUsuarioA)).orElse(null);   
        usuario.setClave(clave);        
        usuarioRepositorio.save(usuario);
        model.addAttribute("usuario", usuario);
        return "redirect:index";
    }*/
	
	
	
	
	
	
 }
	
	
	

