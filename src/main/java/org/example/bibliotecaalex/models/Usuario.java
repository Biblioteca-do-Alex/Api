package org.example.bibliotecaalex.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único do usuário", example = "1")
    private Long id;

    @NotNull(message = "O nome do usuário não pode ser nulo")
    @Size(max = 255, message = "O nome do usuário deve ter no máximo 255 caracteres")
    @Schema(description = "Nome completo do usuário", example = "João Silva")
    @Column(name = "nome", length = 255, nullable = false)
    private String nome;

    @Schema(description = "Endereço do usuário", example = "Rua das Flores, 123 - São Paulo")
    @Column(name = "endereco", columnDefinition = "TEXT")
    private String endereco;

    @Pattern(regexp = "\\(\\d{2}\\) \\d{4,5}-\\d{4}", message = "O telefone deve estar no formato (XX) XXXXX-XXXX")
    @Schema(description = "Telefone do usuário", example = "(11) 98765-4321")
    @Column(name = "telefone", length = 20)
    private String telefone;

    @NotNull(message = "O e-mail não pode ser nulo")
    @Email(message = "O e-mail deve ser válido")
    @Size(max = 255, message = "O e-mail deve ter no máximo 255 caracteres")
    @Schema(description = "E-mail do usuário", example = "joao.silva@email.com")
    @Column(name = "email", length = 255, nullable = false, unique = true)
    private String email;

    @NotNull(message = "A senha não pode ser nula")
    @Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres")
    @Schema(description = "Senha do usuário", example = "senha123")
    @Column(name = "senha", length = 255, nullable = false)
    private String senha;

    @NotNull(message = "O tipo de usuário não pode ser nulo")
    @Pattern(regexp = "USER|ADMIN", message = "O tipo de usuário deve ser USER ou ADMIN")
    @Schema(description = "Papel do usuário no sistema", example = "USER")
    @Column(name = "role", length = 5, nullable = false)
    private String role = "USER"; // Valor padrão
}
