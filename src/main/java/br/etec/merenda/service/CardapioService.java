package br.etec.merenda.service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.etec.merenda.model.Cardapio;
import br.etec.merenda.model.CardapioPrato;
import br.etec.merenda.repositories.CardapioRepository;

@Service
public class CardapioService {

	@Autowired
	private CardapioRepository repository;
	
	public Cardapio create(Cardapio obj) {
		Date dateObj = obj.getData();
		Calendar cal = Calendar.getInstance(); 
		cal.setTime(dateObj); 
		cal.add(Calendar.DATE, 1);
		obj.setData(cal.getTime());
		
		repository.save(obj);
		
		obj.setData(dateObj);
		
		return obj;
	}
	
	public List<Cardapio> CardapioOrderByDate(Date data)
	{
		return repository.CardapioOrderByDate(data);
	}
	
	public Cardapio findById(Date id) {
		Optional<Cardapio> _Cardapioto = repository.findById(id);
		return _Cardapioto.orElse(null);
	}

	public List<Cardapio> findAll() {	
		return repository.findAll();
	}

	public boolean update(Cardapio obj) {		
		Date dateObj = obj.getData();
		Calendar cal = Calendar.getInstance(); 
		cal.setTime(dateObj); 
		cal.add(Calendar.DATE, 1);
		obj.setData(cal.getTime());
		
		if (repository.existsById(obj.getData())) {
			repository.save(obj);			
			obj.setData(dateObj);
			
			return true;
		}
		return false;
	}

	public boolean delete(Date id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}

}

