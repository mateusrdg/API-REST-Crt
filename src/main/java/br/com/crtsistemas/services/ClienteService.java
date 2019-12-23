package br.com.crtsistemas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.crtsistemas.domain.Cliente;
import br.com.crtsistemas.repository.ClienteRepository;
import br.com.crtsistemas.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		Cliente cliente = obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
		return cliente;
	}
	
	public List<Cliente> findAll() {
		return repo.findAll();
	}
	
}	
