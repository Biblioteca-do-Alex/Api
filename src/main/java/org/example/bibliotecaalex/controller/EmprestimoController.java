package org.example.bibliotecaalex.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.example.bibliotecaalex.models.Emprestimo;
import org.example.bibliotecaalex.service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprestimos")

public class EmprestimoController {

    private final EmprestimoService emprestimoService;

    @Autowired
    public EmprestimoController(EmprestimoService emprestimoService) {
        this.emprestimoService = emprestimoService;
    }

    @PostMapping("/salvar")
    @Operation(summary = "Salvar Empréstimo", description = "Salva um novo empréstimo no sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Empréstimo salvo com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao salvar empréstimo")
    })
    public ResponseEntity<Emprestimo> salvarEmprestimo(@RequestBody Emprestimo emprestimo) {
        Emprestimo novoEmprestimo = emprestimoService.emprestimoSalvar(emprestimo);
        if (novoEmprestimo != null) {
            return ResponseEntity.ok(novoEmprestimo);
        } else {
            return ResponseEntity.status(500).build();
        }
    }

    @PutMapping("/alterar")
    @Operation(summary = "Alterar Empréstimo", description = "Altera um empréstimo existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Empréstimo alterado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Empréstimo não encontrado")
    })
    public ResponseEntity<Emprestimo> alterarEmprestimo(@RequestBody Emprestimo emprestimo) {
        Emprestimo emprestimoAlterado = emprestimoService.alterar(emprestimo);
        if (emprestimoAlterado != null) {
            return ResponseEntity.ok(emprestimoAlterado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscar/{userId}/{exemplarId}")
    @Operation(summary = "Buscar Empréstimo por Usuário e Exemplar", description = "Busca um empréstimo pelo ID do usuário e do exemplar")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Empréstimo encontrado"),
            @ApiResponse(responseCode = "404", description = "Empréstimo não encontrado")
    })
    public ResponseEntity<Emprestimo> buscarPorLivroEId(@PathVariable Long userId, @PathVariable Long exemplarId) {
        Emprestimo emprestimo = emprestimoService.buscarPorLivroEId(userId, exemplarId);
        if (emprestimo != null) {
            return ResponseEntity.ok(emprestimo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscarPorUsuario/{userId}")
    @Operation(summary = "Buscar Empréstimos por Usuário", description = "Busca todos os empréstimos de um usuário pelo seu ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Empréstimos encontrados"),
            @ApiResponse(responseCode = "404", description = "Nenhum empréstimo encontrado para este usuário")
    })
    public ResponseEntity<List<Emprestimo>> buscarPorUserId(@PathVariable Long userId) {
        List<Emprestimo> emprestimos = emprestimoService.buscarPorUserId(userId);
        if (!emprestimos.isEmpty()) {
            return ResponseEntity.ok(emprestimos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
