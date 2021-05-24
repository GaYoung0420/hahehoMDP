
package com.example.demo.DTO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;

/**
 * SecurityAdmins
 */

 @Data
 @Entity
public class SecurityAdmins {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private boolean enabled;



    @ManyToMany
    @JoinTable(
        name = "AdminsRole",
        joinColumns = @JoinColumn(name = "admins_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    List<SecurityRole> roles = new ArrayList<>(); //null point error
    
}