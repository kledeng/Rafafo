package modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Log implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int idQuestao;
	private Boolean marcacao;
	@OneToOne
	private Sprint sprint;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdQuestao() {
		return idQuestao;
	}
	public void setIdQuestao(int idQuestao) {
		this.idQuestao = idQuestao;
	}
	public Boolean getMarcacao() {
		return marcacao;
	}
	public void setMarcacao(Boolean marcacao) {
		this.marcacao = marcacao;
	}
	public Sprint getSprint() {
		return sprint;
	}
	public void setSprint(Sprint sprint) {
		this.sprint = sprint;
	}
	
}
