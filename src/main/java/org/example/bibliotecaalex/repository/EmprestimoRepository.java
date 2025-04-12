package org.example.bibliotecaalex.repository;

import org.example.bibliotecaalex.models.Emprestimo;
import org.example.bibliotecaalex.models.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
    public Emprestimo findByUserIdAndExemplarIdAndDataFimRealIsNull(Long userId, Long exemplarId);
    public List<Emprestimo> findByUserIdAndDataFimRealIsNull(Long userId);
    public List<Emprestimo> findByExemplarIdAndDataFimRealIsNull(Long exemplarId);
    public List<Emprestimo> findAllByDataFimRealIsNull();
    public List<Emprestimo> findByExemplarId(Long exemplarId);
}
