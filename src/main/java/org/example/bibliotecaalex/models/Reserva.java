package org.example.bibliotecaalex.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único da reserva", example = "1")
    private Long id;

    @NotNull(message = "O ID do usuário não pode ser nulo")
    @Schema(description = "ID do usuário que fez a reserva", example = "10")
    @Column(name = "userid", nullable = false)
    private Long userId;

    @NotNull(message = "O ID do exemplar não pode ser nulo")
    @Schema(description = "ID do exemplar reservado", example = "25")
    @Column(name = "exemplarid", nullable = false)
    private Long exemplarId;

    @NotNull(message = "A data de início não pode ser nula")
    @Schema(description = "Data de início da reserva", example = "2024-03-01")
    @Column(name = "datainicio", nullable = false)
    private LocalDate dataInicio;

    @NotNull(message = "A data fim prevista não pode ser nula")
    @Schema(description = "Data prevista para devolução", example = "2024-03-15")
    @Column(name = "datafimprevista", nullable = false)
    private LocalDate dataFimPrevista;


}
