package org.example.bibliotecaalex.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "exemplar")
public class Exemplar {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Schema(description = "ID único do exemplar", example = "1")
        private Long id;

        @NotNull(message = "O IBSN não pode ser nulo")
        @Size(max = 20, message = "O IBSN deve ter no máximo 20 caracteres")
        @Schema(description = "IBSN do exemplar", example = "978-3-16-148410-0")
        @Column(name = "ibsn", length = 20, nullable = false)
        private String ibsn;

        @Size(max = 20, message = "O status deve ter no máximo 20 caracteres")
        @Schema(description = "Status do exemplar", example = "Disponível")
        @Column(name = "status", length = 20)
        private String status;
}
