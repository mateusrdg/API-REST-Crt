package br.com.crtsistemas.repository;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.crtsistemas.domain.Cliente;
import br.com.crtsistemas.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

//	@Query("SELECT FIRST obj.valor FROM ItemPedido obj INNER JOIN obj.pedido.cliente cli  WHERE pe IN :pessoaEnderecos")
//	BigDecimal findDistinctByPessoaEndereco(@Param("pessoaEnderecos") List<PessoaEndereco> enderecos);

	@Query("SELECT FIRST ip.valor FROM ItemPedido ip  WHERE ip.pedido.cliente = :cliente AND obj.produto = :produto")
	Optional<BigDecimal> findUltimoValorVendaPorCliente(@Param("cliente") Cliente cliente, @Param("produto") Produto produto);

	@Query("SELECT p.valorVenda FROM Produto p WHERE p = :produto")
	BigDecimal getValorVenda( @Param("produto") Produto produto);

}
