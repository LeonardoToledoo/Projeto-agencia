package poo2.uniderp.agencia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poo2.uniderp.agencia.pojo.Funcionario;
import poo2.uniderp.agencia.repository.IFuncionarioRepoJPA;

@Service
public class FuncionarioService implements  IBaseService<Funcionario>{
   
    @Autowired
    private  IFuncionarioRepoJPA repoFuncionario;
    
    public FuncionarioService (IFuncionarioRepoJPA repoFuncionario){
        this.repoFuncionario = repoFuncionario;
    }

    @Override
    public List<Funcionario> browse() {
       return this.repoFuncionario.findAll();
    }

    @Override
    public Optional<Funcionario> read(Long chave) {
       return this.repoFuncionario.findById(chave);
    }

    @Override
    public Funcionario edit(Funcionario instancia) {
       return this.repoFuncionario.save(instancia);
    }

    @Override
    public Funcionario add(Funcionario instancia) {
       return this.repoFuncionario.save(instancia);
    }
    @Override
    public Funcionario delete(Long chave) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    @Override
    public Optional<Funcionario> delete(Funcionario instancia) {
       Optional<Funcionario> optDeletado =
        this.repoFuncionario.findById(instancia.getCodigo());
        if (optDeletado.isPresent()== false) {
            return null;
        }
    else{   
        return optDeletado;
        }
    }
}
