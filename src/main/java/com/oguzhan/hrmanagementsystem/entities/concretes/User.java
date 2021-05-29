package com.oguzhan.hrmanagementsystem.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

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
    @Column(name="user_id")
	private int user_id;
    
    @Column(name="email")
	private String email;
    
    @Column(name="password")
	private String password;
    
    private String confirmPassword;
    
    @Column(name="is_verified", columnDefinition = "boolean default false")
	private boolean isVerified = false;
    
    @Column(name="is_superuser", columnDefinition = "boolean default false")
    private boolean isSuperuser = false;
    
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

}
