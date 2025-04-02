package org.example.bibliotecaalex.models;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "livro")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID único do livro", example = "1")
    private Long id;

    @NotNull(message = "O título do livro não pode ser nulo")
    @Size(max = 255, message = "O título do livro deve ter no máximo 255 caracteres")
    @Schema(description = "Título do livro", example = "Dom Casmurro")
    @Column(name = "titulo", length = 255, nullable = false)
    private String titulo;

    @Schema(description = "Descrição do livro", example = "Um romance escrito por Machado de Assis.")
    @Column(name = "descricao", columnDefinition = "TEXT")
    private String descricao;

    @Size(max = 20, message = "O ISBN deve ter no máximo 20 caracteres")
    @Schema(description = "Código ISBN do livro", example = "978-3-16-148410-0")
    @Column(name = "ibsn", length = 20)
    private String ibsn;

    @Schema(description = "Volume do livro", example = "1")
    @Column(name = "volume")
    private Integer volume;

    @Size(max = 255, message = "O nome da coleção deve ter no máximo 255 caracteres")
    @Schema(description = "Coleção a que o livro pertence", example = "Clássicos da Literatura")
    @Column(name = "colecao", length = 255)
    private String colecao;

    @Size(max = 255, message = "O nome do autor deve ter no máximo 255 caracteres")
    @Schema(description = "Nome do autor do livro", example = "Machado de Assis")
    @Column(name = "autor", length = 255)
    private String autor;

    @Size(max = 255, message = "O nome da editora deve ter no máximo 255 caracteres")
    @Schema(description = "Nome da editora do livro", example = "Editora Brasil")
    @Column(name = "editora", length = 255)
    private String editora;

    @Size(max = 100, message = "O gênero deve ter no máximo 100 caracteres")
    @Schema(description = "Gênero do livro", example = "Romance")
    @Column(name = "generoid", length = 100)
    private String genero;

    @Schema(description = "URL da imagem da capa do livro", example = "https://meusite.com/imagens/livro1.jpg")
    @Column(name = "imagem", columnDefinition = "TEXT")
    private String imagem;
}
