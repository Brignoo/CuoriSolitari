package it.unibs.fp.cuoriSolitari;

import java.util.Date;

import it.unibs.fp.mylib.MyInputDati;

public class CuoriSolitariMain {
	
	private static final String AFFINITA = "\nTra %s e %s%s c'è affinità";
	private static final String FORMATO = "dd/MM/yyyy";
	private static final String SI = "";
	private static final String NO = " non";
	private static final int ETA_MASSIMA = 110;
	private static final int ETA_MINIMA = 18;
	
	public static void saluto() {
		
		System.out.println("Benvenuto nel determinatore di affinità!");
	}
	
	public static CuoreSolitario nuovoCuoreSolitario() {
		
		String nome = MyInputDati.leggiStringaAlfaNumerica( "\nInserire il proprio nickname: " );
		Date nascita = MyInputDati.leggiDataControllo( "Inserire la propria data di nascita", FORMATO, ETA_MINIMA, ETA_MASSIMA );
		char sesso = MyInputDati.leggiUpperChar("Inserire il sesso: (Scegli tra M oppure F)", "MF" );
		
		CuoreSolitario p = new CuoreSolitario(nome, sesso, nascita);
		System.out.println("\n" + p.toString() + "\n");
		
		return p;		
	}
	
	public static void sonoAffine(CuoreSolitario p1, CuoreSolitario p2) {
		
		if(p1.isAffine(p2)) {
			
			System.out.println(String.format(AFFINITA, p1.getNickname(), p2.getNickname(), SI));
		}
		else {
			
			System.out.println(String.format(AFFINITA, p1.getNickname(), p2.getNickname(), NO));
		}
	}

	public static void main(String[] args) {
		
		saluto();
		
		CuoreSolitario p1 = nuovoCuoreSolitario();
		CuoreSolitario p2 = nuovoCuoreSolitario();
		
		sonoAffine(p1, p2);
	}
}
