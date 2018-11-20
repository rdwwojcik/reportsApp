package reposts;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;

    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {

        System.out.println("Configure Security HttpSecurity");

        http.authorizeRequests()
                .antMatchers("/css/**", "/img/**", "/js/**", "/fonts/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
//                .loginPage("/login").permitAll()
                .and()
                .logout().logoutSuccessUrl("/login")
                .and()
                .headers().frameOptions().disable()
                .and()
                .csrf().disable()
                .headers().cacheControl();
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        System.out.println("Configure Security AuthenticationManagerBuilder");
        auth.authenticationProvider(authenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        System.out.println("Configure Security DaoAuthenticationProvider");
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(encoder());
        return authProvider;
    }

    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

}
