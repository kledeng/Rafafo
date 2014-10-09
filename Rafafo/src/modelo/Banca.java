package modelo;

public enum Banca {
	CESPE("CESPE UnB"),
//	FGV("Fundação Getúlio Vargas"),
//	FCC("Fundação Carlos Chagas"),
//	CesGran("Cesgranrio")
	;
	private String label;

	public String getLabel() {
		return this.label;
	}
	private Banca(String label) {
		this.label = label;
	}
	
	
}
