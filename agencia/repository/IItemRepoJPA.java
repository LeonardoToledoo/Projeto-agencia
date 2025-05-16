package poo2.uniderp.agencia.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import poo2.uniderp.agencia.pojo.Item;

public interface IItemRepoJPA extends JpaRepository<Item, Long> {

}