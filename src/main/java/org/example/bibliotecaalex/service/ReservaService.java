package org.example.bibliotecaalex.service;

import org.example.bibliotecaalex.models.Livro;
import org.example.bibliotecaalex.models.Reserva;
import org.example.bibliotecaalex.repository.ReservaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ReservaService {
    private final ReservaRepository reservaRepository;

    public ReservaService (ReservaRepository reservaRepository){
        this.reservaRepository = reservaRepository;
    }

    public Reserva reservaSalvar(Reserva reserva){
        return reservaRepository.save(reserva);
    }

    public Reserva alterar(Reserva reserva) {
        Optional<Reserva> reservaExistente = reservaRepository.findById(reserva.getId());
        if (reservaExistente.isPresent()) {
            return reservaRepository.save(reserva);
        }
        return null;
    }

    public Reserva buscarPorLivroEId(Long userId,Long exemplarId){
        return reservaRepository.findByUserIdAndExemplarIdAndDataFimRealIsNull(userId,exemplarId);
    }

    public List<Reserva> buscarPorUserId(Long userId){
        return reservaRepository.findByUserId(userId);
    }

    public List<Reserva> BuscarTodosVaziosPorId(Long exemplarId) {
        return reservaRepository.findByExemplarIdAndDataFimRealIsNull(exemplarId);
    }

    public List<Reserva> BuscarTodosVigentes() {
        return reservaRepository.findAll();
    }

    public Reserva deletarPorUserIdEExemplarId(Long userId,Long exemplarId) {
        return reservaRepository.findByUserIdAndExemplarIdAndDataFimRealIsNull(userId, exemplarId);

    }
}
