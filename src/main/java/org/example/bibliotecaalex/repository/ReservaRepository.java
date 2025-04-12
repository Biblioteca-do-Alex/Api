package org.example.bibliotecaalex.repository;

import org.example.bibliotecaalex.models.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    public Reserva findByUserIdAndExemplarId(Long userId,Long exemplarId);
    public List<Reserva> findByUserId(Long userId);
    public  List<Reserva> findByExemplarId(Long exemplarId);
    public List<Reserva> findAll();
    public Reserva deleteReservaByUserIdAndExemplarId(Long userId,Long exemplarId);
}
