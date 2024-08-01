package appconsole;

import modelo.Venda;
import modelo.Produto;
import modelo.Tipo_Produto;
import regras_negocio.Fachada;

public class Consultar {

	public Consultar() {
		try {
			Fachada.inicializar();

			System.out.println("consultas... \n");
			System.out.println("\naLocalizar as Vendas por Data");
			for(Venda v : Fachada.vendaData("Data"))
				System.out.println(v);
			
			System.out.println("\naLocalizar Produto pelo Preco");
			for(Venda v : Fachada.produtoPreco())
				System.out.println(v);
			
			System.out.println("\naVendas que possuem 2 peodutos ");
			for(Venda v : Fachada.vendasNprodutos(2))
				System.out.println(v);
		
			

		Fachada.finalizar();
		System.out.println("\nfim do programa !");
	}

	public static void main(String[] args) {
		new Consultar();
	}
}

