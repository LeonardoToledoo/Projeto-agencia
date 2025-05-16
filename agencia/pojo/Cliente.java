package poo2.uniderp.agencia.pojo;



import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public Cliente(String email, Long id, String nome, String telefone) {
        this.email = email;
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
    }
    
    
    public Cliente() {
    }


    @OneToMany(mappedBy = "cliente",
     cascade = CascadeType.ALL,
      fetch= FetchType.LAZY)
    @JsonManagedReference 
    private Set <GuiaTurismo> guiasTurismo;

}

