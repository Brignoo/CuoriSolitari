package it.unibs.fp.cuoriSolitari;

public enum Zodiacale {
	
	CAPRICORNO("Capricorno", "Terra", "22/12", "20/01"),
	ACQUARIO("Acquario", "Aria", "21/01", "19/02"),
	PESCI("Pesci", "Acqua", "20/02", "20/03"),
	ARIETE("Ariete", "Fuoco", "21/03", "20/04"),
	TORO("Toro", "Terra", "21/04", "20/05"),
	GEMELLI("Gemelli", "Aria", "21/05", "21/06"),
	CANCRO("Cancro", "Acqua", "22/06", "22/07"),
	LEONE("Leone", "Fuoco", "23/07", "23/08"),
	VERGINE("Vergine", "Terra", "24/08", "22/09"),
	BILANCIA("Bialncia", "Aria", "23/09", "22/10"),
	SCORPIONE("Scorpione", "Acqua", "23/10", "22/11"),
	SAGITTARIO("Saggitario", "Fuoco", "23/11", "21/12");
	
	private String nome;
	private String elemento;
	private String inizioSegno;
	private String fineSegno;
	
	
	private Zodiacale(String nome, String elemento, String inizioSegno, String fineSegno) {
		this.nome = nome;
		this.elemento = elemento;
		this.inizioSegno = inizioSegno;
		this.fineSegno = fineSegno;
	}

	public String getNome() {
		return nome;
	}

	public String getElemento() {
		return elemento;
	}
	
	public int getMeseI() {
		
		String s = this.inizioSegno;
		s = s.substring( s.indexOf("/") + 1 );
		
		return Integer.parseInt(s);
		
	}
	
	public int getMeseF() {
		
		String s = this.fineSegno;
		s = s.substring( s.indexOf("/") + 1 );
		
		return Integer.parseInt(s);
	}
	
	public int getGiornoI() {
		
		String s = this.inizioSegno;
		s = s.substring( 0, s.indexOf("/") );
		
		return Integer.parseInt(s);
		
	}
	
	public int getGiornoF() {
		
		String s = this.fineSegno;
		s = s.substring( 0, s.indexOf("/") );
		
		return Integer.parseInt(s);
		
	}
	
	@Override
	public String toString() {
		
		return this.nome + " da " + this.inizioSegno + " a " + this.fineSegno + " è un segno di " + this.elemento;   
	}
}
