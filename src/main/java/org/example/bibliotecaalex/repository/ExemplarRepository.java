package org.example.bibliotecaalex.repository;

import org.example.bibliotecaalex.models.Exemplar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExemplarRepository extends JpaRepository<Exemplar, Long> {

    public List<Exemplar> findAllByIbsn(String ibsn);
}
