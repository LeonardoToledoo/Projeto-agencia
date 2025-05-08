// package poo2.uniderp.agencia.controller;

// import java.util.List;
// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import poo2.uniderp.agencia.pojo.Funcionario;
// import poo2.uniderp.agencia.service.FuncionarioService;

// @RestController
// @RequestMapping("/api/agencia/recursoshumanos/funcionario")
// public class FuncionarioController {
//     @Autowired
//     private FuncionarioService servico;


//     public FuncionarioController(FuncionarioService srv){
//         this.servico = srv;
//     }
//     @GetMapping
//     public List<Funcionario> obterTodos(){
//         return this.servico.browse();
//     }
//      @GetMapping("/{codigo}")
//     public ResponseEntity <Funcionario> obterporidCategoria(@PathVariable Long codigo){
//         Optional<Funcionario> optresposta = this.servico.Read(codigo);
//         if(optresposta.isPresent()==  false){
//             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//         }
//            else{
//                 Funcionario resposta = optresposta.get();
//                 return new ResponseEntity<>(resposta,HttpStatus.NOT_FOUND);
//            }
//     }
    
//      @PostMapping
//       public ResponseEntity <Funcionario> inserir(@RequestBody Funcionario instancia){
//      if(instancia == null){
//             return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//      }
//         else{
//             Funcionario resposta = this.servico.add(instancia);
//             return new ResponseEntity<>(resposta, HttpStatus.CREATED);
//         }
//   }
//     @PutMapping
//     public ResponseEntity <Funcionario> Editar(@RequestBody Funcionario instancia){
//          if(instancia == null){
//             return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//          }
//          else{
//             Funcionario resposta = this.servico.edit(instancia);
//             return new ResponseEntity<>(resposta,HttpStatus.BAD_REQUEST);
//          }
//      }    
//      @DeleteMapping("/{codigo}") 
//     public ResponseEntity<Funcionario> apagar (@PathVariable Long codigo){
//          Optional<Funcionario> optresposta = this.servico.delete(codigo);
//          if(optresposta.isPresent()){
//             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//          }
//          else{
//             Funcionario resposta = optresposta.get();
//             this.servico.delete(codigo);
//             return new ResponseEntity<>(resposta,HttpStatus.OK);
//          }
//     }
// }