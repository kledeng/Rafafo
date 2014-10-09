package persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class BaseDao<E> {

	@PersistenceContext(unitName="rafafo")
	protected EntityManager entityManager;
	
	private Class<E> entityClass;
	
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void add(E e){
		this.getEntityManager().persist(e);
	}
	
	public List<E> procuraPorNome(String nome){
//		this.entityManager.find(arg0, "")
		return null;
	}
		
	public E find(Object id){		
		return getEntityManager().find(entityClass, id);
	}
	
	public void remove(Object id){
		getEntityManager().refresh(id);
	}
}
