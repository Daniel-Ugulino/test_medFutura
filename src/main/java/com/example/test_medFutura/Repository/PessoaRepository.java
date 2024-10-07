package com.example.test_medFutura.Repository;

import com.example.test_medFutura.Model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    @Query("SELECT p FROM Pessoa p JOIN p.stack st " +
            "WHERE " +
            "p.apelido LIKE %:termo% OR " +
            "p.nome LIKE %:termo% OR " +
            "st LIKE %:termo%")
    Optional<List<Pessoa>> findByTermo(String termo);

}
