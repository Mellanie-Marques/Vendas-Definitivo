package modelo;


public class Produto {
    private String nome;
    private Tipo_Produto  tipoProduto;
    private double preco;

    // Construtor
    public Produto(String nome, Tipo_Produto  tipoProduto, double preco) {
        this.nome = nome;
        this.tipoProduto = tipoProduto;
        this.preco = preco;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Tipo_Produto  getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(Tipo_Produto tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}

