package model;



import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Visite implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numero;
	
	private double tarif;
	
	private int salle;
	
	@ManyToOne
	private Medecin medecin;
	
	@ManyToOne
	private Patient patient;



	public Visite() {
	
	}


	public Visite(int numero, double tarif, int salle, Medecin medecin, Patient patient) {
		
		this.numero = numero;
		this.tarif = tarif;
		this.salle = salle;
		this.medecin = medecin;
		this.patient = patient;
	}


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public double getTarif() {
		return tarif;
	}


	public void setTarif(double tarif) {
		this.tarif = tarif;
	}


	public int getSalle() {
		return salle;
	}


	public void setSalle(int salle) {
		this.salle = salle;
	}


	public Medecin getMedecin() {
		return medecin;
	}


	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}


	public Patient getPatient() {
		return patient;
	}


	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	
	
	
	
	
	
	

}
