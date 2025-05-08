package poo2.uniderp.agencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import poo2.uniderp.agencia.pojo.Cliente;
public interface IClienteRepoJPA extends JpaRepository<Cliente,Long>{
}
