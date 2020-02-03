package org.launchcode.dismissal1;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class websecurityconfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                //antMatchers is where you put pages that you want to allow//
                .antMatchers( "/", "/home/login", "/home/newaccount").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/home/login").permitAll()
                .and()
                .logout().invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/home/logout"))
                .logoutSuccessUrl("/logout-successful").permitAll();
   }
}
