package br.etec.merenda.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.etec.merenda.model.Usuario;
import br.etec.merenda.repositories.UsuarioRepository;
import br.etec.merenda.security.UserDetailsImpl;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository repo;
	

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Usuario _usuario = repo.findByLogin(login);
		if (_usuario == null) {
			throw new UsernameNotFoundException(login);
		}
		return new UserDetailsImpl(_usuario.getId(), _usuario.getLogin(), 
				_usuario.getSenha(), _usuario.getPerfis());
	}


}
