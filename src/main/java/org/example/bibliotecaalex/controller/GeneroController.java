package org.example.bibliotecaalex.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.example.bibliotecaalex.models.Genero;
import org.example.bibliotecaalex.service.GeneroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/generos")
@CrossOrigin(origins = {"http://localhost:3000", "https://biblioteca-do-alex.onrender.com"})
public class GeneroController {

    private final GeneroService generoService;

    public GeneroController(GeneroService generoService) {
        this.generoService = generoService;
    }

    @Operation(summary = "Buscar todos os gêneros", description = "Retorna a lista de todos os gêneros cadastrados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de gêneros encontrada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    @GetMapping
    public ResponseEntity<List<Genero>> buscarTodos() {
        try {
            List<Genero> generos = generoService.buscarTodos();
            return ResponseEntity.ok(generos);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
}