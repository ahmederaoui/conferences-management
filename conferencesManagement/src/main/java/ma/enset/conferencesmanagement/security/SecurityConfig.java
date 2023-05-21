package ma.enset.conferencesmanagement.security;


import ma.enset.conferencesmanagement.entities.Participant;
import ma.enset.conferencesmanagement.security.filters.JwtAuthenticationFilter;
import ma.enset.conferencesmanagement.security.filters.JwtAuthorizationFilter;
import ma.enset.conferencesmanagement.security.services.IAppService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.stream.Collectors;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private IAppService appService;


    public SecurityConfig( IAppService appService) {
        this.appService = appService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable();
        httpSecurity.headers().frameOptions().disable();
        httpSecurity.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        httpSecurity.authorizeHttpRequests().requestMatchers("/h2-console/**","/refreshToken/**").permitAll();
        httpSecurity.authorizeHttpRequests().requestMatchers(HttpMethod.POST,"/users/**").hasAuthority("ADMIN");
        httpSecurity.authorizeHttpRequests().requestMatchers(HttpMethod.GET,"/users/**").hasAuthority("USER");
//        //httpSecurity.formLogin();
        httpSecurity.authorizeHttpRequests().anyRequest().authenticated();
        httpSecurity.addFilter(new JwtAuthenticationFilter(authenticationManager(authenticationConfiguration()) ));
        httpSecurity.addFilterBefore(new JwtAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
        return httpSecurity.build();
    }
    @Bean
    public UserDetailsService userDetailsService(){
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                Participant participant = appService.getUser(username);
                return new User(
                        participant.getUserName(),
                        participant.getPassword(),
                        participant.getUserRoles()
                                .stream()
                                .map(gr -> new SimpleGrantedAuthority(gr.getRoleName()))
                                .collect(Collectors.toList())
                );
            }
        };
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception
    { return authenticationConfiguration.getAuthenticationManager();}
    @Bean
    AuthenticationConfiguration authenticationConfiguration(){
        return new AuthenticationConfiguration();
    }


}
