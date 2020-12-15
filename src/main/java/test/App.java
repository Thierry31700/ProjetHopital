package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import config.Context;
import dao.jpa.DAOCompteJPA;
import model.Adresse;
import model.Compte;
import model.Medecin;
import model.Patient;
import model.Secretaire;
import model.Visite;


public class App {
	public static int saisieInt(String msg) 
	{
		System.out.println(msg);
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}

	public static double saisieDouble(String msg) 
	{
		System.out.println(msg);
		Scanner sc = new Scanner(System.in);
		return sc.nextDouble();
	}


	public static String saisieString(String msg) 
	{
		System.out.println(msg);
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}
	public static void remplissageBase() {


		Medecin  m1 =new Medecin("House","cancer");	
		Medecin  m2 =new Medecin("Dexter","sang");
		Secretaire  s =new Secretaire("Anna","People");

		Context.getInstance().getDaoMedecin().insert(m1);
		Context.getInstance().getDaoMedecin().insert(m2);
		Context.getInstance().getDaoSecretaire().insert(s);

		Adresse a1 = new Adresse(1,"rue des tulipes","Paris",75000);
		Adresse a2 = new Adresse(2,"rue des mesanges","Toulouse",31000);

		Patient  p1 =new Patient(1234, "Caba","Manuel", a1);	
		Patient  p2 =new Patient(5678, "Devillers","Thierry", a2);

		Context.getInstance().getDaoPatient().insert(p1);
		Context.getInstance().getDaoPatient().insert(p2);

	}		
	static Compte connected=null;

	private static void menuAccueil() {
		System.out.println("------------------------------------------------");
		System.out.println("Accueil");

		System.out.println("Se connecter");

		//String login="Anna";
		//String password= "people";
		String login= saisieString("login:");
		String password=saisieString("Password:");
		try {
			connected=DAOCompteJPA.checkConnect(login,password);



			if(connected instanceof Secretaire) 
			{  
				revenirPause();
				menuSecretaire();

			}
			else if(connected instanceof Medecin) 
			{
				menuMedecin();

			}}
		catch(Exception e) {
			System.out.println("Mauvais identifiant");
			menuAccueil();
		}



	}
	private static void revenirPause() {
		
		try {
		File f=new File("listeAttente.txt");
		FileInputStream fis=new FileInputStream(f);
		ObjectInputStream ois=new ObjectInputStream(fis);
		Context.getInstance().setFileAttente((LinkedList<Patient>) ois.readObject());
		}catch(Exception e) {}
	}

	private static void menuMedecin() {

		System.out.println("Bienvenue Docteur");
		System.out.println("Choix du menu :");
		System.out.println("1 - Ouverture de salle");
		System.out.println("2 - Visualisation de la liste d'attente");
		System.out.println("3 - Donnee patient");
		System.out.println("4 - Sauvegarde Liste visite");
		System.out.println("5 - Deconnect");

		try {

			int choix = saisieInt("");
			switch(choix) 
			{
			case 1:ouvertureSalle();break;
			case 2:showListeAttente();break;
			case 3:donneePatient();break;
			case 4:saveListe();break;
			case 5:saveListe();System.exit(0);break;
			}
		}catch(Exception e) {}

		menuMedecin();
	}
	private static void menuSecretaire() {
		System.out.println("Bienvenue");
		System.out.println("Choix du menu :");
		System.out.println("1 - Ajouter Patient");
		System.out.println("2 - Visualisation de la liste d'attente");
		System.out.println("3 - Historique visite patient");
		System.out.println("4 - Partir en pause");
		System.out.println("5 - Deconnect");

		try {

			int choix = saisieInt("");
			switch(choix) 
			{
			case 1:ajoutPatient();break;
			case 2:showListeAttente();break;
			case 3:historiquePatient();break;
			case 4:pause();menuAccueil();break;
			case 5:System.exit(0);break;
			}
		}catch(Exception e) {}

		menuSecretaire();
	}


	private static void ajoutPatient() {
		System.out.println("Espace Patient");

		int secu=saisieInt("Entrer le numeros de Securite Sociale du patient :\n");
		Patient p =Context.getInstance().getDaoPatient().findById(secu);


		if (p==null) {
			p = creaPatient();
		}

		Context.getInstance().getFileAttente().add(p);

		System.out.println("Le patient est ajoute a la liste");

		menuSecretaire();

	}
	//test ok
	private static Patient creaPatient() {
		System.out.println("------------------------------------------------");
		System.out.println("Creation du Compte patient");

		Patient pnew=new Patient();
		Adresse anew= new Adresse();


		int secu=saisieInt("Entrer le numero de secu");
		String nom=saisieString("Entrer le nom");
		String prenom=saisieString("Entrer le prenom");

		System.out.println("Saisir l'adresse du patient");

		int num=saisieInt("Entrer le numero de la voie");
		String voie=saisieString("Entrer la voie");
		String ville=saisieString("Entrer le nom de la ville");
		int cp=saisieInt("Entrer le code postal");

		anew.setNumero(num);
		anew.setVoie(voie);
		anew.setVille(ville);
		anew.setCp(cp);

		pnew.setSecu(secu);
		pnew.setNom(nom);
		pnew.setPrenom(prenom);
		pnew.setAdresse(anew);	

		Context.getInstance().getDaoPatient().insert(pnew);
		return pnew;
	}

	//A tester apres la creation de visites+findByIdWithVisite(secu)
	private static void historiquePatient() {
		int secu=saisieInt("Saisir le numero secu du patient");
		Patient p =Context.getInstance().getDaoPatient().findByIdWithVisites(secu);

		for (Visite v:p.getVisites())
		{
         System.out.println(v);
			}}

	//test Ok
	private static void pause() {
		File f=new File( "listeAttente.txt");
		try (
				FileOutputStream fos=new FileOutputStream(f);
				ObjectOutputStream oos=new ObjectOutputStream(fos);
				)	
		{
			LinkedList<Patient> liste=Context.getInstance().getFileAttente();
			oos.writeObject(liste);
		}
		catch(Exception exception ) 
		{ System.out.println(exception.getMessage());
			exception.printStackTrace();
		}
		
	}
	//test ok
	private static void showListeAttente() {
		for(Patient p: Context.getInstance().getFileAttente()) 
		{
			System.out.println(p.getNom()+" "+p.getPrenom()+" "+p.getSecu());
		}

	}

	private static void ouvertureSalle() {

		System.out.println("Ouverture de salle");
		System.out.println("Quelle salle voulez vous ouvrir?");
		System.out.println("1 - Salle 1");
		System.out.println("2 - Salle 2");
		System.out.println("3 - Retour");
		try {

			int choix = saisieInt("");
			if(choix==1 || choix==2) {
				Patient p= Context.getInstance().getFileAttente().poll();
				Visite v=new Visite(choix, (Medecin) connected,p,LocalDate.now());
				
				((Medecin) connected).getVisites().add(v);
				
				if(((Medecin) connected).getVisites().size()==10) {
					saveListe();
				}
				
				System.out.println(p.getSecu()+" "+p.getNom()+ " "+p.getPrenom());
			}
			else{
				menuMedecin();
				}

			
		}catch(Exception e) {}
	}
		

	//test ok 
	private static void donneePatient() {
		System.out.println("liste des patients:");
		for(Patient p : Context.getInstance().getDaoPatient().findAll()) 
		{
			System.out.println(p.getNom()+" "+p.getPrenom()+" "+p.getSecu());
			
		}
		
		int secu=saisieInt("Entrer le numero de secu du patient :");
		try {
		Patient p=Context.getInstance().getDaoPatient().findByIdWithVisites(secu);
	
	System.out.println("nom:"+p.getNom()+" prenom:"+p.getPrenom()+" numero secu:"+p.getSecu()+" visite(s):"+p.getVisites().size());;
		}catch(Exception exception ) 
		
				{ System.out.println(exception.getMessage());}
	}

	private static void saveListe() {
		for(Visite v : ((Medecin) connected).getVisites()) {
			
			Context.getInstance().getDaoVisite().insert(v);
		}
		((Medecin) connected).getVisites().clear();

	}





	public static void main(String[] args) {
		pause();
		Context.getInstance();
		//remplissageBase();
		menuAccueil();

		Context.getInstance().closeEmf();
	}
}
