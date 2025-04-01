package org.example.bibliotecaalex.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.example.bibliotecaalex.models.Livro;
import org.example.bibliotecaalex.service.LivroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
@CrossOrigin(origins = {"http://localhost:3000", "https://biblioteca-do-alex.onrender.com"})
public class LivroController {

    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @Operation(summary = "Salvar um novo livro")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Livro salvo com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao salvar o livro")
    })
    @PostMapping("/salvar")
    public ResponseEntity<Livro> salvarLivro(@RequestBody Livro livro) {
        try {
            Livro novoLivro = livroService.livroSalvar(livro);
            return ResponseEntity.ok(novoLivro);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Operation(summary = "Alterar um livro existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Livro alterado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Livro não encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro ao alterar o livro")
    })
    @PutMapping("/alterar")
    public ResponseEntity<Livro> alterarLivro(@RequestBody Livro livro) {
        try {
            Livro livroAlterado = livroService.alterar(livro);
            if (livroAlterado != null) {
                return ResponseEntity.ok(livroAlterado);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Operation(summary = "Buscar todos os livros")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de livros retornada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao buscar livros")
    })
    @GetMapping("/tudo")
    public ResponseEntity<List<Livro>> buscarTudo() {
        try {
            List<Livro> livros = livroService.buscarTudo();
            return ResponseEntity.ok(livros);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
