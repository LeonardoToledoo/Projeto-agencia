package poo2.uniderp.agencia.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poo2.uniderp.agencia.pojo.Item;
import poo2.uniderp.agencia.service.ItemService;

@RestController
@RequestMapping("/api/itens")
public class ItemController {

    @Autowired
    private ItemService servico;

    public ItemController(ItemService srv){
        this.servico = srv;
    }

    @GetMapping
    public ResponseEntity<List<Item>> obterTodos(){
        List<Item> lista = this.servico.browse();
        return new ResponseEntity<List<Item>>(lista, HttpStatus.OK);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Item> obterPorId(@PathVariable Long codigo){
        Optional<Item> optResposta = this.servico.read(codigo);
        if (optResposta.isPresent() == false){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            Item resposta = optResposta.get();
            return new ResponseEntity<Item>(resposta, HttpStatus.OK);
        }
    }

    @GetMapping("/{page}/{size}")
    public Page<Item> listarProdutosPaginados(@PathVariable int page, @PathVariable int size){
        return this.servico.listarProdutosPaginados(page, size);
    }

    @PostMapping
    public ResponseEntity<Item> inserir(@RequestBody Item instancia){
        if (instancia == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        else{
            Item resposta =  this.servico.add(instancia);
            return new ResponseEntity<Item>(resposta, HttpStatus.CREATED);
        }
    }

    @PutMapping
    public ResponseEntity<Item> alterar(@RequestBody Item instancia){
        if (instancia == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        else{
            if (this.servico.read(instancia.getCodigo()) == null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            Item resposta = this.servico.edit(instancia);
            return new ResponseEntity<Item>(resposta, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Item> apagar(@PathVariable Long codigo){
        if (this.servico.read(codigo) == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            Item resposta = this.servico.delete(codigo);
            return new ResponseEntity<Item>(resposta, HttpStatus.OK);
        }
    }
}