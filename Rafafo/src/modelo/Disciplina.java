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
	GovTI("Governança de TI"),
	GerP("Gestão de Projetos"),
	ESW("Engenharia de Software"),
	Ing("Inglês"),
	Port("Português"), 
	SegI("Segurança da Informação"), 
	SI("Sistemas de Informação"),
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
