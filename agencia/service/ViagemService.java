package poo2.uniderp.agencia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import poo2.uniderp.agencia.pojo.Viagem;
import poo2.uniderp.agencia.repository.IViagemRepoJPA;

@Service
public class ViagemService implements IBaseService<Viagem> {

    @Autowired
    private IViagemRepoJPA viagemRepo;

    @Override
    public List<Viagem> browse() {
        return viagemRepo.findAll();
    }

    @Override
    public Optional<Viagem> read(Long id) {
        return viagemRepo.findById(id);
    }

    @Override
    public Viagem edit(Viagem viagem) {
        return viagemRepo.save(viagem);
    }

    @Override
    public Viagem add(Viagem viagem) {
        return viagemRepo.save(viagem);
    }

    @Override
    public Viagem delete(Long id) {
        Optional<Viagem> opt = viagemRepo.findById(id);
        opt.ifPresent(viagemRepo::delete);
        return opt.orElse(null);
    }

    @Override
    public Optional<Viagem> delete(Viagem viagem) {
        Optional<Viagem> opt = viagemRepo.findById(viagem.getId());
        opt.ifPresent(viagemRepo::delete);
        return opt;
    }

    public Page<Viagem> listarViagensPaginados(int page, int size){
        Pageable pg = PageRequest.of(page, size);
        return this.viagemRepo.findAll(pg);
    }

}
