package org.example.bibliotecaalex.service;

import org.example.bibliotecaalex.models.Livro;
import org.example.bibliotecaalex.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {
    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public Livro livroSalvar(Livro livro){
        return livroRepository.save(livro);
    }

    public Livro alterar(Livro livro) {
        Optional<Livro> livroExistente = livroRepository.findById(livro.getId());
        if (livroExistente.isPresent()) {
            return livroRepository.save(livro);
        }
        return null;
    }

    public List<Livro> buscarTudo(){
        return livroRepository.findAll();
    }


}

