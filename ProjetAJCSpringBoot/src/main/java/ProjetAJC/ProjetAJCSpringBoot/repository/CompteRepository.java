package ProjetAJC.ProjetAJCSpringBoot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ProjetAJC.ProjetAJCSpringBoot.entity.Compte;

public interface CompteRepository extends JpaRepository<Compte, Integer> {

	@Query("select c from Compte c left join fetch c.roles where c.mail=:mail")
	
	public Optional<Compte> findByMailWithRoles(@Param("mail") String mail);
}
