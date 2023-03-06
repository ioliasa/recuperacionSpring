package com.jacaranda.springPrueba.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	// debemos indicar el servicio que se usará para loguearse
	// debe llamarse service
	
	// *****************************************
		// Necesario descomentar
		// *****************************************
	// Indicamos que la configuración se hará a través del servicio.
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(service);
//	}

	// *****************************************
	// Necesario descomentar
	// *****************************************

//	@Bean
//	public UserDetailsService userDetailsService() {
//		return new UserService();
//	}

//	// Método que nos suministrará la codificación
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PlainTextPasswordEncoder.getInstance();

	}

	// Método que autentifica
	// *****************************************
	// Necesario descomentar
	// *****************************************
//	@Bean
//	public DaoAuthenticationProvider authenticationProvider() {
//		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//		authProvider.setUserDetailsService(userDetailsService());
//		authProvider.setPasswordEncoder(passwordEncoder());
//		return authProvider;
//	}

	// Aquí es donde podemos especificar qué es lo que hace y lo que no
	// según el rol del usuario 
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((requests) -> {
				requests
				.anyRequest().permitAll();
			});
			return http.build();
		}

}
