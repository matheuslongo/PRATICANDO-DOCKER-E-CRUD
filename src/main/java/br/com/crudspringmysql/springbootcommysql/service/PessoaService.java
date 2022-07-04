package br.com.crudspringmysql.springbootcommysql.service;

import br.com.crudspringmysql.springbootcommysql.model.Pessoa;
import br.com.crudspringmysql.springbootcommysql.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa> findAll(){
        return pessoaRepository.findAll();
    }

}
