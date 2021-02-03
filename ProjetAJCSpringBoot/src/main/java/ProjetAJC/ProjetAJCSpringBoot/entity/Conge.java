package ProjetAJC.ProjetAJCSpringBoot.entity;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@SequenceGenerator(name = "seqConge", sequenceName = "seq_conge", initialValue = 1, allocationSize = 1)
public class Conge {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqConge")
	private Integer id;
	
	@ManyToOne
	private Employe employe;
	@Enumerated(EnumType.STRING)
	private TypeConge typeConge;
	
	@Column(columnDefinition = "DATE")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateDebut;
	@Column(columnDefinition = "DATE")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateFin;
	@Column(columnDefinition = "DATE")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateDemande=LocalDate.now();
	
	private Integer nbJour;
	private String motif;
	private String etat = "ATTENTE";
	
	@Version
	private int version;
	
	
	public Conge() {
	}


	public Conge(Integer id, Employe employe, TypeConge typeConge, LocalDate dateDebut, LocalDate dateFin, String motif) {
		this.id = id;
		this.employe = employe;
		this.typeConge = typeConge;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.motif = motif;
	}

	
	public Conge(Employe employe, TypeConge typeConge, LocalDate dateDebut, LocalDate dateFin, String motif) {
		this.employe = employe;
		this.typeConge = typeConge;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.nbJour = calculeNbJour();
		this.motif = motif;
	}


	public void Valider() {
		this.setEtat("VALIDE");
	}
	
	public void Refuser(String motifRefus) {
		this.setEtat("REFUSE");
		this.motif=this.motif+"\n Motif refus:\n"+motifRefus;
	}
	
	public int calculeNbJour() {
		int days = (int) ChronoUnit.DAYS.between(this.dateDebut, this.dateFin);
		return days;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public TypeConge getTypeConge() {
		return typeConge;
	}

	public void setTypeConge(TypeConge typeConge) {
		this.typeConge = typeConge;
	}

	public LocalDate getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	public LocalDate getDateDemande() {
		return dateDemande;
	}

	public void setDateDemande(LocalDate dateDemande) {
		this.dateDemande = dateDemande;
	}

	public Integer getNbJour() {
		return nbJour;
	}

	public void setNbJour(Integer nbJour) {
		this.nbJour = nbJour;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}


	@Override
	public String toString() {
		return "Conge [id=" + id + ", employe=" + employe + ", typeConge=" + typeConge + ", dateDebut=" + dateDebut
				+ ", dateFin=" + dateFin + ", dateDemande=" + dateDemande + ", nbJour=" + nbJour + ", motif=" + motif
				+ ", etat=" + etat + ", version=" + version + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conge other = (Conge) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
