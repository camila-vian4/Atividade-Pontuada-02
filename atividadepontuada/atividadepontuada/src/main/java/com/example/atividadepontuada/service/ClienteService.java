package com.example.atividadepontuada.service;

import com.example.atividadepontuada.dto.cliente.ClienteRequestDTO;
import com.example.atividadepontuada.dto.cliente.ClienteResponseDTO;
import com.example.atividadepontuada.dto.fornecedor.FornecedorRequestDTO;
import com.example.atividadepontuada.model.ClienteModel;
import com.example.atividadepontuada.model.FornecedorModel;
import com.example.atividadepontuada.repository.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    // POST (CADASTRAR)
    public ClienteModel cadastrar(ClienteRequestDTO clienteDTO) {
        if (repository.findByCpf(clienteDTO.getCpf()).isPresent()) {
            throw new RuntimeException("Cliente já cadastrado! ❌");
        }

        ClienteModel cliente = new ClienteModel();
        cliente.setNome(clienteDTO.getNome());
        cliente.setCpf(clienteDTO.getCpf());
        cliente.setDataNascimento(clienteDTO.getDataNascimento());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setSenha(passwordEncoder.encode(clienteDTO.getSenha()));

        return repository.save(cliente);
    }

    // GET (LISTAR)
    public List<ClienteResponseDTO> listar() {
        return repository
                .findAll()
                .stream()
                .map(c -> new ClienteResponseDTO(c.getNome(), c.getDataNascimento(), c.getEmail()))
                .toList();
    }

    // PUT (ATUALIZAR)
    public ClienteModel atualizar(Long id, @Valid ClienteRequestDTO clienteDTO) {

        ClienteModel cliente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado! 🔍"));

        cliente.setNome(clienteDTO.getNome());
        cliente.setCpf(clienteDTO.getCpf());
        cliente.setDataNascimento(clienteDTO.getDataNascimento());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setSenha(passwordEncoder.encode(clienteDTO.getSenha()));

        return repository.save(cliente);

    }

    // DELETE (DELETAR)
    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Cliente não encontrado! 🔍");
        }
        repository.deleteById(id);
    }
}
