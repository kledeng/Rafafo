package persistencia;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import modelo.Questao;
import modelo.Tag;

public class QuestaoDao extends BaseDao<Tag> implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="rafafo")
	private EntityManager manager;
	
	public void add(Questao questao) throws PersistenceException{
		this.manager.persist(questao);
	}

	@SuppressWarnings("unchecked")
	public List<Questao> buscaPorTag(Tag tagPesquisa) {
		StringBuilder q = new StringBuilder();
		q.append("select q from Questao q left outer join q.tags " 
				+ "	where qt.Tags_id = :tagId order by q.id");
		Query query = this.manager.createQuery(q.toString());
		query.setParameter("tagId", tagPesquisa.getId());
		return (List<Questao>) query.getResultList();
	}
	
}
