package br.com.airtongodoy.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.airtongodoy.cursomc.domain.Produto;
import br.com.airtongodoy.cursomc.repositories.ProdutoRepository;

public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepositoryProxy;
	
	public Produto buscarProdutoPorId(Integer idProduto) {
		
		Optional<Produto> produto = produtoRepositoryProxy.findById(idProduto);
		
		return produto.orElse(null);
		
	}
}
