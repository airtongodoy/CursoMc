package br.com.airtongodoy.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.airtongodoy.cursomc.domain.Cidade;
import br.com.airtongodoy.cursomc.repositories.CidadeRepository;
import br.com.airtongodoy.cursomc.services.exception.ObjectNotFoundException;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository cidadeRepositoryProxy;
	
	public Cidade buscarCidadePorId(Integer idCidade) {
		
		Optional<Cidade> cidade = cidadeRepositoryProxy.findById(idCidade);
		
		return cidade.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado Id: " + idCidade + ", Tipo: " + Cidade.class.getName()));
	}
}
