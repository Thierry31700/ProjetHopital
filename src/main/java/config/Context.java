package config;

import java.util.LinkedList;

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
import model.Patient;



public class Context {

	private static Context _instance;
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("hopital");


	private IDAOCompte daoCompte= new DAOCompteJPA();
	private IDAOMedecin daoMedecin = new DAOMedecinJPA();
	private IDAOSecretaire daoSecretaire = new DAOSecretaireJPA();
	private IDAOVisite daoVisite = new DAOVisiteJPA();
	private IDAOPatient daoPatient = new DAOPatientJPA();
	private LinkedList<Patient>fileAttente= new LinkedList<>();
	
	
	private Context() {}
	
	public static Context getInstance()
	{
		if(_instance==null) 
		{
			_instance=new Context();
		}
		return _instance;
	}

	public LinkedList<Patient> getFileAttente() {
		return fileAttente;
	}

	public  void  setFileAttente(LinkedList<Patient>fileAttente){
		this.fileAttente=fileAttente;
		
	}
	public EntityManagerFactory getEmf() {
		return emf;
	}
	public void closeEmf() 
	{
		emf.close();
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

	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}


	
}
