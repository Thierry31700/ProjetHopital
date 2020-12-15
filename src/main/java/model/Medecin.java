package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
@DiscriminatorValue("Medecin")
public class Medecin extends Compte{

	
	@OneToMany(mappedBy = "medecin")
	private List<Visite> visites=new ArrayList();

	public Medecin() {
		super();
	}

	public Medecin(String login, String password) {
		super(login, password);
		// TODO Auto-generated constructor stub
	}

	public List<Visite> getVisites() {
		return visites;
	}

	public void setVisites(List<Visite> visites) {
		this.visites = visites;
	}

	
	
	
	/*
	// dans le main
	public static void ouvertureSalle()
	{
		//A completer
		//afficher les infos du nouveau patient
		//(recup premier element de la liste et le supprimer de la liste
	}
	
	public static void infosPatient()
	{
		//A completer (afficher par identifiant ou nonm)
	}
	
	public static void voirFileAttente()
	{
		//A completer
		//le medecin peut visualiser la liste d’attente 
		//des patients, ainsi que le prochain patient 
		//dans la file
	}
	
	public static void sauvListVisite()
	{
		//A completer (sauvegarde sur pase quand la taille de la liste =10)
	}
	*/
}
