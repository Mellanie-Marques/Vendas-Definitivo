package appconsole;

import regras_negocio.Fachada;

public class Cadastrar {

	public Cadastrar() {
		try {
			Fachada.inicializar();
			System.out.println("cadastrando Venda...");
			Fachada.criarVenda("20/07/2024");
			Fachada.criarVenda("21/07/2024");
			Fachada.criarVenda("22/07/2024");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		try {
			System.out.println("cadastrando Tipo de Produto...");
			Fachada.criarTipo_Produto("Salgado");
			Fachada.criarTipo_Produto("Doce");
			Fachada.criarTipo_Produto("Sobremesa");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		try {
			System.out.println("Cadastrando Produto...");
			Fachada.criarProduto("Torta Salgada","Salgado",10.0);
			Fachada.criarProduto("Bolo","Doce",20.0 );
			Fachada.criarProduto("Pudim","Sobremesa",15.0);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		Fachada.finalizar();
		System.out.println("\nfim do programa !");
	}


	public static void main(String[] args) {
		new Cadastrar();
	}
}
