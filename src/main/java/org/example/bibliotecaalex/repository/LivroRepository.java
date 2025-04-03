package org.example.bibliotecaalex.repository;

import jakarta.persistence.Id;
import org.example.bibliotecaalex.models.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    public Livro findByIbsn(String ibsn);
}
