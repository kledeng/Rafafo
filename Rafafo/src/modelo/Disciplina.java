package modelo;

public enum Disciplina {
	AOC("Arquitetura de Computadores"),
	ASW("Arquitetura de Software"),
	AED("Algoritimos e Estrutura de Dados"),
	BD("Banco de Dados"),
	CEx("Controle Externo"),
	DAD("Direito Administrativo"),
	DCo("Direito Constitucional"),
	Dev("Desenvolvimento"),
	GovTI("Governan�a de TI"),
	GerP("Gest�o de Projetos"),
	ESW("Engenharia de Software"),
	Ing("Ingl�s"),
	Port("Portugu�s"), 
	SegI("Seguran�a da Informa��o"), 
	SI("Sistemas de Informa��o"),
	SO("Sistemas Operacionais"),
	Redes("Redes"), 
	;
	private String label;

	public String getLabel() {
		return this.label;
	}
	private Disciplina(String label) {
		this.label = label;
	}
	
	
}
