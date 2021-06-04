package br.etec.merenda.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.etec.merenda.model.Cardapio;
import br.etec.merenda.model.CardapioPrato;
import br.etec.merenda.service.CardapioService;


@RestController
@RequestMapping("/Cardapios")
public class CardapioController {

	@Autowired
	private CardapioService service;
	
	@GetMapping
	public ResponseEntity<List<Cardapio>> getAll() {		
		return ResponseEntity.ok(service.findAll());
	}

	@GetMapping("/{date}")
	public ResponseEntity<?> get(@PathVariable("date") String date) {
		try
		{
			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
			Date dataFind = formato.parse(date);
			Cardapio _Cardapioto = service.findById(dataFind);
			if (_Cardapioto != null) {
				return ResponseEntity.ok(_Cardapioto);
			}
		}
		catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).build();
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	/*@GetMapping("order/{date}")
	public ResponseEntity<List<Cardapio>> getOrder(@PathVariable("date") String date) {
		try
		{
			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
			Date dataFind = formato.parse(date);
			return ResponseEntity.ok(service.CardapioOrderByDate(dataFind)); 
		}
		catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).build();
		}
	}*/
	
	@GetMapping("order")
	public ResponseEntity<List<Cardapio>> getOrder() {
		try
		{
			Date date = new Date();
			Date dataFind = date;
			return ResponseEntity.ok(service.CardapioOrderByDate(dataFind)); 
		}
		catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).build();
		}
	}

	
	@PostMapping
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<Cardapio> post(@RequestBody Cardapio obj) {		
		return ResponseEntity.ok(service.create(obj));
	}

	
	@PutMapping
	public ResponseEntity<?> put(@RequestBody Cardapio obj) {
		if (service.update(obj)) {
			return ResponseEntity.ok(obj);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	
	@DeleteMapping("/{date}")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<?> delete(@PathVariable("date") String date) {
		try
		{
			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
			Date dataFind = formato.parse(date);
			if (service.delete(dataFind)) {
				return ResponseEntity.ok().build();
			}
		}
		catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).build();
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

}