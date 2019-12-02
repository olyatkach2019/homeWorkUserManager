package com.example.homeWorkUserManager.congfig;


import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }



    @Override
    protected void configure(AuthenticationManagerBuilder managerBuilder) throws Exception {
        managerBuilder
                .userDetailsService(userDetailsService)
                .passwordEncoder(encoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/","/register","/home", "/redirectPage")
                .permitAll()

                .antMatchers("/userpage")
                .hasRole("USER")
                .antMatchers("/usermanager")
                .hasRole("ADMIN")
                .anyRequest().authenticated()

                .and()
                .formLogin()
                .loginPage("/login")
                .successForwardUrl("/redirectPage")
                .permitAll()

                .and()
                .logout()
                .logoutSuccessUrl("/home");






    }


}
