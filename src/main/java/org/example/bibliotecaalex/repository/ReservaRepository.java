package org.example.bibliotecaalex.repository;

import org.example.bibliotecaalex.models.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    public Reserva findByUserIdAndExemplarIdAndDataFimRealIsNull(Long userId,Long exemplarId);
    public List<Reserva> findByUserIdAndDataFimRealIsNull(Long userId);
    public  List<Reserva> findByExemplarIdAndDataFimRealIsNull(Long exemplarId);
    public List<Reserva> findAllByDataFimRealIsNull();
}
