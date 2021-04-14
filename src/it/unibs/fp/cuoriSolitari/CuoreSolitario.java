package it.unibs.fp.cuoriSolitari;

import java.util.Calendar;
import java.util.Date;

public class CuoreSolitario {
	
	private static final int DIFFERENZA_ETA = 18;
	
	private String nickname;
	private char sesso;
	private int eta;
	private Date dataNascita;
	private Zodiacale segnoZodiacale;
	
	public CuoreSolitario(String nickname, char sesso, Date dataNascita) {
		
		this.nickname = nickname;
		this.sesso = sesso;
		this.dataNascita = dataNascita;
		calcolaEta();
		determinaSegno();
	}
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public char getSesso() {
		return sesso;
	}
	public void setSesso(char sesso) {
		this.sesso = sesso;
	}
	
	public int getEta() {
		return eta;
	}
	
	public Date getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}
	
	public Zodiacale getSegnoZodiacale() {
		return segnoZodiacale;
	}
	
	public String toString() {

		return this.nickname + " \tSegno zodiacale: " + segnoZodiacale.getNome() + ", elemento: " + segnoZodiacale.getElemento();
	}
	
	@SuppressWarnings("deprecation")
	public void calcolaEta() {
		
		this.eta = Calendar.getInstance().get(Calendar.YEAR) - (dataNascita.getYear()+1900);
	}
	
	@SuppressWarnings("deprecation")
	public void determinaSegno() {
		
		int mese = this.dataNascita.getMonth() + 1;
		int giorno = this.dataNascita.getDate();
		
		for( Zodiacale z : Zodiacale.values() ) {
			
			if ( mese == z.getMeseI() ) {
				
				if( giorno >= z.getGiornoI() ) {
					
					this.segnoZodiacale = z;
					break;
				}
			}
			
			if ( mese == z.getMeseF() ) {
				
				if( giorno <= z.getGiornoF() ) {
					
					this.segnoZodiacale = z;
					break;
				}
			}
		}
	}
	
	public boolean isAffine( CuoreSolitario persona ) {
		
		if( this.sesso != persona.sesso && Math.abs(this.eta - persona.eta) <= DIFFERENZA_ETA ) {
			
			if( this.segnoZodiacale.getElemento().equals(persona.getSegnoZodiacale().getElemento())) {
				
				return true;
			}
		}
		
		return false;
	}
}
