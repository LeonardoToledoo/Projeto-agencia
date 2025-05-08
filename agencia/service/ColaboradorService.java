// package poo2.uniderp.agencia.service;

// import java.util.List;
// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import poo2.uniderp.agencia.pojo.Colaborador;
// import poo2.uniderp.agencia.repository.IColaboradorRepoJPA;

// @Service
// public class ColaboradorService implements  IBaseService<Colaborador>{

//     @Autowired
//     private IColaboradorRepoJPA repositorioDois;

//     public ColaboradorService(IColaboradorRepoJPA repo){
//         this.repositorioDois = repo;
//     }

//     @Override
//     public List<Colaborador> browse() {
//         return this.repositorioDois.findAll(); 
//     }

//     @Override
//     public Optional <Colaborador> Read(Long chave) {
//         return this.repositorioDois.findById(chave);
//     }

//     @Override
//     public Colaborador edit(Colaborador instancia) {
//         return this.repositorioDois.save(instancia);
//     }

//     @Override
//     public Colaborador add(Colaborador instancia) {
//         return this.repositorioDois.save(instancia);
//     }


//     // Temos aqui Coisas diferentes para revisar
//     @Override
//     public   Optional<Colaborador> delete(Long chave) {
//         responseentity Optional  <Colaborador> optdeletado = this.repositorioDois.findById(chave);
//         if(optdeletado.isPresent()== false){
//             return null;
//     }
//         else{
//         Colaborador deletado = optdeletado.get();
//         this.repositorioDois.deleteById(chave);
//         return optdeletado;
//     }
// }

//     @Override
//     public Optional<Colaborador> read(Long chave) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'read'");
//     }

//     @Override
//     public Optional<Colaborador> delete(Colaborador instancia) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'delete'");
//     }
// }
