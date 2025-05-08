package poo2.uniderp.agencia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poo2.uniderp.agencia.pojo.Cliente;
import poo2.uniderp.agencia.repository.IClienteRepoJPA;

@Service
public class ClienteService implements IBaseService<Cliente> {

    @Autowired
    private IClienteRepoJPA clienteRepo;

    @Override
    public List<Cliente> browse() {
        return clienteRepo.findAll();
    }

    @Override
    public Optional<Cliente> read(Long id) {
        return clienteRepo.findById(id);
    }

    @Override
    public Cliente edit(Cliente cliente) {
        return clienteRepo.save(cliente);
    }

    @Override
    public Cliente add(Cliente cliente) {
        return clienteRepo.save(cliente);
    }

    @Override
    public Cliente delete(Long id) {
        Optional<Cliente> opt = clienteRepo.findById(id);
        opt.ifPresent(clienteRepo::delete);
        return opt.orElse(null);
    }

    @Override
    public Optional<Cliente> delete(Cliente cliente) {
        Optional<Cliente> opt = clienteRepo.findById(cliente.getId());
        opt.ifPresent(clienteRepo::delete);
        return opt;
    }
}
