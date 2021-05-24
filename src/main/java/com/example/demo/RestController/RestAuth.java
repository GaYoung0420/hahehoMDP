package com.example.demo.RestController;

import java.util.List;

import com.example.demo.DTO.SecurityAdmins;
import com.example.demo.Repository.saRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class RestAuth {

    @Autowired
    private saRepository saRepo;



    @GetMapping("/list")
    public List<SecurityAdmins> auth(){

        return saRepo.findAll();
        // return saRepo.findByUsername("kschoi");
    }
    
}
