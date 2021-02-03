package ProjetAJC.ProjetAJCSpringBoot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ProjetAJC.ProjetAJCSpringBoot.entity.Employe;


public interface EmployeRepository extends JpaRepository<Employe,Integer> {

	public List<Employe> findByPrenomContaining(String prenom);
	
//	@Query("from Employe e where e.name like :filter")
//	public List<Employe> findAllFilter(@Param("filter")String name);
}
