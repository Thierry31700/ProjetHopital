package ProjetAJC.ProjetAJCSpringBoot.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import ProjetAJC.ProjetAJCSpringBoot.service.CompteDetailsService;


@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CompteDetailsService compteDetailsService;

	@Configuration
	@Order(1)
	public class SiteJavaSecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		//activation des restcontroller
			
		http.authorizeRequests()
				.antMatchers("/","/css/**").permitAll()
				.anyRequest().authenticated()
				.and()
				.formLogin()
					.loginPage("/accueil")
					.defaultSuccessUrl("/home")
					.failureUrl("/accueil?error")
					.permitAll()
				.and()
				.logout()
					.logoutUrl("/logout")
					.logoutSuccessUrl("/bye")
					.permitAll();
		// @formatter:on
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(compteDetailsService);
	 }
	}
	@Configuration
	@Order(2)
	public class RestControllerSecurityConfig extends WebSecurityConfigurerAdapter {
		@Autowired
		private CompteDetailsService compteDetailsService;

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			//@// @formatter:off		
				//activation des restcontroller
				http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
					.and()
					.authorizeRequests().antMatchers(HttpMethod.OPTIONS).anonymous()
					.and()
					.csrf().disable().authorizeRequests()
						.antMatchers("/api/**").authenticated()
						.and().httpBasic();
				// @formatter:on
		}
		
		@Override
		public void configure(WebSecurity web) throws Exception {
			web.ignoring().antMatchers("/api/creation","/api/creation/**");
		}

		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(compteDetailsService);
		}
	}
	

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	 }
	}
