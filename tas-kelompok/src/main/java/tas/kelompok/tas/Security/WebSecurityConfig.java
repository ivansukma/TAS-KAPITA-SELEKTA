/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tas.kelompok.tas.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import tas.kelompok.tas.SuccessHandler.CustomLoginSuccessHandler;

/**
 *
 * @author ivanr
 */
@EnableWebSecurity

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public CustomLoginSuccessHandler successHandler() {
        return new CustomLoginSuccessHandler();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        System.out.println("Test");
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withDefaultPasswordEncoder().username("user").password("password").roles("USER").build());
        return manager;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/register/**").permitAll()
                .antMatchers("/address/").hasAuthority("ROLE_LEARNER")
                .antMatchers("/contact/").hasAuthority("ROLE_SUPER_ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .csrf()
                .disable()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login_execute")
                .failureUrl("/login?error=true")
                //handler success url
                .successHandler(successHandler())
                .usernameParameter("email")
                .passwordParameter("password")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login")
                .and()
                .exceptionHandling()
                .accessDeniedPage("/access-denied");

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
    }

}
