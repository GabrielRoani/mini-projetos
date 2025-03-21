package org.example.Model;

public class Contatos {

    private String nome;
    private String numero;
    private String gmail;

    public Contatos(String nome, String numero, String gmail) {
        this.nome = nome;
        this.numero = numero;
        this.gmail = gmail;
    }

    public String getNome() {
        return nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }
}
