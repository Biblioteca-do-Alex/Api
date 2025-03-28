package org.example.bibliotecaalex.service;


import org.example.bibliotecaalex.models.Usuario;
import org.example.bibliotecaalex.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UsuarioRepository usersRepository;

    public CustomUserDetailsService(UsuarioRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario users = usersRepository.findByEmail(username);

        return new org.springframework.security.core.userdetails.User(

                users.getEmail(),
                users.getSenha(),
                true,
                true,
                true,
                true,
                new ArrayList<>()
        );
    }
}
