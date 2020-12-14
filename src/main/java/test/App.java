package test;

import java.util.Scanner;

import config.Context;
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
/*		static Compte connected=null;

		private static void menuAccueil() {
			System.out.println("------------------------------------------------");
			System.out.println("Accueil");
			int choix = saisieInt("Application Bibliotheque\n1: Se connecter\n2: CrÃ©er un Compte");
			switch(choix) {
			case 1:
				String pseudo= saisieString("Pseudo:");
				String password=saisieString("Password:");
				try{
					connected=DAOCompteJPA.checkConnect(pseudo,password); 
					System.out.println(connected);
				}catch(Exception e) {
					System.out.println("Mauvais identifiants");
				}

				if(connected instanceof Secretaire) 
				{
					menuSecretaire();

				}
				else if(connected instanceof Medecin) 
				{
					menuMedecin();

				}
				else 
				{
					menuAccueil();
				}
				break;
			case 2:	creacompte();
			break;

			default: 
				System.out.println("Mauvais choix");
				menuAccueil();
				break;
			}

		}
		private static void creaPatient() {
			System.out.println("------------------------------------------------");
			System.out.println("Creation du Compte");
			int choix = saisieInt("1 : Administrateur\n"
					+ "2 : Utilisateur");
			//switch(choix) {
			case 1:
				Admin anew=new Admin();
				Bibliotheque bnew= new Bibliotheque();
				String pseudo=saisieString("Entrer un pseudo");
				String pass=saisieString("Entrer un password");
				String mail=saisieString("Entrer votre mail");


				anew.setPseudo(pseudo);
				anew.setMail(mail);
				anew.setPassword(pass);
				
				Context.getInstance().getDaoBibliotheque().insert(bnew);

				
				Context.getInstance().getDaoAdmin().insert(anew);break;
			}
			menuAcceuil();
		}*/

	public static void main(String[] args) {
		Context.getInstance();
		remplissageBase();
		
		
		Context.getInstance().closeEmf();
	}
}
