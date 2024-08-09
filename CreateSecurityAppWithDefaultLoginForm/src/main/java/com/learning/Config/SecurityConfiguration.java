package com.learning.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception {
        //Disabling csrf-----
        httpSecurity.csrf(customizer -> customizer.disable());
        //Authorizing every request-----
        httpSecurity.authorizeHttpRequests(request -> request.anyRequest().authenticated());
        //Form Based login-----
        /*
        httpSecurity.formLogin(Customizer.withDefaults());
        httpSecurity.logout(Customizer.withDefaults());
        */
        //Enabling httpBasics authentication(pop up form will be there)
        httpSecurity.httpBasic(Customizer.withDefaults());
        //Making session stateless-----
        httpSecurity.sessionManagement(session ->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return httpSecurity.build();
    }

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
        return provider;
    }
}
