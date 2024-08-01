package modelo;

import java.util.ArrayList;

public class Venda {
	private int id;
	private String Data;
	private ArrayList<Produto> produtos;
	
	public Venda( String Data) {
        this.Data = Data;
       
        
    }
	
	public Venda() {
        this.produtos = new ArrayList<>();
    }

	  // Método para calcular o valor pago como a soma dos preços dos produtos
    public double getValorPago() {
        double total = 0.0;
        for (Produto produto : produtos) {
            total += produto.getPreco();
            
        }
        return total;
    }
	
    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        this.Data = data;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }



  

    
    
}
