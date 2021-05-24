package com.example.demo.Repository;

import java.util.List;

import com.example.demo.DTO.SecurityAdmins;
import com.example.demo.DTO.admins;

import org.springframework.data.jpa.repository.JpaRepository;

public interface saRepository extends JpaRepository<SecurityAdmins, Long>{


    // @Query("select count(*) from admins where cd = :cd and pw = :pw")
    // int findByCdAndPwNative(@Param("cd") String cd, @Param("pw") String pw);
    public List<SecurityAdmins> findByUsername(String username);
    
}
