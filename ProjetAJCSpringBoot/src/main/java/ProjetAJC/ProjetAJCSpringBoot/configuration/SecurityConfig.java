package ProjetAJC.ProjetAJCSpringBoot.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import ProjetAJC.ProjetAJCSpringBoot.service.CompteDetailsService;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.authorizeRequests().antMatchers(HttpMethod.OPTIONS).anonymous()
		.and()
		.csrf().disable().authorizeRequests()
			.antMatchers("/api/creation","/api/creation/**","/api/**").permitAll()
			.antMatchers("/api/**").authenticated()
			.and().httpBasic();
		
//		http.authorizeRequests()
//				.antMatchers("/","/css/**").permitAll()
//				.anyRequest().authenticated()
//				.and()
//				.formLogin()
//					.loginPage("/accueil")
//					.defaultSuccessUrl("/home")
//					.failureUrl("/accueil?error")
//					.permitAll()
//				.and()
//				.logout()
//					.logoutUrl("/logout")
//					.logoutSuccessUrl("/bye")
//					.permitAll();
		// @formatter:on

	}

	@Autowired
	private CompteDetailsService compteDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(compteDetailsService);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
