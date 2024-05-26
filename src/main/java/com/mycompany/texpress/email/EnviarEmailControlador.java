package com.mycompany.texpress.email;

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

import com.mycompany.texpress.daoImp.EnviarEmailImp;
import com.mycompany.texpress.daoImp.EnviarEmailmImp;
import com.mycompany.texpress.daoImp.ExperienciaImp;
import com.mycompany.texpress.daoImp.PqrsImp;
import com.mycompany.texpress.model.Experiencia;
import com.mycompany.texpress.model.Usuario;
import com.mycompany.texpress.repositorio.ExperienciaRepositorio;
import com.mycompany.texpress.repositorio.UsuarioRepositorio;

@Controller
@RequestMapping
public class EnviarEmailControlador {

	@Autowired
	private EnviarEmailmImp enviarEmailmImp;
	
	@Autowired
	private EnviarEmailImp enviarEmailImp;
	
	@Autowired
	ExperienciaRepositorio experienciaRepositorio;
	
	@Autowired
	ExperienciaImp experienciaImp;
	@Autowired	
	private UsuarioRepositorio usuarioRepositorio;
////*ENVIO DE CORREOS  de  forma individual /////// */ 
	
 	@PostMapping("/enviaremail")
	public String enviarcor(@RequestParam("correo") String correo ,
			@RequestParam("subject")String subject,@RequestParam("body") String body) {		
		String mensaje= body + "\n\n  correo de contacto;" +subject+"\n asunto"  + "\n email" + correo;
		
		enviarEmailImp.enviaremail("pepelolaso64@gmail.com", correo, subject, body);
		
		return "respqrs";
	}	
		
	
 	

///////////   ENVIO DE CORREOS  de  forma masiva   /////////////////////////
	
	@GetMapping("/contact")
	public String showContactClientsForm(Model model) {
		List<Experiencia> lstExperiencia = this.experienciaImp.buscartodos();
		model.addAttribute("lstExperiencia",lstExperiencia);	
		return "Recursoshumanosemail";
	}
	
	@PostMapping("/contact")
	public String submitContactC(HttpServletRequest request, RedirectAttributes redirectAttrs,
			@RequestParam("attachment") MultipartFile multipartFile)
			throws MessagingException, UnsupportedEncodingException {

		String fullname = request.getParameter("fullname");
		String email = request.getParameter("email");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");

		List<Experiencia> lstxperiencia = experienciaRepositorio.findAll();

		String mailContent = "<p><b>Nombre del remitente: </b>" + fullname + "</p>";
		mailContent += "<p><b>Correo de contacto: </b>" + email + "</p>";
		mailContent += "<p><b>Asunto: </b>" + subject + "</p>";
		mailContent += "<p><b>Mensaje: </b>" + content + "</p>";


		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());

		try {

			for (Experiencia r : lstxperiencia) {

				try {
					enviarEmailmImp.sendEmail(subject, mailContent, r.getCorreo() , fileName, multipartFile);
					

				} catch (Exception e) {
					redirectAttrs.addFlashAttribute("mensaje", "No se pudo enviar los correos")
							.addFlashAttribute("clase", "danger");
					return "redirect:/contact";
				}

			}

			redirectAttrs.addFlashAttribute("mensaje", "Los correos se enviaron exitosamente")
					.addFlashAttribute("clase", "success");
			return "redirect:/contact";

		} catch (Exception e) {
			redirectAttrs.addFlashAttribute("mensaje", "No se pudo enviar todos los mensajes")
					.addFlashAttribute("clase", "danger");
			return "redirect:/contact";
		}
	}
	
	
	/* cambio contra email*/

	
	
	
	
}
