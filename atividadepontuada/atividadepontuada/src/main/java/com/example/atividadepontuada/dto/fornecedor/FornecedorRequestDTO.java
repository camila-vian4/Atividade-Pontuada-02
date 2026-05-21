package com.example.atividadepontuada.dto.fornecedor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class FornecedorRequestDTO {

    @NotBlank(message = "O nome é obrigatório!")
    @Size(max = 200, message = "O nome deve ter no máximo 200 caracteres.")
    private String nome;

    @NotBlank(message = "O CNPJ é obrigatório!")
    private String cnpj;

    @NotBlank(message = "O e-mail é obrigatório!")
    @Email(message = "Informe um e-mail válido.")
    private String email;

    @NotBlank(message = "O telefone é obrigatório.")
    @Size(min = 10, max = 13, message = "O telefone deve estar entre 10 à 13 dígitos.")
    private String telefone;

    public FornecedorRequestDTO() {
    }

    public FornecedorRequestDTO(String nome, String cnpj, String email, String telefone) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.email = email;
        this.telefone = telefone;
    }

    public @NotBlank(message = "O nome é obrigatório!") @Size(max = 200, message = "O nome deve ter no máximo 200 caracteres.") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "O nome é obrigatório!") @Size(max = 200, message = "O nome deve ter no máximo 200 caracteres.") String nome) {
        this.nome = nome;
    }

    public @NotBlank(message = "O CNPJ é obrigatório!") String getCnpj() {
        return cnpj;
    }

    public void setCnpj(@NotBlank(message = "O CNPJ é obrigatório!") String cnpj) {
        this.cnpj = cnpj;
    }

    public @NotBlank(message = "O e-mail é obrigatório!") @Email(message = "Informe um e-mail válido.") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "O e-mail é obrigatório!") @Email(message = "Informe um e-mail válido.") String email) {
        this.email = email;
    }

    public @NotBlank(message = "O telefone é obrigatório.") @Size(min = 10, max = 13, message = "O telefone deve estar entre 10 à 13 dígitos.") String getTelefone() {
        return telefone;
    }

    public void setTelefone(@NotBlank(message = "O telefone é obrigatório.") @Size(min = 10, max = 13, message = "O telefone deve estar entre 10 à 13 dígitos.") String telefone) {
        this.telefone = telefone;
    }
}
