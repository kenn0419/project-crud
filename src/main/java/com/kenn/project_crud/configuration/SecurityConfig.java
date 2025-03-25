//package com.kenn.project_crud.configuration;
//
//import com.kenn.project_crud.repository.UserRepository;
//import jakarta.servlet.DispatcherType;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//
//    @Bean
//    UserDetailsService userDetailsService(UserRepository userRepository) {
//        return new CustomeUserDetailService(userRepository);
//    }
//
//    @Bean
//    PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    DaoAuthenticationProvider daoAuthenticationProvider(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
//        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
//        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
//        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
//        return daoAuthenticationProvider;
//    }
//
//    @Bean
//    public AuthenticationSuccessHandler authenticationSuccessHandler() {
//        return new CustomeSuccessHandler();
//    }
//
//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(request -> request
//                        .dispatcherTypeMatchers(DispatcherType.INCLUDE, DispatcherType.FORWARD).permitAll()
//                        .requestMatchers("/", "/login", "/css/**", "/js/**", "/api/**").permitAll()
//                        .anyRequest().authenticated())
//                .formLogin(form -> form
//                        .loginPage("/login")
//                        .failureUrl("/login?error")
//                        .successHandler(authenticationSuccessHandler())
//                        .permitAll())
//                .logout(logout -> logout.deleteCookies("JSESSIONID").invalidateHttpSession(true))
//                .exceptionHandling(e -> e.accessDeniedPage("/access-deny"));
//
//        return http.build();
//    }
//}
