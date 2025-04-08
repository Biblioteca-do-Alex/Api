package org.example.bibliotecaalex.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.example.bibliotecaalex.models.Exemplar;
import org.example.bibliotecaalex.service.ExemplarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exemplares")
public class ExemplarController {

    private final ExemplarService exemplarService;

    public ExemplarController(ExemplarService exemplarService) {
        this.exemplarService = exemplarService;
    }

    @Operation(summary = "Salvar um novo exemplar")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Exemplar salvo com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro interno ao salvar o exemplar")
    })
    @PostMapping("/salvar")
    public ResponseEntity<Exemplar> salvarExemplar(@RequestBody Exemplar exemplar) {
        try {
            Exemplar novoExemplar = exemplarService.salvarExemplar(exemplar);
            return ResponseEntity.ok(novoExemplar);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Operation(summary = "Buscar exemplares por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Exemplares encontrados"),
            @ApiResponse(responseCode = "404", description = "Nenhum exemplar encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno ao buscar exemplares")
    })
    @GetMapping("/id/{id}")
    public ResponseEntity<List<Exemplar>> buscarPorIBSN(@PathVariable Long id) {
        try {
            List<Exemplar> exemplares = exemplarService.buscarPorId(id);
            if (exemplares.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            return ResponseEntity.ok(exemplares);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}