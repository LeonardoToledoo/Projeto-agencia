// package poo2.uniderp.agencia.service;

// import java.util.List;

// import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import poo2.uniderp.agencia.pojo.Item;
// import poo2.uniderp.agencia.repository.IItemRepoJPA;

// @Service
// public class ItemService  implements IBaseService<Item>{

//     @Autowired
//     private  IItemRepoJPA repositorioUm;
    
//     public ItemService (IItemRepoJPA repoUm){
//         this.repositorioUm = repoUm;
//     }

//     @Override
//     public List<Item> browse() {
//        return this.repositorioUm.findAll();
//     }
// }
