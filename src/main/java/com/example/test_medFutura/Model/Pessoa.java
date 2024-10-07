package com.example.test_medFutura.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
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
@Entity
@Table(name = "Pessoa")
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false,unique = true,length = 30)
    private String apelido;
    @Column(nullable = false,unique = true,length = 100)
    private String nome;
    @Column(nullable = false)
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}")
    private String nascimento;
    @ElementCollection
    @Column(length = 32)
    @CollectionTable(name = "stack", joinColumns = @JoinColumn(name = "pessoa_id"))
    private List<String> stack = new ArrayList<>();
}
