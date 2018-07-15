package br.com.yaman.quitanda.repository;


import java.util.List;

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
public interface ProdutoRepository extends JpaCustomRepository<Produto> {
	
	@Query(value = "SELECT prod FROM Produto prod order by id ")
	List<Produto> listProdutoOrderByCodigoProduto();
	
	
}
