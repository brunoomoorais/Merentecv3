package br.etec.merenda.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import br.etec.merenda.repositories.UsuarioRepository;
import br.etec.merenda.security.JWTAuthenticationFilter;
import br.etec.merenda.security.JWTAuthorizationFilter;
import br.etec.merenda.security.JWTUtil;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private JWTUtil jwtUtil;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private UsuarioRepository usuRepo;	

	//LIBERAR ROTAS
	private static final String[] PUBLIC_MATCHERS = {
			"/api/pratos/**",
			"/api/cardapios/**",
			"/api/usuarios/**"
	};

	private static final String[] PUBLIC_MATCHERS_POST = {
			"/api/pratos/**",
			"/api/cardapios/**",
			"/api/usuarios/**"
			};

	private static final String[] PUBLIC_MATCHERS_SWAGGER = {
			"/v3/api-docs/**",
			"/swagger-ui/**",
			"/swagger-ui.html/**"
			};
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//http.cors().and().csrf().disable();
		http.cors().disable();
		http.csrf().disable();
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.authorizeRequests()
			.antMatchers(HttpMethod.GET, PUBLIC_MATCHERS).permitAll()
			.antMatchers(PUBLIC_MATCHERS_SWAGGER).permitAll()
			.antMatchers(HttpMethod.POST, PUBLIC_MATCHERS_POST).permitAll()
			.anyRequest().authenticated();
		http.addFilter(new JWTAuthenticationFilter(authenticationManager(),
				jwtUtil, usuRepo));
		http.addFilter(new JWTAuthorizationFilter(authenticationManager(), jwtUtil,
				userDetailsService));
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {	
		auth.userDetailsService(userDetailsService)
		    .passwordEncoder(bCryptPasswordEncoder());
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
		return source;
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
