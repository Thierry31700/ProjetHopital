package config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.IDAOCompte;
import dao.IDAOMedecin;
import dao.IDAOPatient;
import dao.IDAOSecretaire;
import dao.IDAOVisite;
import dao.jpa.DAOCompteJPA;
import dao.jpa.DAOMedecinJPA;
import dao.jpa.DAOPatientJPA;
import dao.jpa.DAOSecretaireJPA;
import dao.jpa.DAOVisiteJPA;



public class Context {

	
	
	
	private static Context _instance;
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("hopital");


	private IDAOCompte daoCompte= new DAOCompteJPA();
	private IDAOMedecin daoMedecin = new DAOMedecinJPA();
	private IDAOSecretaire daoSecretaire = new DAOSecretaireJPA();
	private IDAOVisite daoVisite = new DAOVisiteJPA();
	private IDAOPatient daoPatient = new DAOPatientJPA();
	
	private Context() {}
	
	public static Context getInstance()
	{
		if(_instance==null) 
		{
			_instance=new Context();
		}
		return _instance;
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}
	public void closeEmf() 
	{
		emf.close();
	}


	
}
