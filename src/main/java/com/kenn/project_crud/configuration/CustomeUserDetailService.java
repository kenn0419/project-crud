//package com.kenn.project_crud.configuration;
//
//import com.kenn.project_crud.repository.UserRepository;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
//import java.util.Collections;
//
//@Component
//public class CustomeUserDetailService implements UserDetailsService {
//    private final UserRepository userRepository;
//
//    public CustomeUserDetailService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        com.kenn.project_crud.model.User user = this.userRepository.findByUsername(username)
//                .orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
//
//        return new User(
//                user.getUsername(),
//                user.getPassword(),
//                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))
//        );
//    }
//}
