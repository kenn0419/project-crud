//package com.kenn.project_crud.service.impl;
//
//import com.kenn.project_crud.model.User;
//import com.kenn.project_crud.repository.UserRepository;
//import com.kenn.project_crud.service.UserService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class UserServiceImpl implements UserService {
//    private final UserRepository userRepository;
//
//    @Override
//    public User getByUsername(String username) {
//        return this.userRepository.findByUsername(username)
//                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
//    }
//}
