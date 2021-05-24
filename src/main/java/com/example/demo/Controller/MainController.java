package com.example.demo.Controller;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    // default page , root page 를 설정함.
    @RequestMapping("/")
    public String index() {
        return "login";
    }

    @GetMapping("/test/principal")
    public String getUserLoginPage(Model model) {

        // 권한 확인 페이지
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        model.addAttribute("principal", authentication.getPrincipal());
        model.addAttribute("auth", hasAdminRole());

        return "test/principal";
    }

    public static boolean hasAdminRole() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        return authorities
            .stream()
            .filter(o -> o.getAuthority()
            .equals("ROLE_USER"))
            .findAny()
            .isPresent();
    }

}
