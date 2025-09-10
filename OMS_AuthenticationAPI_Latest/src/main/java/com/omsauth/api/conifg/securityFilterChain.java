package com.omsauth.api.conifg;

import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.omsauth.api.service.MyUserDetailsService;

@Configuration
@EnableWebSecurity
public class securityFilterChain {
	@Autowired
	private MyUserDetailsService userDetailsService;
	@Autowired
	public JwtFilter jwtFilter;
	@Bean
	public SecurityFilterChain securitychain(HttpSecurity http) throws Exception
	{
		return 
		http
			.csrf(Customizer->Customizer.disable()) //To Disable CSRF as we are making App as stateless so each session creates a new session ID
			.headers(headers -> headers
	                .frameOptions(frame -> frame.disable()) // Allow H2 to use frames
	            )
			.authorizeHttpRequests(request->request.requestMatchers("/auth/**").permitAll()//To permit login and register without authentication
					.anyRequest().authenticated()) // To authenticate Requests bases on provided credentials
			//http.formLogin(Customizer.withDefaults());
			.httpBasic(Customizer.withDefaults())//For postMan API Basic Auth
			.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
			.build();//Making Session As Stateless
		
	}
	@Bean
	public AuthenticationProvider authenticationProvider()
	{
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
		provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
		provider.setUserDetailsService(userDetailsService);
		return provider;
		
	}
	
	@Bean
	public AuthenticationManager authManager(AuthenticationConfiguration authConfig) throws Exception
	{
		return authConfig.getAuthenticationManager();
	}

}
