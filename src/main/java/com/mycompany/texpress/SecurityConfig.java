package com.mycompany.texpress;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.mycompany.texpress.dao.UsuarioService;
import com.mycompany.texpress.model.Usuario;
import com.mycompany.texpress.repositorio.UsuarioRepositorio;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
     
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
    private UsuarioRepositorio userR;
	
	public SecurityConfig(UsuarioService usuarioService) {
		super();
		this.usuarioService = usuarioService;
	}


	@Bean
	public static BCryptPasswordEncoder  passwordEncoder() {		
		/*BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();*/
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(usuarioService);
		auth.setPasswordEncoder(passwordEncoder());
		return auth;
		
	}
	
	@Override
 	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
 		auth.authenticationProvider(authenticationProvider());
 		
 		
 	/*	Usuario usuario =   (Usuario) userR.findAll();
 		
		UserBuilder usuarios = User.withDefaultPasswordEncoder();
 		
 		auth.inMemoryAuthentication().withUser(usuario.getCorreo()).password(usuario.getClave()).roles("administrador");*/
 	
 		
 		
 		
 		
 	}

	 
	@Override
 	protected void configure(HttpSecurity http) throws Exception {
 		
		/*http.authorizeRequests().antMatchers(
 				"/**", "/login", "/reset_password",  "/css/**", "/js/**", "/img/*").permitAll()
 		.anyRequest().authenticated()
 		.and().formLogin()*/
		http.authorizeRequests()
		.antMatchers(
 				"/**", "/login", "/registro", "/reset_password",  "/css/**", "/js/**", "/img/**").permitAll()
		.antMatchers("/inicioDash").hasAnyAuthority("administrador", "empleado", "cliente")
		.antMatchers("/lstUsuario").hasAnyAuthority("administrador")
		.antMatchers("/index1").hasAnyAuthority("administrador")	
		.antMatchers("/lstservicio2").hasAnyAuthority("administrador")		
		.antMatchers("/of1").hasAnyAuthority("administrador")
		.antMatchers("/vehiculos").hasAnyAuthority("administrador")
		.antMatchers("/lstpqrs").hasAnyAuthority("administrador") 
		.antMatchers("/responderpqrs").hasAnyAuthority("administrador")
		.antMatchers("/recursoshumanos").hasAnyAuthority("administrador")
		.antMatchers("/contact").hasAnyAuthority("administrador")
			
		.and().formLogin() 		
 		.loginPage("/login").permitAll()	
 		.defaultSuccessUrl("/inicioDash")
        .failureUrl("/login?error=true")
 		.and().logout()
 		.invalidateHttpSession(true)
 		.clearAuthentication(true)
 		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
 		.logoutSuccessUrl("/login?logout")
 		.permitAll()	
 		.and().sessionManagement()
 		.and().csrf().disable();
		
 	}

 	
 	
 }

	
	
	
	

