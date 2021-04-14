package it.unibs.fp.cuoriSolitari;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CuoriSolitariTest {
	
	private static final String AFFINITA = "Tra %s e %s%s c'è affinità";
	private static final String SI = "";
	private static final String NO = " non";
	
	public static void controlloAffinita( CuoreSolitario p1, CuoreSolitario p2 ) {
		
		if(p1.isAffine(p2)){
			
			System.out.println(String.format(AFFINITA, p1.getNickname(), p2.getNickname(), SI));
		}
		else {
			
			System.out.println(String.format(AFFINITA, p1.getNickname(), p2.getNickname(), NO));
		}
		
		if(p2.isAffine(p1)){
			
			System.out.println(String.format(AFFINITA, p2.getNickname(), p1.getNickname(), SI));
		}
		else {
			
			System.out.println(String.format(AFFINITA, p2.getNickname(), p1.getNickname(), NO));
		}
	}

	public static void main(String[] args) throws ParseException {
	
		DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
		
		String nome = "Mario453";
		String d = "12/12/2001";
		char sesso = 'M'; 
		Date data = sdf.parse(d);
		
		CuoreSolitario p1 = new CuoreSolitario(nome, sesso, data);
		
		nome = "Giulia88";
		d = "11/07/1988";
		sesso = 'F';
		data = sdf.parse(d);
		
		CuoreSolitario p2 = new CuoreSolitario(nome, sesso, data);
		
		nome = "Franco45";
		d = "15/09/1963";
		sesso = 'M';
		data = sdf.parse(d);
	
		CuoreSolitario p3 = new CuoreSolitario(nome, sesso, data);
		
		controlloAffinita(p1, p2);
		controlloAffinita(p1, p3);
		controlloAffinita(p2, p3);
		
		System.out.println("\n\nSe mettiamo due segni con lo stesso elemento e età entro i limiti:");
		
		nome = "Marco1999";
		d = "23/10/1999";
		sesso = 'M';
		data = sdf.parse(d);
	
		CuoreSolitario p4 = new CuoreSolitario(nome, sesso, data);
		
		controlloAffinita(p4, p2);
	}

}
