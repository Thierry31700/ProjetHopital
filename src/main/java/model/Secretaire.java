package model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Secretaire")
public class Secretaire extends Compte{

	public Secretaire() {
		// TODO Auto-generated constructor stub
	}

	public Secretaire(String login, String password) {
		super(login, password);
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
/*
 	// a integrer dans le menu de App
	public static void ajouterPatientFileAtt()
	{
		//A completer
		//si le patient a un identifiant connu il 
		//integre la file d'attente, sinon il doit 
		//remplir un formulaire=>gerer selon le cas
		
	}
	
	public static void affichEtatFileAtt()
	{
		//A completer: afficher la liste ? elle est censee etre chez le medecin
	}
	
	public static void histoVisiteUnPatient()
	{
		//A completer (select by id)
	}
	
	public static void partirEnPause()
	{
		//A completer (recup liste attente sur txt)
	}	
	*/
}
