package com.service.ship.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {

		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

		authProvider.setUserDetailsService(userDetailsService());

		authProvider.setPasswordEncoder(bCryptPasswordEncoder);

		return authProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) {

		auth.authenticationProvider(authenticationProvider());
	}

	// @formatter:off
	@Override
	public void configure(WebSecurity web) throws Exception {

		web.ignoring().antMatchers("/resources/**", "/console/**");
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {

		httpSecurity
			.authorizeRequests()
			.antMatchers("/", "/index")
			.permitAll()
			.antMatchers("/user*").hasAnyRole("ROLEE_USER")
			.antMatchers("/admin*").hasAnyRole("ROLE_ADMIN")
			.anyRequest()
			.authenticated()
			.and().formLogin().loginPage("/login").permitAll()
			.and().logout().permitAll();

		httpSecurity.csrf().disable();

		httpSecurity.headers().frameOptions().disable();
	}
	// @formatter:on
}
