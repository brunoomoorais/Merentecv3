package br.etec.merenda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.etec.merenda.model.TipoUsuario;
import br.etec.merenda.repositories.TipoUsuarioRepository;

@Service
public class TipoUsuarioService implements ServiceInterface<TipoUsuario> {

	@Autowired
	private TipoUsuarioRepository repository;
	
	@Override
	public TipoUsuario create(TipoUsuario obj) {		
		return repository.save(obj);
	}

	@Override
	public TipoUsuario findById(Long id) {
		Optional<TipoUsuario> _TipoUsuarioto = repository.findById(id);
		return _TipoUsuarioto.orElse(null);
	}

	@Override
	public List<TipoUsuario> findAll() {	
		return repository.findAll();
	}

	@Override
	public boolean update(TipoUsuario obj) {
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

