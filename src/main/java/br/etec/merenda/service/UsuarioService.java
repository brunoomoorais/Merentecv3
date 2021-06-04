package br.etec.merenda.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.etec.merenda.exception.AuthorizationException;
import br.etec.merenda.model.Usuario;
import br.etec.merenda.repositories.UsuarioRepository;
import br.etec.merenda.security.JWTUtil;
import br.etec.merenda.security.UserDetailsImpl;

@Service
public class UsuarioService implements ServiceInterface<Usuario>{

	@Autowired
	private UsuarioRepository repository;
	
	@Autowired 
	private BCryptPasswordEncoder passwordEnconder;
	
	@Autowired
	private JWTUtil jwtUtil;
	
	public static UserDetailsImpl authenticated() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			return (UserDetailsImpl) auth.getPrincipal();
		}
		return null;
	}

	public Usuario create(Usuario obj) {
		obj.setSenha(passwordEnconder.encode(obj.getSenha()));
		return repository.save(obj);
	}
	

	@Override
	public Usuario findById(Long id) throws AuthorizationException {
		if(!jwtUtil.authorized(id)) {
			throw new AuthorizationException("Acesso negado!");
		}
		Optional<Usuario> _Usuarioto = repository.findById(id);
		return _Usuarioto.orElse(null);
	}

	@Override
	public List<Usuario> findAll() {	
		return repository.findAll();
	}

	@Override
	public boolean update(Usuario obj) {
		obj.setSenha(passwordEnconder.encode(obj.getSenha()));
		if (repository.existsById(obj.getId())) {
			repository.save(obj);
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(Long id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}
}

