package ProjetAJC.ProjetAJCSpringBoot.entity;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="employe")
@SequenceGenerator(name = "seqEmploye", sequenceName = "seq_employe", initialValue = 1, allocationSize = 1)
public class Employe {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqEmploye")
	private Integer id;
	@NotEmpty
	@JsonView(Vue.Common.class)
	private String nom;
	@NotEmpty
	@JsonView(Vue.Common.class)
	private String prenom;
	
	@ManyToOne
	@JoinColumn(name = "mgr")
	@JsonView(Vue.Common.class)
	private Employe manager;
	
	@ManyToOne
	@JoinColumn(name = "Service")
	@JsonView(Vue.Common.class)
	protected ServiceDep service; 
	
	
	@OneToOne
	@JoinColumn(name = "compte")
	@JsonView(Vue.Common.class)
	protected Compte compte;
	
	@Version
	protected int version;

	public Employe() {
	
	}

	public Employe(@NotEmpty String nom, @NotEmpty String prenom, Employe manager, ServiceDep service, Compte compte) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.manager = manager;
		this.service = service;
		this.compte = compte;
	}



	public Employe(@NotEmpty String nom, @NotEmpty String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public ServiceDep getService() {
		return service;
	}


	public void setService(ServiceDep service) {
		this.service = service;
	}
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Employe getManager() {
		return manager;
	}

	public void setManager(Employe manager) {
		this.manager = manager;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employe other = (Employe) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
