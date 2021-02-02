package ProjetAJC.ProjetAJCSpringBoot.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("salarie")
public class Employe  extends Compte{
	@ManyToOne
	@JoinColumn(name = "mgr")
	private Employe manager;

	public Employe() {
	
	}

	public Employe(Integer id, String mail, String password, String nom, String prenom, Service service) {
		super(id, mail, password, nom, prenom, service);
		// TODO Auto-generated constructor stub
	}

	public Employe(String mail, String password, String nom, String prenom, Service service) {
		super(mail, password, nom, prenom, service);
		// TODO Auto-generated constructor stub
	}

}
