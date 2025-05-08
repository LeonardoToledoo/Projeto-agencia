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

// import poo2.uniderp.agencia.pojo.Colaborador;
// import poo2.uniderp.agencia.service.ColaboradorService;

// @RestController
// @RequestMapping("/api/agencia/recursoshumanos/colaborador")
// public class ColaboradorController {

//     @Autowired
//     private ColaboradorService servico;

//     public ColaboradorController(ColaboradorService srv){
//         this.servico = srv ;
//     }
//     @GetMapping
//     public List<Colaborador> obterTodos(){
//         return this.servico.browse();
//     }
//      @GetMapping("/{codigo}")
//      public ResponseEntity <Colaborador> obterporidCategoria(@PathVariable Long codigo){
//         Optional<Colaborador> optresposta = this.servico.Read(codigo);
//         if(optresposta.isPresent()==  false){
//             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//         }
//            else{
//                 Colaborador resposta = optresposta.get();
//                 return new ResponseEntity<>(resposta,HttpStatus.NOT_FOUND);
//            }
//     }
    
//      @PostMapping
//       public Colaborador inserir(@RequestBody Colaborador instancia){
//      return this.servico.add(instancia);
//   }
//     @PutMapping
//     public Colaborador Editar(@RequestBody Colaborador instancia){
//          return this.servico.edit(instancia);
//      }
//      @DeleteMapping("/{codigo}")
//      public ResponseEntity<Colaborador> apagar (@PathVariable Long codigo){
//         Optional<Colaborador> optresposta = this.servico.delete(codigo);
//         if(optresposta.isPresent()){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//         }
//         else{
//            Colaborador resposta = optresposta.get();
//            this.servico.delete(codigo);
//            return new ResponseEntity<>(resposta,HttpStatus.OK);
//         }
//    }
// }


