package com.webproject.onlineorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // csrf 攻击网站的一种方法
                .csrf().disable()
                .formLogin()
                .failureForwardUrl("/login?error=true");
        http
                .authorizeRequests()
                .antMatchers("/order/*", "/cart", "/checkout").hasAuthority("ROLE_USER")
                .anyRequest().permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth
                .jdbcAuthentication()
                // 用到applicationConfig中的data source
                .dataSource(dataSource)
                .usersByUsernameQuery("SELECT email, password, enabled FROM customers WHERE email=?")
                .authoritiesByUsernameQuery("SELECT email, authorities FROM authorities WHERE email=?");

    }

    @SuppressWarnings("deprecation")
    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
}
