package org.example.model;

public class product {

    double preco;
    String nome;
    int estoque;
    int id;

    public product(double preco, String nome, int estoque) {
        this.preco = preco;
        this.nome = nome;
        this.estoque = estoque;
    }

    public double getPrice() {
        return preco;
    }

    public void setPrice(double preco) {
        this.preco = preco;
    }

    public int getAmount() {
        return estoque;
    }

    public void setAmount(int estoque) {
        this.estoque = estoque;
    }

    public String getName() {
        return nome;
    }

    public void setName(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
