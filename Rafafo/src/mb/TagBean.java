package mb;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.PersistenceException;

import modelo.Assunto;
import modelo.Disciplina;
import modelo.Tag;
import persistencia.AssuntoDao;
import persistencia.TagDao;

@Named
@SessionScoped @Stateful
public class TagBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private TagDao daoTag;
	@Inject
	private AssuntoDao daoAssunto;

	private Tag tag = new Tag();

	private Disciplina disciplina;

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public TagDao getDaoTag() {
		return daoTag;
	}

	public void setDaoTag(TagDao daoTag) {
		this.daoTag = daoTag;
	}

	public AssuntoDao getDaoAssunto() {
		return daoAssunto;
	}

	public void setDaoAssunto(AssuntoDao daoAssunto) {
		this.daoAssunto = daoAssunto;
	}

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

	public List<Assunto> listaAssuntos() {
		return daoAssunto.listaTodos(getDisciplina());
	}

	public String grava() {

		try {
			daoTag.add(tag);
			this.tag = new Tag();
			this.disciplina = null;
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Registro salvo com sucesso!!", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		} catch (PersistenceException e) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Erro ao guardar dados!!",
					null);
			FacesContext.getCurrentInstance().addMessage(null, message);
			System.out.println(e);
		}
		return "";

	}
	
		private String text;
		
	 public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}

	public List<Tag> completeTag(String query) {
	        return daoTag.procuraPorNome(query);
	    }
}
