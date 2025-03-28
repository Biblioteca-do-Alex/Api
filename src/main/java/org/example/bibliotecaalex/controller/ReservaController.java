package org.example.bibliotecaalex.controller;

import org.example.bibliotecaalex.models.Reserva;
import org.example.bibliotecaalex.service.ReservaService;
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

    @GetMapping("/buscar-por-livro-e-id")
    public ResponseEntity<Reserva> buscarPorLivroEId(@RequestParam Long userId, @RequestParam Long exemplarId) {
        Reserva reserva = reservaService.buscarPorLivroEId(userId, exemplarId);
        if (reserva != null) {
            return ResponseEntity.ok(reserva);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscar-por-user/{userId}")
    public ResponseEntity<List<Reserva>> buscarPorUserId(@PathVariable Long userId) {
        List<Reserva> reservas = reservaService.buscarPorUserId(userId);
        if (!reservas.isEmpty()) {
            return ResponseEntity.ok(reservas);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
}