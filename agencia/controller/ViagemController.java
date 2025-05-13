package poo2.uniderp.agencia.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poo2.uniderp.agencia.pojo.Viagem;
import poo2.uniderp.agencia.service.ViagemService;

@RestController
@RequestMapping("/api/viagens")
public class ViagemController {

    private final ViagemService viagemService;

    @Autowired
    public ViagemController(ViagemService viagemService) {
        this.viagemService = viagemService;
    }

    @GetMapping
    public ResponseEntity<List<Viagem>> listarTodas() {
        return ResponseEntity.ok(viagemService.browse());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Viagem> buscarPorId(@PathVariable Long id) {
        Optional<Viagem> viagem = viagemService.read(id);
        return viagem.map(ResponseEntity::ok)
                     .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{page}/{size}")
    public Page<Viagem> listarviagens(@PathVariable int page, @PathVariable int size){
        return this.viagemService.listarViagensPaginados(page, size);
    }
    @PostMapping
    public ResponseEntity<Viagem> criar(@RequestBody Viagem viagem) {
        Viagem nova = viagemService.add(viagem);
        return ResponseEntity.status(201).body(nova);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Viagem> atualizar(@PathVariable Long id, @RequestBody Viagem viagem) {
        if (viagemService.read(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        viagem.setId(id);
        Viagem atualizada = viagemService.edit(viagem);
        return ResponseEntity.ok(atualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (viagemService.read(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        viagemService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
