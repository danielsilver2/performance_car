package br.univille.projetoperformance.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.projetoperformance.model.Client;
import br.univille.projetoperformance.repository.ClientRepository;

@RestController
@RequestMapping("/api/clients")
public class ClientControllerAPI {
	@Autowired
	private ClientRepository clientRepository;
	
	@GetMapping
	public ResponseEntity<List<Client>> listClients() {
		List<Client> list = clientRepository.findAll();
		return new ResponseEntity<List<Client>>(list, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Client client) {
		clientRepository.save(client);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping(path="/{id}")
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Client newClient) {
		Optional<Client> oClient = clientRepository.findById(id);
		if (!oClient.isPresent()) 
			return ResponseEntity.notFound().build();
		
		Client oldClient = oClient.get();
		
		oldClient.setName(newClient.getName());
		oldClient.setPhone(newClient.getPhone());
				
		clientRepository.save(oldClient);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
		Optional<Client> oClient = clientRepository.findById(id);
		if (!oClient.isPresent()) 
			return ResponseEntity.notFound().build();
				
		clientRepository.delete(oClient.get());
		return ResponseEntity.ok().build();
	}
}
