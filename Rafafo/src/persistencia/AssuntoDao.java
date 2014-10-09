package persistencia;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import modelo.Assunto;
import modelo.Disciplina;
import modelo.Tag;

public class AssuntoDao extends BaseDao<Assunto> implements Serializable {
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "rafafo")
	private EntityManager manager;

	public void add(Assunto assunto) throws PersistenceException {
			this.manager.persist(assunto);
	}

	@SuppressWarnings("unchecked")
	public List<Assunto> listaTodos(Disciplina disciplina) {
		StringBuilder query = new StringBuilder(
				"select a from Assunto as a where a.disciplina = :disciplina");
		Query q = this.manager.createQuery(query.toString());
		q.setParameter("disciplina", disciplina);
		return (List<Assunto>) q.getResultList();
	}
	
	public List<Assunto> listaAssuntosRelacionados(Tag tag) {
		StringBuilder query = new StringBuilder(
				"select distinct a from Assunto as a inner join Tag as t "
				+ "on t.assunto=a.id"
				+ "	where t.id = :tagid");
		Query q = this.manager.createQuery(query.toString());
		q.setParameter("tagid", tag.getId());
		return (List<Assunto>) q.getResultList();
	}
}
