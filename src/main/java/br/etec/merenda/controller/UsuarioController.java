package br.etec.merenda.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.etec.merenda.exception.AuthorizationException;
import br.etec.merenda.model.Usuario;
import br.etec.merenda.service.UsuarioService;


@RestController
@RequestMapping("api/usuarios")
@CrossOrigin()
public class UsuarioController implements ControllerInterface<Usuario> {

	@Autowired
	private UsuarioService service;
	
	@Override
	@GetMapping
	public ResponseEntity<List<Usuario>> getAll() {		
		return ResponseEntity.ok(service.findAll());
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<?> get(@PathVariable("id") Long id) {
		try {
			Usuario _Usuarioto = service.findById(id);
			if (_Usuarioto != null) {
				return ResponseEntity.ok(_Usuarioto);
			}
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		catch (AuthorizationException e)
		{
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}		
	}

	@Override
	@PostMapping
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<Usuario> post(@RequestBody Usuario obj) {		
		return ResponseEntity.ok(service.create(obj));
	}

	@Override
	@PutMapping
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<?> put(@RequestBody Usuario obj) {
		if (service.update(obj)) {
			return ResponseEntity.ok(obj);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@Override
	@DeleteMapping("/{id}")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		if (service.delete(id)) {
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

}