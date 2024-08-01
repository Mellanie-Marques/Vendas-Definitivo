package modelo;

import java.util.ArrayList;
import java.util.List;

public class Tipo_Produto {
    private String nome;
    private List<Produto> produtos;

    // Construtor padrão
    public Tipo_Produto() {
        this.produtos = new ArrayList<>();
    }

    // Construtor com nome
    public Tipo_Produto(String nome) {
        this.nome = nome;
        this.produtos = new ArrayList<>();
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    // Método para adicionar um produto à lista de produtos
    public void adicionarProduto(Produto produto) {
        this.produtos.add(produto);
    }

    // Método para remover um produto da lista de produtos
    public void removerProduto(Produto produto) {
        this.produtos.remove(produto);
    }
}