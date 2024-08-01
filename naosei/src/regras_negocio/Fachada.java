package regras_negocio;

import java.util.ArrayList;
import java.util.List;

import daodb4o.DAO;
import daodb4o.DAOproduto;
import daodb4o.DAOtipo_produto;
import daodb4o.DAOvenda;
import modelo.Produto;
import modelo.Tipo_Produto;
import modelo.Venda;

public class Fachada {
	private Fachada() {}
	
	private static DAOproduto daoproduto = new DAOproduto();
	private static DAOtipo_produto daotipo_produto = new DAOtipo_produto(); 
	private static DAOvenda daovenda = new DAOvenda();
	
	public static void inicializar(){
		DAO.open();
	}
	
	
	public static void finalizar(){
		DAO.close();
	}
	
	
	//-----Criar Venda--------
	public static Venda criarVenda( String Data) throws Exception {
		DAO.begin();

	  Venda venda = new Venda( Data);

		daovenda.create(venda);
		DAO.commit();
		return venda;
	}
	
	 //----Excluir Venda---
	  public static void excluirVenda(int id) throws Exception {
		    DAO.begin();
		    Venda vend = daovenda.read(id);
		    if (vend == null)
		        throw new Exception("venda incorreta para exclusão " + id);
		    

		    daovenda.delete(vend);
		    DAO.commit();
		}
	  
	  
	  //---Atualizar Venda-----
	  
	  
	
	
	//-----Criar Produto----
	public static void criarProduto(String nome, String nometipoProduto, double preco) throws Exception {
		DAO.begin();
		Produto produto = daoproduto.read(nome);
		if (produto!=null)
			throw new Exception("produto já criado" + produto);
		
		Tipo_Produto tipo = daotipo_produto.read(nometipoProduto);
		if (tipo==null)
			throw new Exception("tipo de produto inexistente" + nometipoProduto);
		
		
		produto = new Produto(nome, tipo, preco);

		daoproduto.create(produto);
		DAO.commit();
	}
	
	//-----Excluir Produto-----
		public static void excluirProduto(String nome) throws Exception{
			DAO.begin();
			Produto pod = daoproduto.read(nome);
			if(pod==null)
				throw new Exception ("produto incorreta para exclusão" + nome);
		
			daoproduto.delete(pod);
			DAO.commit();
		}
		
		//-----Alterar Produto no Tipo Produto -----

		public static void alterarProdutonoTipo(String nome, String nometipoProduto) throws Exception {
		    // Inicia uma transação com o banco de dados
		    DAO.begin();

		    // Busca o produto pelo nome no banco de dados
		    Produto produto = daoproduto.read(nome);

		    // Se o produto não for encontrado, faz rollback da transação e lança uma exceção
		    if (produto == null) {
		        DAO.rollback();
		        throw new Exception("alterar Produto no Tipo Produto - Produto inexistente:" + nome);
		    }

		    // Busca o tipo de produto pelo nome no banco de dados
		    Tipo_Produto tproduto = daotipo_produto.read(nometipoProduto);

		    // Se o tipo de produto não for encontrado, faz rollback da transação e lança uma exceção
		    if (tproduto == null) {
		        DAO.rollback();
		        throw new Exception("alterar Produto no Tipo Produto - Tipo do Produto inexistente:" + nometipoProduto);
		    }

		    // Se o tipo de produto encontrado já for o tipo atual do produto, faz rollback da transação e lança uma exceção
		    if (tproduto.equals(produto.getTipoProduto())) {
		        DAO.rollback();
		        throw new Exception("alterar Produto no Tipo Produto - Tipo do Produto nao pode ser o atual:" + nometipoProduto);
		    }

		    // Altera o tipo de produto do produto
		    produto.setTipoProduto(tproduto);

		    // Atualiza o produto no banco de dados
		    daoproduto.update(produto);

		    // Confirma a transação
		    DAO.commit();
		}

		
			
	  //---Criar Tipo de produto----
	
	public static Tipo_Produto criarTipo_Produto( String Nome) throws Exception {
		DAO.begin();

	  Tipo_Produto tipo = new Tipo_Produto( Nome);

		daotipo_produto .create(tipo);
		DAO.commit();
		return tipo;
	}
	  
	
	//---Excluir Tipo de produto------
	public static void excluirTipoProduto(String Nome) throws Exception{
		  DAO.begin();
		  Tipo_Produto tprod = daotipo_produto.read(Nome);
		  if (tprod == null)
			  throw new Exception("Tipo de Produto não existe para exclusão" + Nome);
		  
		  daotipo_produto.delete(tprod);
		  DAO.commit();
	  }
	
	
	
	
	//---Listar Venda----
	public static List<Venda>  listarVendas(){
		List<Venda > resultados =  daovenda.readAll();
		return resultados;
	} 

	//----Listar Tipo Produto
	public static List<Tipo_Produto >  listarTiposProdutos(){
		List<Tipo_Produto > resultados =  daotipo_produto .readAll();
		return resultados;
	}

	//----Listar produto----
	public static List<Produto> listarProdutos (){
		List<Produto> resultados =  daoproduto .readAll();
		return resultados;
	}
	
	
	
	//------------------------------------------------------
	public static List<Venda> vendaData(String Data){	
		List<Venda> resultados =  daovenda.vendasData(Data);
		return resultados;
	}
	
	public static List<Venda> produtoPreco(double preco){	
		List<Venda> resultados =  daovenda.produtoPreco(preco);
		return resultados;
	}

	public static List<Venda>  vendasNprodutos(int n){	
		List<Venda> resultados =  daovenda.vendasNprodutos(n);
		return resultados;
	}

	
}

