package com.example.atividadepontuada.service;

import com.example.atividadepontuada.dto.fornecedor.FornecedorRequestDTO;
import com.example.atividadepontuada.dto.fornecedor.FornecedorResponseDTO;
import com.example.atividadepontuada.model.FornecedorModel;
import com.example.atividadepontuada.repository.FornecedorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository repository;

    // POST (CADASTRAR)
    public FornecedorModel cadastrar(FornecedorRequestDTO fornecedorDTO) {
        if (repository.findByCnpj(fornecedorDTO.getCnpj()).isPresent()) {
            throw new RuntimeException("Fornecedor já cadastrado! ❌");
        }

        FornecedorModel fornecedor = new FornecedorModel();
        fornecedor.setNome(fornecedorDTO.getNome());
        fornecedor.setCnpj(fornecedorDTO.getCnpj());
        fornecedor.setEmail(fornecedorDTO.getEmail());
        fornecedor.setTelefone(fornecedorDTO.getTelefone());

        return repository.save(fornecedor);
    }

    // GET (LISTAR)
    public List<FornecedorResponseDTO> listar() {
        return repository
                .findAll()
                .stream()
                .map(f -> new FornecedorResponseDTO(f.getNome(), f.getEmail(), f.getTelefone()))
                .toList();
    }

    // PUT (ATUALIZAR)
    public FornecedorModel atualizar(Long id, @Valid FornecedorRequestDTO fornecedorDTO) {

        FornecedorModel fornecedor = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fornecedor não encontrado! 🔍"));

        fornecedor.setNome(fornecedorDTO.getNome());
        fornecedor.setCnpj(fornecedorDTO.getCnpj());
        fornecedor.setEmail(fornecedorDTO.getEmail());
        fornecedor.setTelefone(fornecedorDTO.getTelefone());

        return repository.save(fornecedor);
    }

    // DELETE (DELETAR)
    public void deletar(Long id){
        if(!repository.existsById(id)){
            throw new IllegalArgumentException("Fornecedor não encontrado! 🔍");
        }

        repository.deleteById(id);
    }
}
