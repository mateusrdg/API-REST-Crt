package br.com.crtsistemas.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.crtsistemas.domain.Cliente;
import br.com.crtsistemas.domain.Produto;
import br.com.crtsistemas.dto.ValorVendaDTO;
import br.com.crtsistemas.services.ProdutoService;

@RestController
@RequestMapping(value = "/clientes")
public class ProdutoResource {
	
	@Autowired 
	private ProdutoService service;
		
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Produto> find(@PathVariable Integer id){
		Produto obj = service.find(id);
		return ResponseEntity.ok(obj);
	}
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Produto>> findAll() {
		List<Produto> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ValorVendaDTO> findBy(@PathVariable Integer id){
		Produto p = new Produto(id);
		Cliente c = new Cliente(id);
		ValorVendaDTO obj = new ValorVendaDTO(service.getUltimoValorVendaPorCliente(c,p));
		return ResponseEntity.ok(obj);
	}
	
	@RequestMapping(value = "/page", method=RequestMethod.GET)
	public ResponseEntity<Page<Produto>> findPage(
			@RequestParam(value="page",defaultValue = "0") Integer page, 
			@RequestParam(value="linesPerPage",defaultValue = "24") Integer linesPerPage, 
			@RequestParam(value="orderBy",defaultValue = "nome") String orderBy, 
			@RequestParam(value="direction",defaultValue = "ASC") String direction) {
		Page<Produto> list = service.findPage(page, linesPerPage, orderBy, direction);
		//Page<ClienteDTO> listDto = list.map(obj -> new ClienteDTO(obj));
		return ResponseEntity.ok().body(list);
	}
}
