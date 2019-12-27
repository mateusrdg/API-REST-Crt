package br.com.crtsistemas.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.crtsistemas.domain.Cliente;
import br.com.crtsistemas.domain.Produto;
import br.com.crtsistemas.repository.ProdutoRepository;
import br.com.crtsistemas.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repo;

	public Produto find(Integer id) {
		Optional<Produto> obj = repo.findById(id);
		Produto produto = obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
		return produto;
	}

	public List<Produto> findAll() {
		return repo.findAll();
	}

	public BigDecimal getUltimoValorVendaPorCliente (Cliente cliente, Produto produto) {
		Optional<BigDecimal> valor = repo.findUltimoValorVendaPorCliente(cliente, produto);
		if (valor.isPresent()) {
			return valor.get();
		} else {
			return repo.getValorVenda(produto);
		}
	}

	public Page<Produto> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

}
