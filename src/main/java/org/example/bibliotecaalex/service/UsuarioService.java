package org.example.bibliotecaalex.service;

import org.example.bibliotecaalex.models.Usuario;
import org.example.bibliotecaalex.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    public Usuario salvarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario usuarioLogin(String email,String senha){
        Usuario usuario = usuarioRepository.findByEmail(email);
        if (usuario != null && usuario.getSenha().equals(senha)) {
            return usuario;
        }
        return null;
    }

    public Usuario buscarUsuario(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }




}
