package config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.IDAOAdresse;
import dao.IDAOCompte;
import dao.IDAOMedecin;
import dao.IDAOPatient;
import dao.IDAOSecretaire;
import dao.IDAOVisite;
import dao.jpa.DAOAdresseJPA;
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
	private IDAOAdresse daoAdresse = new DAOAdresseJPA();
	
	
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

	public static Context get_instance() {
		return _instance;
	}

	public static void set_instance(Context _instance) {
		Context._instance = _instance;
	}

	public IDAOCompte getDaoCompte() {
		return daoCompte;
	}

	public void setDaoCompte(IDAOCompte daoCompte) {
		this.daoCompte = daoCompte;
	}

	public IDAOMedecin getDaoMedecin() {
		return daoMedecin;
	}

	public void setDaoMedecin(IDAOMedecin daoMedecin) {
		this.daoMedecin = daoMedecin;
	}

	public IDAOSecretaire getDaoSecretaire() {
		return daoSecretaire;
	}

	public void setDaoSecretaire(IDAOSecretaire daoSecretaire) {
		this.daoSecretaire = daoSecretaire;
	}

	public IDAOVisite getDaoVisite() {
		return daoVisite;
	}

	public void setDaoVisite(IDAOVisite daoVisite) {
		this.daoVisite = daoVisite;
	}

	public IDAOPatient getDaoPatient() {
		return daoPatient;
	}

	public void setDaoPatient(IDAOPatient daoPatient) {
		this.daoPatient = daoPatient;
	}

	public IDAOAdresse getDaoAdresse() {
		return daoAdresse;
	}

	public void setDaoAdresse(IDAOAdresse daoAdresse) {
		this.daoAdresse = daoAdresse;
	}

	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}


	
}
