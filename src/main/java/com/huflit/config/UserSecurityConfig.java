package com.huflit.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.huflit.filter.AuthFilter;

@Configuration
@EnableWebSecurity
@Order(value = 3)
public class UserSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailsService;


	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder()); // .passwordEncoder(passwordEncoder())
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.antMatcher("/api/**") // link gui len phai bat dau voi /api thi moi duoc chap nhan
		.authorizeRequests()
		.antMatchers("/api/auth/**")
		.permitAll()
		.antMatchers("/api/exams/**")
		.hasRole("USER")
		.antMatchers("/api/users/**")
		.hasRole("USER")
//		.antMatchers("/api/user/profile", "/api/user/password", "/api/user/updateAvatar")
		.anyRequest()
		.authenticated()
		;

		http.addFilter(new AuthFilter(authenticationManager(), userDetailsService));

		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(
				"/v2/api-docs", 
				"/configuration/ui", 
				"/swagger-resources/**",
				"/configuration/security", 
				"/swagger-ui.html", 
				"/webjars/**");
	}
}
