package br.com.yaman.quitanda.controller;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.yaman.quitanda.business.GenericCrudBusiness;
import br.com.yaman.quitanda.dao.entity.Produto;
import br.com.yaman.quitanda.repository.ProdutoRepository;
import br.com.yaman.quitanda.service.ProdutoServiceImpl;

public abstract class CrudControllerBase<T> {
	private static final Logger LOGGER = LoggerFactory.getLogger(CrudControllerBase.class);
	public static final String JSON = "application/json";

	public abstract GenericCrudBusiness<T> getBusinessClass();

	@Autowired
	private ProdutoServiceImpl produtoServiceImpl;

	@Autowired
	private ProdutoRepository produtoRepository;

	@RequestMapping(value = "/find-one", method = RequestMethod.GET)
	public T findOne(@RequestParam Integer id) {
		return getBusinessClass().findOne(id);
	}

	public Type getClassType() {
		Type mySuperclass = this.getClass().getGenericSuperclass();
		Type tType = ((ParameterizedType) mySuperclass).getActualTypeArguments()[0];
		return tType;
	}

	private Gson getNewGson() {
		return new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX").create();
	}

	// --------------------------------------------------------------------

	@RequestMapping(value = "/find-all", method = RequestMethod.GET)
	public List<Produto> pageLoad() {
		return produtoServiceImpl.findAll();
	}

	@GetMapping
	public List<Produto> listar() {
		return produtoServiceImpl.findAll();
	}

	
	 @GetMapping("/{codigo}")
	 public ResponseEntity<Produto> buscarPeloCodigo(@PathVariable Long codigo) {
		 
	 Produto produto = produtoServiceImpl.findOne(codigo);
	 
	 return produto != null ? ResponseEntity.ok(produto) :
	 ResponseEntity.notFound().build();
	 }

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Produto> criar(@RequestBody Produto produto, HttpServletResponse response) {
		Produto produtoSalva = produtoServiceImpl.save(produto);

		return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalva);
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Produto> atualizar(@PathVariable Long codigo, @Valid @RequestBody Produto produto) {

		Produto produtoSalva = produtoRepository.atualizar(codigo, produto);

		return ResponseEntity.ok(produtoSalva);

	}

	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		produtoRepository.delete(codigo);
	}

}
