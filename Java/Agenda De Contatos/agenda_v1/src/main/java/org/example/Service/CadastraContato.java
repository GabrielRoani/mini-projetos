package org.example.Service;

import org.example.Model.Contatos;

import java.util.ArrayList;
import java.util.List;

public class CadastraContato {

    private List<Contatos> contatos;

    public CadastraContato() {
        this.contatos = new ArrayList<>();
    }

    public List<Contatos> cadastrarUsuario(String nome, String numero, String gmail) {
        Contatos contato = new Contatos(nome, numero, gmail);
        contatos.add(contato);
        return contatos;
    }

    public List<Contatos> listarUsuarios() {
        return new ArrayList<>(contatos); // Retorna uma cópia da lista
    }

    // Novo método para atualizar um contato existente
    public boolean atualizarUsuario(String nome, String novoNumero, String novoGmail) {
        for (Contatos contato : contatos) {
            if (contato.getNome().equalsIgnoreCase(nome)) { // Encontrar o contato pelo nome
                contato.setNumero(novoNumero); // Atualizar o número
                contato.setGmail(novoGmail);   // Atualizar o e-mail
                return true; // Retorna verdadeiro se o contato foi atualizado com sucesso
            }
        }
        return false; // Retorna falso se o contato não foi encontrado
    }
}
