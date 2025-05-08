package poo2.uniderp.agencia.pojo;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Viagem")
public class Viagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String destino;
    private LocalDateTime dataPartida;
    private LocalDateTime dataRetorno;
    private Double preco;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDestino() {
        return destino;
    }
    public void setDestino(String destino) {
        this.destino = destino;
    }
    public LocalDateTime getDataPartida() {
        return dataPartida;
    }
    public void setDataPartida(LocalDateTime dataPartida) {
        this.dataPartida = dataPartida;
    }
    public LocalDateTime getDataRetorno() {
        return dataRetorno;
    }
    public void setDataRetorno(LocalDateTime dataRetorno) {
        this.dataRetorno = dataRetorno;
    }
    public Double getPreco() {
        return preco;
    }
    public void setPreco(Double preco) {
        this.preco = preco;
    }
    public Viagem(){
    }
    public Viagem(Long id, String destino, LocalDateTime dataPartida, LocalDateTime dataRetorno, Double preco) {
        this.id = id;
        this.destino = destino;
        this.dataPartida = dataPartida;
        this.dataRetorno = dataRetorno;
        this.preco = preco;
    }

}


