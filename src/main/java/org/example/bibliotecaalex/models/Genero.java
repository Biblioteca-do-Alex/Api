package org.example.bibliotecaalex.models;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "genero", uniqueConstraints = @UniqueConstraint(columnNames = "nome"))
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único do gênero", example = "1")
    private Long id;

    @NotNull(message = "O nome do gênero não pode ser nulo")
    @Size(max = 100, message = "O nome do gênero deve ter no máximo 100 caracteres")
    @Schema(description = "Nome do gênero", example = "Ficção Científica")
    @Column(name = "nome", length = 100, nullable = false, unique = true)
    private String nome;
}
