package com.example.test_medFutura.Dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDto {
    @NotBlank
    @Size(max = 20)
    private String apelido;
    @NotBlank
    @Size(max = 100)
    private String nome;
    @NotBlank
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}")
    private String nascimento;
    @Column(length = 32)
    private List<String> stack = new ArrayList<>();
}
