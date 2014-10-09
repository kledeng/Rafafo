package mb;

import javax.ejb.Stateful;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.PersistenceException;

import modelo.Assunto;
import modelo.Disciplina;
import persistencia.AssuntoDao;

@Named
@RequestScoped
@Stateful
public class assuntoBean {

	private Assunto assunto = new Assunto();

	@Inject
	private AssuntoDao daoAssunto;

	public Assunto getAssunto() {
		return assunto;
	}

	public void setAssunto(Assunto assunto) {
		this.assunto = assunto;
	}

	public String grava() {
		try {
			daoAssunto.add(assunto);
			this.assunto = new Assunto();
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Registro salvo com sucesso!!", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
		} catch (PersistenceException e) {
			FacesMessage message = new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Erro ao guardar dados!!",
					null);
			FacesContext.getCurrentInstance().addMessage(null, message);

		}
		return "";
	}

	public Disciplina[] getDisciplinas() {
		return Disciplina.values();
	}
}
