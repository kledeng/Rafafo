package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Questao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(nullable=false) 
	private String item;
	@Column(nullable=false) 
	private int nrItem;
	@Column(nullable=false) 
	private int ano;
	private int dificuldade;
	@Column(nullable=false)
	private String enunciado;
	@Column(columnDefinition="text")
	private String justificativa;
	private String observacao;
	@Enumerated(EnumType.STRING) @Column(nullable=false)
	private Banca banca;
	@Column(nullable=false)
	private String cargo;
	@Column(nullable=false)
	private String orgao;
	private Boolean gabarito;
	@Column(nullable=false)
	@OneToMany
	private List<Tag> tags;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEnunciado() {
		return enunciado;
	}
	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public Banca getBanca() {
		return banca;
	}
	public void setBanca(Banca banca) {
		this.banca = banca;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getOrgao() {
		return orgao;
	}
	public void setOrgao(String orgao) {
		this.orgao = orgao;
	}
	public Boolean getGabarito() {
		return gabarito;
	}
	public void setGabarito(Boolean gabarito) {
		this.gabarito = gabarito;
	}
	public List<Tag> getTags() {
		if (tags == null) {
			tags = new ArrayList<Tag>();
		}
		return tags;
	}
	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}
	public int getNrItem() {
		return nrItem;
	}
	public void setNrItem(int nrItem) {
		this.nrItem = nrItem;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public int getDificuldade() {
		return dificuldade;
	}
	public void setDificuldade(int dificuldade) {
		this.dificuldade = dificuldade;
	}
	public String getJustificativa() {
		return justificativa;
	}
	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((banca == null) ? 0 : banca.hashCode());
		result = prime * result + ((cargo == null) ? 0 : cargo.hashCode());
		result = prime * result
				+ ((enunciado == null) ? 0 : enunciado.hashCode());
		result = prime * result
				+ ((gabarito == null) ? 0 : gabarito.hashCode());
		result = prime * result + id;
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + nrItem;
		result = prime * result + ((orgao == null) ? 0 : orgao.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Questao other = (Questao) obj;
		if (banca != other.banca)
			return false;
		if (cargo == null) {
			if (other.cargo != null)
				return false;
		} else if (!cargo.equals(other.cargo))
			return false;
		if (enunciado == null) {
			if (other.enunciado != null)
				return false;
		} else if (!enunciado.equals(other.enunciado))
			return false;
		if (gabarito == null) {
			if (other.gabarito != null)
				return false;
		} else if (!gabarito.equals(other.gabarito))
			return false;
		if (id != other.id)
			return false;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (nrItem != other.nrItem)
			return false;
		if (orgao == null) {
			if (other.orgao != null)
				return false;
		} else if (!orgao.equals(other.orgao))
			return false;
		return true;
	}
	
	
	
}
