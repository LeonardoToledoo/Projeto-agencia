package poo2.uniderp.agencia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import poo2.uniderp.agencia.pojo.GuiaTurismo;
import poo2.uniderp.agencia.repository.ITurismoRepoJPA;

@Service
public class TurismoService implements IBaseService<GuiaTurismo>{

    @Autowired
    private ITurismoRepoJPA repoTurismo;

    @Override
    public List<GuiaTurismo> browse() {
        return this.repoTurismo.findAll();
    }

    @Override
    public Optional<GuiaTurismo> read(Long chave) {
        return this.repoTurismo.findById(chave);
    }

    @Override
    public GuiaTurismo edit(GuiaTurismo instancia) {
        return this.repoTurismo.save(instancia);
    }

    @Override
    public GuiaTurismo add(GuiaTurismo instancia) {
        return this.repoTurismo.save(instancia);
    }
    @Override
    public GuiaTurismo delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Optional<GuiaTurismo> delete(GuiaTurismo id) {
        Optional<GuiaTurismo> optDeletado = 
            this.repoTurismo.findById(id.getId());
        if (optDeletado.isPresent() == false){
            return null;
        }
        else{
            return optDeletado;
        }
    }
        
         public Page<GuiaTurismo> listarGuiasPaginados(int page, int size){
        Pageable pg = PageRequest.of(page, size);
        return this.repoTurismo.findAll(pg);
        
        }

    }
    
