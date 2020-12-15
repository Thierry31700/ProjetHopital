package test;

import java.util.Scanner;

import config.Context;
import dao.jpa.DAOCompteJPA;
import model.*;


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
		Adresse a2 = new Adresse(2,"rue des mésanges","Toulouse",31000);

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

		String login="Anna";
		String password= "People";
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
		System.out.println("3 - Donnée patient");
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

		int secu=saisieInt("Entrer le numeros de Sécurité Sociale du patient :\n");
		Patient p =Context.get_instance().getDaoPatient().findById(secu);


		if (p==null) {
			p = creaPatient();
		}

		Context.get_instance().getFileAttente().add(p);

		System.out.println("Le patient est ajouté à la liste");

		menuSecretaire();

	}
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
	private static void historiquePatient() {
		

	}

	private static void pause() {
		

	}

	private static void showListeAttente() {
		for(Patient p: Context.get_instance().getFileAttente()) {
			System.out.println(p.getNom()+" "+p.getPrenom()+" "+p.getSecu());
		}

	}

	private static void ouvertureSalle() {
		// TODO Auto-generated method stub

	}

	private static void donneePatient() {
		// TODO Auto-generated method stub

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
