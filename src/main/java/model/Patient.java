package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name="Patient")
@Table(name="Patient")
public class Patient implements Serializable {
	
	@Id
	@Column(name="n_secu")
	private int secu;
	
	private String nom;
	
	
	private String prenom;
	
	
	@Embedded
	private Adresse adresse;
	
	@OneToMany(mappedBy = "patient")
	private List<Visite> visite = new ArrayList<>();

	
	public Patient() {
	
	}

	public Patient(int secu, String nom, String prenom, Adresse adresse) {
	
		this.secu = secu;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
	}

	public int getSecu() {
		return secu;
	}

	public void setSecu(int secu) {
		this.secu = secu;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public List<Visite> getVisite() {
		return visite;
	}

	public void setVisite(List<Visite> visite) {
		this.visite = visite;
	}

		
  
	
	
	

}
