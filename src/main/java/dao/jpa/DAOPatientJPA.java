package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import config.Context;
import dao.IDAOPatient;
import model.Patient;

public class DAOPatientJPA implements IDAOPatient {

	@Override
	public Patient findById(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		Patient p = em.find(Patient.class, id);
		em.close();
		return p;
	}

	@Override
	public List<Patient> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Patient objet) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		em.persist(objet);
		em.getTransaction().commit();
		em.close();
	}


	@Override
	public Patient update(Patient objet) {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		objet=em.merge(objet);
		em.getTransaction().commit();
		em.close();
		return objet;
	}

	@Override
	public void delete(Patient objet) {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		objet=em.merge(objet);

		em.remove(objet);

		em.getTransaction().commit();
		em.close();
	}

	@Override
	public void deleteById(Integer id) {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		Patient p=em.find(Patient.class, id);
		
		em.remove(p);
		
		em.getTransaction().commit();
		em.close();
	}

}
