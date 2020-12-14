package config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class Context {

	
	
	
	private static Context _instance;
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("hopital");


	//private IDAOAlbum daoAlbum= new DAOAlbumJPA();
	//private IDAOBibliotheque daoBibliotheque = new DAOBibliothequeJPA();
	//private IDAOFiche daoFiche = new DAOFicheJPA();
	
	
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
