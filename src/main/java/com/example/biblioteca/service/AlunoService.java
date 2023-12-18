package com.example.biblioteca.service;

import com.example.biblioteca.model.Aluno;
import com.example.biblioteca.model.Bibliotecario;
import com.example.biblioteca.model.dto.Aluno.AlunoRequestDTO;
import com.example.biblioteca.model.dto.Aluno.AlunoResponseDTO;
import com.example.biblioteca.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;
    private final Logger logger = Logger.getLogger(AlunoService.class.getName());
    @Autowired
    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public Aluno addAluno(AlunoRequestDTO data) {
        Aluno aluno = new Aluno();
        aluno.setNome(data.getNome());
        aluno.setMatricula(data.getMatricula());
        aluno.setContato(data.getContato());
        alunoRepository.save(aluno);
        return aluno;
    }

    public void removeAluno(Long alunoID) {
        alunoRepository.deleteById(alunoID);
    }

    public ResponseEntity<Aluno> updateAluno(Long alunoId, AlunoResponseDTO alunoResponseDTO) {
        Aluno aluno = alunoRepository.findById(alunoId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado com o ID: " + alunoId));

        if (alunoResponseDTO.getNome() != null) {
            alunoResponseDTO.setNome(alunoResponseDTO.getNome());
        }

        if (alunoResponseDTO.getMatricula() != null) {
            aluno.setMatricula(alunoResponseDTO.getMatricula());
        }
        if (alunoResponseDTO.getContato() != null) {
            aluno.setContato(alunoResponseDTO.getContato());
        }


        alunoRepository.save(aluno);
        return ResponseEntity.ok(aluno);
    }
}
