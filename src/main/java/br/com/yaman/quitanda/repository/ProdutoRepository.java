package br.com.yaman.quitanda.repository;


import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import br.com.yaman.quitanda.dao.entity.Produto;

/**
 * 
 * @author marcus.martins
 *
 */
@Repository
@Transactional
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	@Query(value = "SELECT prod FROM Produto prod order by id ")
	List<Produto> listProdutoOrderByCodigoProduto();
	
	
	public default Produto atualizar(Long codigo, Produto produto) {
		
		Produto produtoSalva = buscaProdutoPeloCodigo(codigo);
		
		BeanUtils.copyProperties(produto, produtoSalva, "codigo");
		return this.save(produtoSalva);
	}
	
	
	public default Produto buscaProdutoPeloCodigo (Long id) {
			
		Produto produto = this.findOne(id);
		
		return produto;
	}
	
	/*
	 * 	private Pessoa buscaPessoaPeloCodigo(Long codigo) {
		Pessoa pessoaSalva = pessoaRepository.findOne(codigo);
		
		if (pessoaSalva == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return pessoaSalva;
	}
	 * 
	 * 
	 * 
	 */

	
	
}
