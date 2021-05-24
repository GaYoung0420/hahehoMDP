package com.example.demo.Controller;

import java.util.List;

import com.example.demo.DTO.SecurityAdmins;
import com.example.demo.Repository.saRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private saRepository saRepo;

    @GetMapping("list")
    public String list(Model model, Pageable pageable){

        
        
        // Page<SecurityAdmins> list = saRepo.findAll();
        List<SecurityAdmins> list = saRepo.findAll();
        model.addAttribute("list", list);

        return "auth/authList";
    }
}
