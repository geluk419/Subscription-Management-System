package com.example.demo.vo;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.Collections;

@Data
public class UserVO implements UserDetails {
    private int mbrNo;
    private String mbrId;
    private String pswd;
    private String coNm;
    private String telno;
    private String eml;
    private String addr;
    private String authrt;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(this.authrt));
    }

    @Override
    public String getPassword() {
        return this.pswd;
    }

    @Override
    public String getUsername() {
        return this.mbrId;
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