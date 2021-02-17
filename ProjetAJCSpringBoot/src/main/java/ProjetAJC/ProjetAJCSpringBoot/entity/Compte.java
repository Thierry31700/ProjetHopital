package ProjetAJC.ProjetAJCSpringBoot.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;







@Entity
@Table(name="compte")
@SequenceGenerator(name = "seqCompte", sequenceName = "seq_compte", initialValue = 1, allocationSize = 1)
public class Compte {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCompte")
	@JsonView(Vue.Common.class)
	protected Integer id;
	@Column(unique=true)
	@JsonView(Vue.Common.class)
	protected String mail;
	@Column(name = "password", length = 200, nullable = false)
	protected String password;
	
	@Version
	protected int version;
	
	@OneToMany(mappedBy = "compte")
	@JsonView(Vue.Common.class)
	protected Set<CompteRole> roles;
	
	
	@OneToOne(mappedBy = "compte")
	private Employe utilisateur;

	public Compte() {}
	
	
	public Compte(String mail, String password) {
		this.mail = mail;
		this.password = password;
	}

	public Compte(Integer id, String mail, String password) {
		this.id = id;
		this.mail = mail;
		this.password = password;

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


	public Set<CompteRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<CompteRole> roles) {
		this.roles = roles;
	}

	public Employe getUtilisateur() {
		return utilisateur;
	}


	public void setUtilisateur(Employe utilisateur) {
		this.utilisateur = utilisateur;
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
