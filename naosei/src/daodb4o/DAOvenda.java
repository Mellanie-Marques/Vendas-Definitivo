package daodb4o;

import java.util.List;

import com.db4o.query.Candidate;
import com.db4o.query.Evaluation;
import com.db4o.query.Query;

import modelo.Venda;



public class DAOvenda extends DAO<Venda> {
	
	public Venda read (Object chave) {
		int id = (int) chave;
		Query q = manager.query();
		q.constrain(Venda.class);
		q.descend("id").constrain(id);
		List<Venda> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
	}
	//metodo sobrescrito da classe DAO para criar "id" sequencial 
	public void create(Venda obj){
		int novoid = super.gerarId();  	//gerar novo id da classe
		obj.setId(novoid);				//atualizar id do objeto antes de grava-lo no banco
		manager.store( obj );
	}

	
	
	//----------------------------------------------	
	//   consultas Venda 
	// ---------------------------------------------
	
	//Quais as vendas da data X
	public List<Venda> vendasData(String data){
		Query q;
		q = manager.query();
		q.constrain(Venda.class);
		q.descend("venda").descend("data").constrain(data);
		return q.execute();
	}
		
	//Quais as vendas que contem um produto de preco X
	public List<Venda> produtoPreco(double preco){
		Query q;
		q = manager.query();
		q.constrain(Venda.class);
		q.descend("venda").descend("preco").constrain(preco);
		return q.execute();
	}
	
	//Quais as vendas com mais de N produtos
	public List<Venda> vendasNprodutos(int n){
		Query q = manager.query();
		q.constrain(Venda.class);
		q.constrain(new Filtro(n));
		return q.execute();
	}
	
	class Filtro implements Evaluation {
		private int n;
		public Filtro(int n) {
			this.n = n;
		}
		public void evaluate(Candidate candidate) {
			Venda vend = (Venda) candidate.getObject();
			if(vend.getProdutos().size()== n) 
				candidate.include(true); 
			else		
				candidate.include(false);
		}
	}
}
