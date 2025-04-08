package org.example.bibliotecaalex.service;

import org.example.bibliotecaalex.models.Emprestimo;
import org.example.bibliotecaalex.models.Reserva;
import org.example.bibliotecaalex.repository.EmprestimoRepository;
import org.example.bibliotecaalex.repository.ExemplarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EmprestimoService {
    private final EmprestimoRepository emprestimoRepository;

    public EmprestimoService(EmprestimoRepository  emprestimoRepository){
        this.emprestimoRepository = emprestimoRepository;
    }

    public Emprestimo emprestimoSalvar(Emprestimo emprestimo){
        return emprestimoRepository.save(emprestimo);
    }

    public Emprestimo alterar(Emprestimo emprestimo) {
        Optional<Emprestimo> emprestimoExistente = emprestimoRepository.findById(emprestimo.getId());
        if (emprestimoExistente.isPresent()) {
            return emprestimoRepository.save(emprestimo);
        }
        return null;
    }

    public Emprestimo buscarPorLivroEId(Long userId,Long exemplarId){
        return emprestimoRepository.findByUserIdAndExemplarIdAndDataFimRealIsNull(userId,exemplarId);
    }

    public List<Emprestimo> buscarPorUserId(Long userId){
        return emprestimoRepository.findByUserIdAndDataFimRealIsNull(userId);
    }

    public List<Emprestimo> buscarTodosVaziosPorId(Long exemplarId){
        return emprestimoRepository.findByExemplarIdAndDataFimRealIsNull(exemplarId);
    }

    public List<Emprestimo> buscarTodosVigentes(){
        return emprestimoRepository.findAllByDataFimRealIsNull();
    }
}
