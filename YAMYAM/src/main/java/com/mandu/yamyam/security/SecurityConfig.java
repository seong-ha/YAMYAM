package com.mandu.yamyam.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Autowired
	DataSource dataSource;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public CustomLoginSuccessHandler successHandler() {
		return new CustomLoginSuccessHandler();
	}

	@Bean
	public AccessDeniedHandler accessDeniedHandler() {
		return new WebAccessDenyHandler();
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((requests) -> 
							requests
							.antMatchers("/", "/login").permitAll()
							.antMatchers("/**").hasAnyAuthority("JOB-GRD1", "JOB-GRD2", "JOB-GRD3")
							.anyRequest().authenticated())
				.formLogin().loginPage("/login")
							.usernameParameter("userId")
							.loginProcessingUrl("/login")
							.successHandler(successHandler())
							.and()
				.logout().logoutUrl("/logout")
					     .logoutSuccessUrl("/")
						 .invalidateHttpSession(true)
						 .deleteCookies("JSESSIONID")
						 .and()
				.exceptionHandling()
					     .accessDeniedHandler(accessDeniedHandler())
					     .and();
		
		return http.build();
	}

	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring().antMatchers("/css/**", "/fonts/**", "/images/**", "/js/**");
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		String loginSql = "select EMP_ID, EMP_PW, 1 from C_EMP where EMP_ID = ?";
		String authSql = "select EMP_ID, EMP_ROLE from C_EMP where EMP_ID = ?";
		auth.jdbcAuthentication()
		    .dataSource(dataSource)
		    .usersByUsernameQuery(loginSql)
		    .authoritiesByUsernameQuery(authSql);
	}
}
