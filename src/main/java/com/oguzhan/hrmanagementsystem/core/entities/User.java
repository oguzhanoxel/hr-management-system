package com.oguzhan.hrmanagementsystem.core.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="users")
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
	private int id;
    
    @Column(name="email")
    @Email
    @NotBlank
    @NotNull
	private String email;
    
    @Column(name="password")
    @NotBlank
    @NotNull
	private String password;
    
    private String confirmPassword;
    
    @Column(name="is_verified")
    @NotBlank
    @NotNull
	private boolean isVerified = false;
    
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

}
