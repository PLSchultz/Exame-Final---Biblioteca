package com.example.biblioteca.model;


import com.example.biblioteca.model.dto.Livro.LivroRequestDTO;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "livros")
@Entity(name = "livros")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Livro {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Long ISBN;
    private String descricao;
    private String autor;
    private String disponibilidade;



}
