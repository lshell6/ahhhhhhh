package com.rewards.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.rewards.backend.service.MyUserDetailsService;

@Configuration
public class ApiSecurityConfig extends WebSecurityConfigurerAdapter{

@Autowired
private MyUserDetailsService myUserDetailsService;

@Override
protected void configure(HttpSecurity http) throws Exception {
http.authorizeRequests()

// .antMatchers(HttpMethod.POST, "/customer").authenticated()

// .antMatchers(HttpMethod.GET, "/login").authenticated()

// .antMatchers(HttpMethod.GET, "/user/username").authenticated()

// .antMatchers(HttpMethod.GET, "/user/profile").authenticated()

.anyRequest().permitAll()

//.antMatchers(HttpMethod.GET, "/customers").hasAnyAuthority("EXEC")

//.antMatchers("/products").authenticated()

// .antMatchers("/products/category/{cid}").hasAnyAuthority("ADMIN","USER")

.and().httpBasic()

.and().csrf().disable();

}

 

@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
auth.authenticationProvider(getCustomProvider());
}


@Bean
public PasswordEncoder getPasswordEncoder(){
PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
return passwordEncoder;
}


private DaoAuthenticationProvider getCustomProvider(){
DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
dao.setPasswordEncoder(getPasswordEncoder());
dao.setUserDetailsService(myUserDetailsService);
return dao;

}

}

