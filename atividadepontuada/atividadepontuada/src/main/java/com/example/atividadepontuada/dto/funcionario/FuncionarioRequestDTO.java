package com.example.atividadepontuada.dto.funcionario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class FuncionarioRequestDTO {

    @NotBlank(message = "O nome é obrigatório!")
    @Size(max = 200, message = "O nome deve ter no máximo 200 caracteres.")
    private String nome;

    @NotBlank(message = "O CPF é obrigatório.")
    private String cpf;

    @NotBlank(message = "O e-mail é obrigatório.")
    @Email(message = "Informe um e-mail válido.")
    private String email;

    @NotBlank(message = "O telefone é obrigatório.")
    @Size(min = 10, max = 13, message = "O telefone deve estar entre 10 à 13 dígitos.")
    private String telefone;

    @NotBlank(message = "O setor é obrigatório.")
    private String setor;

    @NotNull(message = "O salário é obrigatório.")
    private double salario;

    public FuncionarioRequestDTO() {
    }

    public FuncionarioRequestDTO(String nome, String cpf, String email, String telefone, String setor, double salario) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.setor = setor;
        this.salario = salario;
    }

    public @NotBlank(message = "O nome é obrigatório!") @Size(max = 200, message = "O nome deve ter no máximo 200 caracteres.") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "O nome é obrigatório!") @Size(max = 200, message = "O nome deve ter no máximo 200 caracteres.") String nome) {
        this.nome = nome;
    }

    public @NotBlank(message = "O CPF é obrigatório.") String getCpf() {
        return cpf;
    }

    public void setCpf(@NotBlank(message = "O CPF é obrigatório.") String cpf) {
        this.cpf = cpf;
    }

    public @NotBlank(message = "O e-mail é obrigatório.") @Email(message = "Informe um e-mail válido.") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "O e-mail é obrigatório.") @Email(message = "Informe um e-mail válido.") String email) {
        this.email = email;
    }

    public @NotBlank(message = "O telefone é obrigatório.") @Size(min = 10, max = 13, message = "O telefone deve estar entre 10 à 13 dígitos.") String getTelefone() {
        return telefone;
    }

    public void setTelefone(@NotBlank(message = "O telefone é obrigatório.") @Size(min = 10, max = 13, message = "O telefone deve estar entre 10 à 13 dígitos.") String telefone) {
        this.telefone = telefone;
    }

    public @NotBlank(message = "O setor é obrigatório.") String getSetor() {
        return setor;
    }

    public void setSetor(@NotBlank(message = "O setor é obrigatório.") String setor) {
        this.setor = setor;
    }

    @NotNull(message = "O salário é obrigatório.")
    public double getSalario() {
        return salario;
    }

    public void setSalario(@NotNull(message = "O salário é obrigatório.") double salario) {
        this.salario = salario;
    }
}
