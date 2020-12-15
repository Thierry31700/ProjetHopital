package test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
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
		Adresse a2 = new Adresse(2,"rue des m�sanges","Toulouse",31000);

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

		String login="House";
		String password= "cancer";
		//String login= saisieString("login:");
		//String password=saisieString("Password:");
		try {
			connected=DAOCompteJPA.checkConnect(login,password);



			if(connected instanceof Secretaire) 
			{
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
	private static void menuMedecin() {

		System.out.println("Bienvenue Docteur");
		System.out.println("Choix du menu :");
		System.out.println("1 - Ouverture de salle");
		System.out.println("2 - Visualisation de la liste d'attente");
		System.out.println("3 - Donn�e patient");
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
			case 5:System.exit(0);break;
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
			case 4:pause();break;
			case 5:System.exit(0);break;
			}
		}catch(Exception e) {}

		menuSecretaire();
	}


	private static void ajoutPatient() {
		System.out.println("Espace Patient");

		int secu=saisieInt("Entrer le numeros de S�curit� Sociale du patient :\n");
		Patient p =Context.get_instance().getDaoPatient().findById(secu);


		if (p==null) {
			p = creaPatient();
		}

		Context.get_instance().getFileAttente().add(p);

		System.out.println("Le patient est ajout� � la liste");

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

	//A tester apr�s la cr�ation de visites
	private static void historiquePatient() {
		int secu=saisieInt("Saisir le numero secu du patient");
		Patient p =Context.get_instance().getDaoPatient().findById(secu);

		for (Visite v:Context.get_instance().getDaoVisite().findAll())
		{
			if(v.getPatient()==p) 
			{System.out.println(v);
			}}

	}

	//plante (oos.writeObject(liste); apparemment)
	private static void pause() {
		File f=new File( "listeAttente.txt");
		try (
				FileOutputStream fos=new FileOutputStream(f);
				ObjectOutputStream oos=new ObjectOutputStream(fos);
				)	
		{
			LinkedList<Patient> liste=Context.get_instance().getFileAttente();
			oos.writeObject(liste);
		}
		catch(Exception exception ) 
		{
			exception.printStackTrace();
		}
	}
	//test ok
	private static void showListeAttente() {
		for(Patient p: Context.get_instance().getFileAttente()) 
		{
			System.out.println(p.getNom()+" "+p.getPrenom()+" "+p.getSecu());
		}

	}

	private static void ouvertureSalle() {
		// TODO Auto-generated method stub
		//appeler donneePatient(); poll ?
	}

	//test ok sauf adresse visite
	private static void donneePatient() {
		// TODO Auto-generated method stub
		System.out.println("liste des patients:");
		for(Patient p : Context.getInstance().getDaoPatient().findAll()) 
		{
			System.out.println(p.getNom()+" "+p.getPrenom()+" "+p.getSecu());
			
		}
		/*
		int secu=saisieInt("Entrer le numero de s�cu du patient :");
		Patient p=Context.get_instance().getDaoPatient().findById(secu);
		System.out.println("nom:"+p.getNom()+" prenom:"+p.getPrenom()+" numero secu:"+p.getSecu()+" adresse:"+p.getAdresse().getVille()+" visite(s):"+p.getVisite());
	*/
	String nom=saisieString("Entrer le nom du patient :");
	
		for(Patient p1:Context.getInstance().getDaoPatient().findAll())
		{
			if((p1.getNom()).equals(nom)) {
				System.out.println("nom:"+p1.getNom()+" prenom:"+p1.getPrenom()+" numero secu:"+p1.getSecu()+" adresse:"/*+p.getAdresse()+" visite(s):"+p.getVisite()*/);
			}
		}
	}

	private static void saveListe() {
		// TODO Auto-generated method stub

	}





	public static void main(String[] args) {
		Context.getInstance();
		//remplissageBase();
		menuAccueil();

		Context.getInstance().closeEmf();
	}
}
