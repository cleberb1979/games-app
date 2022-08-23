package com.cleberb.gamesapp.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tbl_game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String produtora;
    private boolean zerado;
    private int nota;
    private String console;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getProdutora() {
        return produtora;
    }

    public void setProdutora(String produtora) {
        this.produtora = produtora;
    }

    public boolean isZerado() {
        return zerado;
    }

    public void setZerado(boolean zerado) {
        this.zerado = zerado;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getConsole() {
        return console;
    }

    public void setConsole(String console) {
        this.console = console;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Game)) return false;
        Game game = (Game) o;
        return zerado == game.zerado && nota == game.nota && id.equals(game.id) && titulo.equals(game.titulo) && produtora.equals(game.produtora) && console.equals(game.console);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, produtora, zerado, nota, console);
    }
}
