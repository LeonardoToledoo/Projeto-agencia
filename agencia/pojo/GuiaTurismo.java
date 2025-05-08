package poo2.uniderp.agencia.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table (name = "GuiaTurismo")
public class GuiaTurismo {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String idioma;
    private String registroMinTur;


    public String getRegistroMinTur() {
        return registroMinTur;
    }
    public void setRegistroMinTur(String registroMinTur) {
        this.registroMinTur = registroMinTur;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getIdioma() {
        return idioma;
    }
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public GuiaTurismo() {
    }
    public GuiaTurismo(Long id, String nome, String idioma) {
        this.id = id;
        this.nome = nome;
        this.idioma = idioma;
    }
}