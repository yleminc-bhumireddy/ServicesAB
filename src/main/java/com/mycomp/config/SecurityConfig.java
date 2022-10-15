//package com.mycomp.config;
//
//import com.azure.spring.cloud.autoconfigure.aad.AadWebSecurityConfigurerAdapter;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class SecurityConfig extends AadWebSecurityConfigurerAdapter {
//
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
//        http.authorizeRequests()
//                .antMatchers("/**").authenticated()     // limit these pages to authenticated users (default: /token_details)
//                ;                  // allow all other routes.
//    }
//
//}
