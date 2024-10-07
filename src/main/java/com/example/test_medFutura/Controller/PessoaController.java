package com.example.test_medFutura.Controller;

import com.example.test_medFutura.Dto.PessoaDto;
import com.example.test_medFutura.Model.Pessoa;
import com.example.test_medFutura.Service.PessoaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<Object> createPessoa(@RequestBody @Valid PessoaDto pessoaDto) {
        try {
            Pessoa pessoa = pessoaService.save(pessoaDto);
            return ResponseEntity.status(HttpStatus.OK).body(pessoa);
        }catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getPessoaById(@PathVariable Long id) {
        try {
            Pessoa pessoa = pessoaService.getById(id);
            if (pessoa != null) {
                return ResponseEntity.status(HttpStatus.OK).body(pessoa); // 200 OK
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("");
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
        }
    }

    @GetMapping()
    public ResponseEntity<Object> getPessoaByTermo(@RequestParam String t) {
        try {
            List<Pessoa> pessoa = pessoaService.getByTermo(t);
            if (pessoa != null) {
                return ResponseEntity.status(HttpStatus.OK).body(pessoa); // 200 OK
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("");
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePessoa(@PathVariable Long id, @RequestBody @Valid PessoaDto pessoaDto) {
        try {
            Boolean pessoa = pessoaService.update(id,pessoaDto);
            if (pessoa) {
                return ResponseEntity.status(HttpStatus.OK).body(""); // 200 OK
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("");
            }
        }catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePessoa(@PathVariable Long id) {
        try {
            Boolean pessoa = pessoaService.delete(id);
            if (pessoa) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("");
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("");
        }
    }
}
