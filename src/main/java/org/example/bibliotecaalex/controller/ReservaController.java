package org.example.bibliotecaalex.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.example.bibliotecaalex.models.Emprestimo;
import org.example.bibliotecaalex.models.Exemplar;
import org.example.bibliotecaalex.models.Reserva;
import org.example.bibliotecaalex.service.ReservaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }
    @PostMapping("/salvar")
    public ResponseEntity<Reserva> salvarReserva(@RequestBody Reserva reserva) {
        Reserva novaReserva = reservaService.reservaSalvar(reserva);
        return ResponseEntity.ok(novaReserva);
    }

    @PutMapping("/alterar")
    public ResponseEntity<Reserva> alterarReserva(@RequestBody Reserva reserva) {
        Reserva reservaAtualizada = reservaService.alterar(reserva);
        if (reservaAtualizada != null) {
            return ResponseEntity.ok(reservaAtualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscarPorLivroEId")
    public ResponseEntity<Reserva> buscarPorLivroEId(@RequestParam Long userId, @RequestParam Long exemplarId) {
        Reserva reserva = reservaService.buscarPorLivroEId(userId, exemplarId);
        if (reserva != null) {
            return ResponseEntity.ok(reserva);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscarPorUser/{userId}")
    public ResponseEntity<List<Reserva>> buscarPorUserId(@PathVariable Long userId) {
        List<Reserva> reservas = reservaService.buscarPorUserId(userId);
        if (!reservas.isEmpty()) {
            return ResponseEntity.ok(reservas);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @Operation(summary = "Buscar reservas por ID do exemplar onde data fim está vazio")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reservas encontrados"),
            @ApiResponse(responseCode = "404", description = "Nenhuma reserva encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno ao buscar exemplares")
    })
    @GetMapping("/id/{id}")
    public ResponseEntity<List<Reserva>> buscarPorIBSN(@PathVariable Long id) {
        try {
            List<Reserva> reservas = reservaService.BuscarTodosVaziosPorId(id);
            if (reservas.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            return ResponseEntity.ok(reservas);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @Operation(summary = "Buscar reservas vigentes")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reservas encontradas"),
            @ApiResponse(responseCode = "404", description = "Nenhuma reserva encontrado"),
            @ApiResponse(responseCode = "500", description = "Erro interno ao buscar exemplares")
    })
    @GetMapping("/vigentes")
    public ResponseEntity<List<Reserva>> buscarVigentes() {
        try {
            List<Reserva> reservas = reservaService.BuscarTodosVigentes();
            if (reservas.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
            return ResponseEntity.ok(reservas);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}