//package com.mycomp.config;
//
//import com.azure.spring.aad.webapp.AADWebSecurityConfigurerAdapter;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class SecurityConfig extends AADWebSecurityConfigurerAdapter {
//
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
//        http.authorizeRequests((authorize) -> authorize.antMatchers("/**").authenticated())
//                     // limit these pages to authenticated users (default: /token_details)
//                .oauth2Client(Customizer.withDefaults());                  // allow all other routes.
//    }
//
//}
