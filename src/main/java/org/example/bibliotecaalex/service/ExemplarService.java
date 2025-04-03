package org.example.bibliotecaalex.service;

import org.example.bibliotecaalex.models.Exemplar;
import org.example.bibliotecaalex.repository.ExemplarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ExemplarService {

    private final ExemplarRepository exemplarRepository;

    public ExemplarService(ExemplarRepository  exemplarRepository){
        this.exemplarRepository = exemplarRepository;
    }

    public Exemplar salvarExemplar(Exemplar exemplar){
        return exemplarRepository.save(exemplar);
    }

    public List<Exemplar> buscarPorId(String id){
        return exemplarRepository.findAllByIbsn(id);
    }
}
