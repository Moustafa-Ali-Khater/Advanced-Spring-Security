package com.spring.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import java.util.Collections;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        /*http.authorizeRequests((requests) -> {
            ((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)requests.anyRequest()).authenticated();
        });
        http.formLogin();
        http.httpBasic();*/

        /*http.authorizeRequests().anyRequest().permitAll()
                .and().formLogin().and().httpBasic();*/

        /*http.authorizeRequests().anyRequest().denyAll()
                .and().formLogin().and().httpBasic();*/

        http.cors().configurationSource(new CorsConfigurationSource() {
            @Override
            public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                CorsConfiguration config = new CorsConfiguration();
                config.setAllowedOrigins(Collections.singletonList("http://localhost:4205"));
                config.setAllowedMethods(Collections.singletonList("*"));
                config.setAllowCredentials(true);
                config.setAllowedHeaders(Collections.singletonList("*"));
                config.setMaxAge(2000L);
                return config;
            }
        }).and()
//                .csrf().disable()
                .csrf().ignoringAntMatchers("/other/start").csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                .and()

            .authorizeRequests()
                .antMatchers("/football/*").authenticated()
                .antMatchers("/basketball/*").authenticated()
                .antMatchers("/swimming/*").authenticated()
                .antMatchers("/subscribers/*").authenticated()
                .antMatchers("/about/*").permitAll()
                .antMatchers("/connrct/*").permitAll()
                .antMatchers("/other/*").permitAll()
                .and().formLogin().and().httpBasic();

    }

    /*@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("mostafa").password("12345").authorities("admin")
                .and().withUser("ali").password("123456").authorities("player")
                .and().passwordEncoder(NoOpPasswordEncoder.getInstance());
    }*/

    /*@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();
        UserDetails userDetails_1 = User.withUsername("mostafa").password("12345").authorities("admin").build();
        UserDetails userDetails_2 = User.withUsername("ali").password("123456").authorities("player").build();
        inMemoryUserDetailsManager.createUser(userDetails_1);
        inMemoryUserDetailsManager.createUser(userDetails_2);
        auth.userDetailsService(inMemoryUserDetailsManager);
    }*/

    @Bean
    public UserDetailsService userDetailsService(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    /*@Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }*/

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
