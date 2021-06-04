package br.etec.merenda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.etec.merenda.model.Prato;
import br.etec.merenda.repositories.PratoRepository;

@Service
public class PratoService implements ServiceInterface<Prato> {

	@Autowired
	private PratoRepository repository;
	
	@Override
	public Prato create(Prato obj) {		
		return repository.save(obj);
	}

	@Override
	public Prato findById(Long id) {
		Optional<Prato> _Pratoto = repository.findById(id);
		return _Pratoto.orElse(null);
	}

	@Override
	public List<Prato> findAll() {	
		return repository.findAll();
	}

	@Override
	public boolean update(Prato obj) {
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

