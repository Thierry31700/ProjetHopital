package ProjetAJC.ProjetAJCSpringBoot.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import ProjetAJC.ProjetAJCSpringBoot.entity.Compte;
import ProjetAJC.ProjetAJCSpringBoot.entity.CompteRole;


public class CompteDetails implements UserDetails {

	
	private Compte compte;
	
	public CompteDetails(Compte compte) {
		super();
		this.compte = compte;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		for (CompteRole uR : compte.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(uR.getRole().toString()));
		}
		return authorities;
	}

	@Override
	public String getPassword() {
		
		return compte.getPassword();
	}

	@Override
	public String getUsername() {
		
		return compte.getMail();
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}

}
