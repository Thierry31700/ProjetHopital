package model;

import javax.persistence.Embeddable;

@Embeddable
public class Adresse {

	
	private int numero,cp;
	private String voie;
	private String ville;
	
	
	public Adresse() {
		
	}


	public Adresse(int numero, String voie, String ville, int cp) {
		this.numero = numero;
		this.voie = voie;
		this.ville = ville;
		this.cp=cp;
	}


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public String getVoie() {
		return voie;
	}


	public void setVoie(String voie) {
		this.voie = voie;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}


	public int getCp() {
		return cp;
	}


	public void setCp(int cp) {
		this.cp = cp;
	}
	
	
}
