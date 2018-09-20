package br.univille.projetoperformance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.univille.projetoperformance.service.MyUserDetailService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailService userDetailsService;
    
    private String[] resources = new String[]{
            "/","/about", "/register/**","/webjars/**","/include/**",
            "/css/**","/icons/**","/image/**","/js/**","/layer/**","/webjars/**"
    };
    
    @Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers(resources);
	}
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /*auth.inMemoryAuthentication()
        .withUser("user").password("user").roles("USER")
        .and()
        .withUser("admin").password("admin").roles("ADMIN");*/
    	auth.authenticationProvider(authenticationProvider());       
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider
          = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
        http
        .authorizeRequests()
            .anyRequest().authenticated()
        .and()
            .formLogin()
            .loginPage("/")
            .successForwardUrl("/user/")
            .permitAll();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}