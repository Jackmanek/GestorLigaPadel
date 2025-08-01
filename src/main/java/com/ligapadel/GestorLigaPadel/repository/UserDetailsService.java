package com.ligapadel.GestorLigaPadel.repository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserDetailsService {
    UserDetails loadUserByUsername(String name) throws UsernameNotFoundException;
}
