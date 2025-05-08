// package poo2.uniderp.agencia.service;

// import java.util.List;
// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import poo2.uniderp.agencia.pojo.Funcionario;
// import poo2.uniderp.agencia.repository.IFuncionarioRepoJPA;

// @Service
// public class FuncionarioService implements  IBaseService<Funcionario>{
   
//     @Autowired
//     private  IFuncionarioRepoJPA repositorioUm;
    
//     public FuncionarioService (IFuncionarioRepoJPA repoUm){
//         this.repositorioUm = repoUm;
//     }

//     @Override
//     public List<Funcionario> browse() {
//        return this.repositorioUm.findAll();
//     }

//     @Override
//     public Optional<Funcionario> Read(Long chave) {
//        return this.repositorioUm.findById(chave);
//     }

//     @Override
//     public Funcionario edit(Funcionario instancia) {
//        return this.repositorioUm.save(instancia);
//     }

//     @Override
//     public Funcionario add(Funcionario instancia) {
//        return this.repositorioUm.save(instancia);
//     }

//     @Override
//     public Optional<Funcionario> delete(Long chave) {
//        Optional<Funcionario> deletado = this.Read(chave);
//        this.repositorioUm.deleteById(chave);
//         return deletado;
//     }
// }
