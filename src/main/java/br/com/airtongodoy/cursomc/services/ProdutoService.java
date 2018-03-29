package br.com.airtongodoy.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.airtongodoy.cursomc.domain.Produto;
import br.com.airtongodoy.cursomc.repositories.ProdutoRepository;
import br.com.airtongodoy.cursomc.services.exception.ObjectNotFoundException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepositoryProxy;
	
	public Produto buscarProdutoPorId(Integer idProduto) {
		
		Optional<Produto> produto = produtoRepositoryProxy.findById(idProduto);
		
		return produto.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + idProduto + ", Tipo: " + Produto.class.getName()));
	}
}
