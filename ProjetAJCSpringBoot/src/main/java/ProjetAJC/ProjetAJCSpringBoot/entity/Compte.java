package ProjetAJC.ProjetAJCSpringBoot.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;



@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_compte")
@SequenceGenerator(name = "seqCompte", sequenceName = "seq_compte", initialValue = 1, allocationSize = 1)

public class Compte {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCompte")

	protected Integer id;
	@Column(unique=true)
	protected String mail;
	protected String password,nom,prenom;
	@ManyToOne
	protected Service service; 
	



	@Version
	protected int version;
	@OneToMany(mappedBy = "compte")
	protected Set<CompteRole> roles;
	

	public Compte() {}
	
	


	public Compte(String mail, String password, String nom, String prenom, Service service) {
		this.mail = mail;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.service=service;
	}




	public Compte(Integer id, String mail, String password, String nom, String prenom, Service service) {
		this.id = id;
		this.mail = mail;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.service=service;
	}




	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	public String getMail() {
		return mail;
	}



	public void setMail(String mail) {
		this.mail = mail;
	}



	public int getVersion() {
		return version;
	}



	public void setVersion(int version) {
		this.version = version;
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


	public Service getService() {
		return service;
	}


	public void setService(Service service) {
		this.service = service;
	}
	
	public Set<CompteRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<CompteRole> roles) {
		this.roles = roles;
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
		Compte other = (Compte) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
}
