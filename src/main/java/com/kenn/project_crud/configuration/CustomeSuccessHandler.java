//package com.kenn.project_crud.configuration;
//
//import com.kenn.project_crud.model.User;
//import com.kenn.project_crud.service.UserService;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.web.DefaultRedirectStrategy;
//import org.springframework.security.web.RedirectStrategy;
//import org.springframework.security.web.WebAttributes;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//import java.util.Collection;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.Map;
//
//@Component
//public class CustomeSuccessHandler implements AuthenticationSuccessHandler {
//    @Autowired
//    private UserService userService;
//
//    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
//
//    private String determinTargetUrl(final Authentication authentication) {
//        Map<String, String> roleTargetUrlMap = new HashMap<>();
//        roleTargetUrlMap.put("ROLE_USER", "/projects");
//
//        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
//
//        for (GrantedAuthority grantedAuthority : authorities) {
//            String authorityName = grantedAuthority.getAuthority();
//            if (roleTargetUrlMap.containsKey(authorityName)) {
//                return roleTargetUrlMap.get(authorityName);
//            }
//        }
//
//        throw new IllegalStateException();
//    }
//
//    private void clearAuthenticationAttributes(HttpServletRequest request, Authentication authentication) {
//        HttpSession session = request.getSession(false);
//        if (session == null) {
//            return;
//        }
//        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
//
//        String username = authentication.getName();
//        User user = this.userService.getByUsername(username);
//
//        if (user != null) {
//            session.setAttribute("username", user.getUsername());
//        }
//    }
//
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
//        String targetUrl = this.determinTargetUrl(authentication);
//
//        if (response.isCommitted()) {
//            return;
//        }
//
//        redirectStrategy.sendRedirect(request, response, targetUrl);
//        clearAuthenticationAttributes(request, authentication);
//    }
//}
