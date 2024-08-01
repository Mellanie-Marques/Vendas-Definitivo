package appconsole;

import modelo.Venda;
import modelo.Tipo_Produto;
import modelo.Produto;
import regras_negocio.Fachada;

public class Listar {

	public Listar() {
		try {
			Fachada.inicializar();
			System.out.println("\n---listagem de Vendas:");
			for(Venda v: Fachada.listarVendas())
				System.out.println(v);

			System.out.println("\n---listagem de Tipos de Produtos:");
			for(Tipo_Produto tp: Fachada.listarTiposProdutos())
				System.out.println(tp);
			
			System.out.println("\n---listagem de Produtos:");
			for(Produto p: Fachada.listarProdutos())
				System.out.println(p);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		Fachada.finalizar();
		System.out.println("\nfim do programa !");
	}

	public static void main(String[] args) {
		new Listar();
	}
}
