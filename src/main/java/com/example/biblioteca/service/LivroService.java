package com.example.biblioteca.service;

import com.example.biblioteca.model.Livro;
import com.example.biblioteca.model.dto.Livro.LivroRequestDTO;
import com.example.biblioteca.model.dto.Livro.LivroResponseDTO;
import com.example.biblioteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    private final LivroRepository livroRepository;
    @Autowired
    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public Livro addLivro(LivroRequestDTO data) {
        Livro livro = new Livro();
        livro.setTitle(data.getTitle());
        livro.setAutor(data.getAutor());
        livro.setDescricao(data.getDescricao());
        livro.setISBN(data.getISBN());
        livroRepository.save(livro);
        return livro;
    }

    public void removeLivro(Long livroId) {
        livroRepository.deleteById(livroId);
    }

    public ResponseEntity<Livro> updateLivro(Long livroId, LivroResponseDTO livroResponseDTO) {
        Livro livro = livroRepository.findById(livroId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado com o ID: " + livroId));

        if (livroResponseDTO.getAutor() != null) {
            livro.setAutor(livroResponseDTO.getAutor());
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        if (livroResponseDTO.getDescricao() != null) {
            livro.setDescricao(livroResponseDTO.getDescricao());
        }

        if (livroResponseDTO.getISBN() != null) {
            livro.setISBN(livroResponseDTO.getISBN());
        }

        if (livroResponseDTO.getDisponibilidade() != null) {
            livro.setDisponibilidade(livroResponseDTO.getDisponibilidade());
        }

        if (livroResponseDTO.getTitle() != null) {
            livro.setTitle(livroResponseDTO.getTitle());
        }

        livroRepository.save(livro);
        return ResponseEntity.ok(livro);
    }

    public List<Livro> livroList() {
        return livroRepository.findAll();
    }

    public Livro getLivroById(Long livroId) {
        Optional<Livro> livroOptional = livroRepository.findById(livroId);
        if(livroOptional.isPresent()) {
            Livro livro = livroOptional.get();
            return livro;

        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Livro não encontrado com o id" + livroId);
        }
    }

    public Optional<Livro> getLivroByAutor(String autor) {
        Optional<Livro> livro = livroRepository.findByTitleIgnoreCaseContains(autor);
        return livro;
    }

}
