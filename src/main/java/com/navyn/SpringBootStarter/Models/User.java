package com.navyn.SpringBootStarter.Models;

import com.navyn.SpringBootStarter.Enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;

@Entity
@Table(name="users")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

//public class UserData extends User ; when you want to use Spring Security's pre-built methods
//public class implements UserDetails when you want to customize methods
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    private String firstname;
    private String lastname;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return null;
    }

    @Override
    public String getUsername(){
        return email;
    }

    @Override
    public boolean isAccountNonExpired(){
        return true;
    }

    @Override
    public boolean isAccountNonLocked(){
        return true;
    }

    @Override
    public boolean isEnabled(){
        return true;
    }

    @Override
    public String getPassword(){
        return password;
    }

}
