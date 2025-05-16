package poo2.uniderp.agencia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poo2.uniderp.agencia.pojo.Colaborador;
import poo2.uniderp.agencia.repository.IColaboradorRepoJPA;

@Service
public class ColaboradorService implements  IBaseService<Colaborador>{

    @Autowired
    private IColaboradorRepoJPA repoColaborador;

    public ColaboradorService(IColaboradorRepoJPA repo){
        this.repoColaborador = repo;
    }

    @Override
    public List<Colaborador> browse() {
        return this.repoColaborador.findAll(); 
    }

    @Override
    public Optional <Colaborador> read(Long chave){
        return this.repoColaborador.findById(chave);
    }

    @Override
    public Colaborador edit(Colaborador instancia) {
        return this.repoColaborador.save(instancia);
    }

    @Override
    public Colaborador add(Colaborador instancia) {
        return this.repoColaborador.save(instancia);
    }
    @Override
    public Colaborador delete(Long chave) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    @Override
    public Optional<Colaborador> delete(Colaborador instancia){
        Optional <Colaborador> optDeletado = 
        this.repoColaborador.findById(instancia.getCodigo());
        if(optDeletado.isPresent() == false){
            return null;
    }
        else{
            return optDeletado;
        
    }
}

}