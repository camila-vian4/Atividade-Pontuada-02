package com.example.atividadepontuada.service;

import com.example.atividadepontuada.dto.funcionario.FuncionarioRequestDTO;
import com.example.atividadepontuada.dto.funcionario.FuncionarioResponseDTO;
import com.example.atividadepontuada.model.FuncionarioModel;
import com.example.atividadepontuada.repository.FuncionarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    // POST (CADASTRAR)
    public FuncionarioModel cadastrar(FuncionarioRequestDTO funcionarioDTO){
        if(repository.findByCpf(funcionarioDTO.getCpf()).isPresent()){
            throw new RuntimeException("Funcionário já cadastrado! ❌");
        }

        FuncionarioModel funcionario = new FuncionarioModel();
        funcionario.setNome(funcionarioDTO.getNome());
        funcionario.setCpf(funcionarioDTO.getCpf());
        funcionario.setEmail(funcionarioDTO.getEmail());
        funcionario.setTelefone(funcionarioDTO.getTelefone());
        funcionario.setSetor(funcionarioDTO.getSetor());
        funcionario.setSalario(funcionarioDTO.getSalario());

        return repository.save(funcionario);
    }

    // GET (LISTAR)
    public List<FuncionarioResponseDTO> listar(){
        return repository
                .findAll()
                .stream()
                .map(f -> new FuncionarioResponseDTO(f.getNome(), f.getEmail(), f.getTelefone(), f.getSetor(), f.getSalario()))
                .toList();
    }

    // PUT (ATUALIZAR)
    public FuncionarioModel atualizar(Long id, @Valid FuncionarioRequestDTO funcionarioDTO){

        FuncionarioModel funcionario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado! 🔍"));

        funcionario.setNome(funcionarioDTO.getNome());
        funcionario.setCpf(funcionarioDTO.getCpf());
        funcionario.setEmail(funcionarioDTO.getEmail());
        funcionario.setTelefone(funcionarioDTO.getTelefone());
        funcionario.setSetor(funcionarioDTO.getSetor());
        funcionario.setSalario(funcionarioDTO.getSalario());

        return repository.save(funcionario);
    }

    // DELETE (DELETAR)
    public void deletar(Long id){
        if(!repository.existsById(id)){
            throw new IllegalArgumentException("Funcionário não encontrado! 🔍");
        }

        repository.deleteById(id);
    }
}
