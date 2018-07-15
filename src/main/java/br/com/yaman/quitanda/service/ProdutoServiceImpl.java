package br.com.yaman.quitanda.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.yaman.quitanda.controller.CrudControllerBase;
import br.com.yaman.quitanda.dao.entity.Produto;
import br.com.yaman.quitanda.repository.ProdutoRepository;

@Service
public class ProdutoServiceImpl implements ProdutoService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CrudControllerBase.class);

	@Autowired
	private ProdutoRepository repository;

	@Override
	public List<Produto> findAll() {

		try {
			return repository.listProdutoOrderByCodigoProduto();
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return new ArrayList<Produto>();
		}

	}

	@Override
	public Produto save(Produto produto) {
		return repository.save(produto);
	}

	public Produto findOne(Long id) {
		return repository.buscaProdutoPeloCodigo(id);
	}

	@Override
	public void delete(Produto produto) {
		repository.delete(produto);
	}

	@Override
	public Produto findOne(Integer id) {
		return null;
	}

}
