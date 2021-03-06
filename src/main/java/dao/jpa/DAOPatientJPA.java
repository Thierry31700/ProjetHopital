package dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import config.Context;
import dao.IDAOPatient;
import model.Medecin;
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
		EntityManager em=Context.getInstance().getEmf().createEntityManager();

		Query maRequete = em.createQuery("from Patient",Patient.class);

		return maRequete.getResultList();
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
	
	@Override
	public Patient findByIdWithVisites(int secu) {
		EntityManager em=Context.getInstance().getEmf().createEntityManager();

		Query marecherche = em.createQuery("Select p From Patient p Join p.visites where p.secu=:secu",Patient.class);
		
		marecherche.setParameter("secu", secu);
		
		return (Patient) marecherche.getSingleResult();
	}
}