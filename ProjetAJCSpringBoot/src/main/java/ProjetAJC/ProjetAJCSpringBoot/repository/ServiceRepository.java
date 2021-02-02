package ProjetAJC.ProjetAJCSpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ProjetAJC.ProjetAJCSpringBoot.entity.Service;

public interface ServiceRepository  extends JpaRepository<Service, Integer> {

}
