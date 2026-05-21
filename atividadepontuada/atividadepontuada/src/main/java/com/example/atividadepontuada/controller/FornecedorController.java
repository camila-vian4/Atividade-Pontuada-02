package com.example.atividadepontuada.controller;

import com.example.atividadepontuada.dto.fornecedor.FornecedorRequestDTO;
import com.example.atividadepontuada.dto.fornecedor.FornecedorResponseDTO;
import com.example.atividadepontuada.service.FornecedorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorService service;

    @PostMapping
    public ResponseEntity<Map<String, Object>> cadastrar(@Valid @RequestBody FornecedorRequestDTO fornecedorDTO){
        service.cadastrar(fornecedorDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("mensagem", "Fornecedor cadastrado com sucesso! ✅"));
    }

    @GetMapping
    public ResponseEntity<List<FornecedorResponseDTO>> listar(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.listar());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> atualizar(@PathVariable Long id,
                                                         @RequestBody FornecedorRequestDTO fornecedorDTO){
        service.atualizar(id,fornecedorDTO);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("mensagem", "Fornecedor atualizado com sucesso! ✅"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deletar(@PathVariable Long id){
        service.deletar(id);

        return ResponseEntity.status(HttpStatus.OK).body(Map.of("mensagem", "Fornecedor deletado com sucesso! 🗑️"));
    }
}
