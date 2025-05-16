package poo2.uniderp.agencia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import poo2.uniderp.agencia.pojo.Item;
import poo2.uniderp.agencia.repository.IItemRepoJPA;

@Service
public class ItemService implements IBaseService<Item> {

    @Autowired
    private IItemRepoJPA Itemrepositorio;

    public ItemService(IItemRepoJPA repo){
        this.Itemrepositorio = repo;
    }

    @Override
    public List<Item> browse() {
        return this.Itemrepositorio.findAll();
    }

    @Override
    public Optional<Item> read(Long chave) {
        return this.Itemrepositorio.findById(chave);
    }

    @Override
    public Item edit(Item instancia) {
        return this.Itemrepositorio.save(instancia);
    }

    @Override
    public Item add(Item instancia) {
        return this.Itemrepositorio.save(instancia);
    }

    @Override
    public Item delete(Long chave) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Optional<Item> delete(Item instancia) {
        Optional<Item> optDeletado = 
            this.Itemrepositorio.findById(instancia.getCodigo());
        if (optDeletado.isPresent() == false){
            return null;
        }
        else{
            return optDeletado;
        }
    }

    public Page<Item> listarProdutosPaginados(int page, int size){
        Pageable pg = PageRequest.of(page, size);
        return this.Itemrepositorio.findAll(pg);
    }
    
}