package ProjetAJC.ProjetAJCSpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ProjetAJC.ProjetAJCSpringBoot.entity.Employe;

public interface EmployeRepository extends JpaRepository<Employe,Integer> {


}
