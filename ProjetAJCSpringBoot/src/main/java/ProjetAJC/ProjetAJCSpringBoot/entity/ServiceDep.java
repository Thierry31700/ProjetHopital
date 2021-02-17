package ProjetAJC.ProjetAJCSpringBoot.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@SequenceGenerator(name = "seqServiceDep", sequenceName = "seq_service_dep", initialValue = 1, allocationSize = 1)

public class ServiceDep {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqServiceDep")
	@JsonView(Vue.Common.class)
	private Integer id;
	@JsonView(Vue.Common.class)
	private String libelle;
	
	public ServiceDep() {
	}

	public ServiceDep(Integer id, String libelle) {
		this.id = id;
		this.libelle = libelle;
	}

	public ServiceDep(String libelle) {
		this.libelle = libelle;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
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
		ServiceDep other = (ServiceDep) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
