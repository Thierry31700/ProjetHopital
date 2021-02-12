package ProjetAJC.ProjetAJCSpringBoot.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "compte_role")
@SequenceGenerator(name = "seqCompteRole", sequenceName = "seq_compte_role", initialValue = 10, allocationSize = 1)
public class CompteRole {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCompteRole")
	private Integer id;
	@ManyToOne
	@JoinColumn(name = "compte_id")
	private Compte compte;
	@Enumerated(EnumType.STRING)
	@JsonView(Vue.Common.class)
	private Role role;

	public CompteRole() {

	}

	public CompteRole(Compte compte, Role role) {
		super();
		this.compte = compte;
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
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
		CompteRole other = (CompteRole) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
