package org.example.bibliotecaalex.repository;

import org.example.bibliotecaalex.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

Usuario findByEmail(String email);

}
