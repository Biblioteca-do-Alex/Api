package org.example.bibliotecaalex.service;

import org.example.bibliotecaalex.models.Genero;
import org.example.bibliotecaalex.repository.GeneroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GeneroService {
    private final GeneroRepository generoRepository;

    public GeneroService(GeneroRepository generoRepository){
        this.generoRepository=generoRepository;
    }

    public List<Genero> buscarTodos(){
        return generoRepository.findAll();
    }
}
