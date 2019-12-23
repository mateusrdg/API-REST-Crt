package br.com.crtsistemas.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.crtsistemas.domain.Cliente;
import br.com.crtsistemas.repository.ClienteRepository;
@Service
public class DBService {
	@Autowired
	private ClienteRepository repo;
	
	public void instantiateTestDatabase() {
		Optional<Cliente> cli = repo.findById(5);
		cli.get();
	}
	
}
