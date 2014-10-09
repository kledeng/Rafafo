package persistencia;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import modelo.Tag;

public class TagDao extends BaseDao<Tag> implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="rafafo")
	private EntityManager manager;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void add(Tag tag) throws PersistenceException {
			this.manager.persist(tag);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Tag> procuraPorNome(String digitado){
		StringBuilder q = new StringBuilder();
		q.append("select t from Tag as t " 
				+ "	where nome like :queryNome order by t.nome");
		Query query = this.manager.createQuery(q.toString());
		query.setParameter("queryNome", "%"+digitado+"%");
		return (List<Tag>) query.getResultList();
	}
	
}
