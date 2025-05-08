package poo2.uniderp.agencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import poo2.uniderp.agencia.pojo.Viagem;

@Repository
public interface IViagemRepoJPA extends JpaRepository<Viagem, Long> {
}
