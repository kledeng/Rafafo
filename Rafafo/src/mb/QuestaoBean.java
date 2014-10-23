package mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.PersistenceException;

import modelo.Banca;
import modelo.Questao;
import modelo.Tag;
import persistencia.QuestaoDao;

@Named @SessionScoped @Stateful
public class QuestaoBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private Questao questao = new Questao();
	private Tag tag = new Tag();
	private Tag tagPesquisa = new Tag();
	
	@Inject
	private QuestaoDao daoQuestao;
	
	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

	public Questao getQuestao() {
		return questao;
	}

	public void setQuestao(Questao questao) {
		this.questao = questao;
	}

	public Banca[] getBancas() {
		return Banca.values();
	}
	
	public Tag getTagPesquisa() {
		return tagPesquisa;
	}

	public void setTagPesquisa(Tag tagPesquisa) {
		this.tagPesquisa = tagPesquisa;
	}

	public String grava() {
		try {
			daoQuestao.add(questao);
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Questão guardada com sucesso!", null);
			FacesContext.getCurrentInstance().addMessage(null, message);
			this.questao = new Questao();
			return "";//questaoForm
		} catch (PersistenceException e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao gravar dados!", e.getLocalizedMessage());
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		return "";
	}
	
	public List<Questao> buscaPorTag() {
		try {
			return daoQuestao.buscaPorTag(getTagPesquisa());
		} catch (Exception e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao buscar questões!", e.getLocalizedMessage());
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
		return null;
	}
	public void limpaTags() {
		questao.setTags(null);
	}
}
