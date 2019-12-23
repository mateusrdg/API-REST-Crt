package br.com.crtsistemas.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.crtsistemas.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Integer>  {

}
