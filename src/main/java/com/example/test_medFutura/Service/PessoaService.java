    package com.example.test_medFutura.Service;
    import com.example.test_medFutura.Dto.PessoaDto;
    import com.example.test_medFutura.Model.Pessoa;
    import com.example.test_medFutura.Repository.PessoaRepository;
    import org.springframework.beans.BeanUtils;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    import java.util.List;
    import java.util.Optional;

    @Service
    public class PessoaService {
        @Autowired
        private PessoaRepository pessoaRepository;

        public Pessoa save(PessoaDto pessoaDto) {
            Pessoa pessoa = new Pessoa();
            BeanUtils.copyProperties(pessoaDto, pessoa);
            pessoaRepository.save(pessoa);
            return pessoa;
        }

        public Pessoa getById(Long id) {
            Optional<Pessoa> pessoaOptional =  pessoaRepository.findById(id);
            return pessoaOptional.orElse(null);
        }

        public List<Pessoa> getByTermo(String termo){
            Optional<List<Pessoa>> listOptional =  pessoaRepository.findByTermo(termo);
            return listOptional.orElse(null);
        }

        public Boolean delete(Long id){
            Optional<Pessoa> pessoaOptional =  pessoaRepository.findById(id);
            if(pessoaOptional.isPresent()){
                pessoaRepository.deleteById(id);
                return true;
            }
            return false;
        }

        public Boolean update(Long id, PessoaDto pessoaDto) {
            Optional<Pessoa> pessoaOptional =  pessoaRepository.findById(id);
            if(pessoaOptional.isPresent()){
                Pessoa pessoaEntity = pessoaOptional.get();
                BeanUtils.copyProperties(pessoaDto, pessoaEntity,"id");
                pessoaRepository.save(pessoaEntity);
                return true;
            }
            return false;
        }
    }
