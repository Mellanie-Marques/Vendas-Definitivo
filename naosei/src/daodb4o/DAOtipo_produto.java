package daodb4o;
import modelo.Produto;
import modelo.Tipo_Produto;
import java.util.List;
import com.db4o.query.Query;

public class DAOtipo_produto extends DAO<Tipo_Produto>{
	public Tipo_Produto read (Object chave) {
		String nome = (String) chave;
		Query q = manager.query();
		q.constrain(Tipo_Produto.class);
		q.descend("nome").constrain(nome);
		List<Tipo_Produto> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
	}

	public List<Tipo_Produto> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

}