package br.com.crudspringmysql.springbootcommysql.controller;

import br.com.crudspringmysql.springbootcommysql.controller.dto.PessoaRs;
import br.com.crudspringmysql.springbootcommysql.controller.dto.Pessoarq;
import br.com.crudspringmysql.springbootcommysql.model.Pessoa;
import br.com.crudspringmysql.springbootcommysql.repository.PessoaRepository;
import br.com.crudspringmysql.springbootcommysql.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private  PessoaService pessoaService;
    @Autowired
    private  PessoaRepository pessoaRepository;
    @GetMapping
    public List<PessoaRs> findAll(){
    var pessoas = pessoaRepository.findAll();
    return pessoas
            .stream()
            .map(PessoaRs::converter)
            .collect(Collectors.toList());
    }
    @GetMapping("/{id}")
    public PessoaRs findById(@PathVariable("id") Long id){
    var pessoa= pessoaRepository.getOne(id);
    return PessoaRs.converter(pessoa);
    }
    @PostMapping
    public void saverPerson(@RequestBody Pessoarq pessoa){
        var p = new Pessoa();
        p.setNome(pessoa.getNome());
        p.setSobrenome(pessoa.getSobrenom());
        this.pessoaRepository.save(p);
    }
        @PutMapping("/{id}")
        public void udpadePerson(@PathVariable("id") Long id, @RequestBody PessoaRs pessoa) throws Exception {
            var p = pessoaRepository.findById(id);

            if (p.isPresent()) {
                var pessoaSave= p.get();
                pessoaSave.setNome(pessoa.getNome());
                pessoaSave.setSobrenome(pessoa.getSobrenome());
                pessoaRepository.save(pessoaSave);
            }else {
                throw  new Exception("Pessoa não encontrada..! ");
            }


        }
}