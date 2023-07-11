package com.example.ordersystem.model;

//import com.fasterxml.jackson.annotation.JsonFormat;
//import jakarta.persistence.*;
//import lombok.*;
//import java.util.Date;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Getter
@Setter
@Entity
@Table(name = "customer")
public class Customer implements UserDetails {

    @Id
    @GeneratedValue
    private Long customer_id;

    private String first_name;

    private String last_name;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date bornAt;

    @Column(unique = true)
    private String email;

    private String password;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
