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

import poo2.uniderp.agencia.pojo.GuiaTurismo;
import poo2.uniderp.agencia.service.TurismoService;

@RestController
@RequestMapping("/api/Guia/Turismo")
public class TurismoController {

    @Autowired
    private TurismoService servico;

    public TurismoController(TurismoService srv) {
        this.servico = srv;
    }

    @GetMapping
    public ResponseEntity<List<GuiaTurismo>> obterTodos() {
        List<GuiaTurismo> lista = this.servico.browse();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<GuiaTurismo> obterPorId(@PathVariable Long codigo) {
        Optional<GuiaTurismo> optresposta = this.servico.read(codigo);
        if (optresposta.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            GuiaTurismo resposta = optresposta.get();
            return new ResponseEntity<>(resposta, HttpStatus.OK); 
        }
    }

    @GetMapping("/{page}/{size}")
    public Page<GuiaTurismo> listarGuia(@PathVariable int page, @PathVariable int size){
            return this.servico.listarGuiasPaginados(page, size);
     }


    @PostMapping
    public ResponseEntity<GuiaTurismo> inserir(@RequestBody GuiaTurismo instancia) {
        if (instancia == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            GuiaTurismo resposta = this.servico.add(instancia);
            return new ResponseEntity<>(resposta, HttpStatus.CREATED);
        }
    }

    @PutMapping
    public ResponseEntity<GuiaTurismo> alterar(@RequestBody GuiaTurismo instancia) {
        if (instancia == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            GuiaTurismo resposta = this.servico.edit(instancia);
            return new ResponseEntity<>(resposta, HttpStatus.OK); 
        }
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<GuiaTurismo> apagar(@PathVariable Long codigo) {
        if (this.servico.read(codigo).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            GuiaTurismo resposta = this.servico.delete(codigo);
            return new ResponseEntity<>(resposta, HttpStatus.OK);
        }
    }
}
