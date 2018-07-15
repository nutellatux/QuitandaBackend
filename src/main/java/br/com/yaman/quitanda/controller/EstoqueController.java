package br.com.yaman.quitanda.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "estoque")
public abstract class EstoqueController extends CrudControllerBase {
	
//	@Autowired
//	private ProdutoBusiness business;
//
//	@Override
//	public GenericCrudBusiness<Produto> getBusinessClass() {		
//		return business;
//	}

}
