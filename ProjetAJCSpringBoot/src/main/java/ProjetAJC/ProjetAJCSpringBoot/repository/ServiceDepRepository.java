package ProjetAJC.ProjetAJCSpringBoot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ProjetAJC.ProjetAJCSpringBoot.entity.ServiceDep;



public interface ServiceDepRepository  extends JpaRepository<ServiceDep, Integer> {
	
	
	@Query("from Service e where e.login like :filter")
	public List<ServiceDep> findAllFilter(@Param("filter") String name);

}
