package ProjetAJC.ProjetAJCSpringBoot.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ProjetAJC.ProjetAJCSpringBoot.entity.Conge;

public interface CongeRepository  extends JpaRepository<Conge, Integer> {

	
	@Query("from Conge e where e.dateDebut >= :dateDebut and e.dateFin <= :dateFin")
	public List<Conge> findAllFilterByDate(@Param("dateDebut")LocalDate dateDebut,@Param("dateFin") LocalDate dateFin);
	
	@Query("Select c from Conge c left join c.employe s left join s.service b where s.id=c.employe and b.id=:id")
	public List<Conge> findAllFilterByService(@Param("id")Integer id);
	
	@Query("Select c from Conge c left join c.employe s left join s.service b where s.id=c.employe and b.id=:id and c.dateDebut >= :dateDebut and c.dateFin <= :dateFin")
	public List<Conge> findAllFilterByServiceDate(@Param("id")Integer id,@Param("dateDebut") LocalDate dateDebut,@Param("dateFin") LocalDate dateFin);
		
	@Query("from Conge c where c.etat='ATTENTE'")
	public List<Conge> demandeAttente();
	
	@Query("Select c from Conge c left join c.employe s where s.id= :id")
	public List<Conge> demandeSalarie(@Param("id")Integer id);
	
}
