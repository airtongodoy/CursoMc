package br.com.airtongodoy.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.airtongodoy.cursomc.domain.Categoria;
import br.com.airtongodoy.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired 
	private CategoriaRepository catRepo;
	/*@Autowired  instancia automáticamente a classe pelo Spring pelo mecanisco de Injeção de dependencias*/
	
	public Categoria buscarCategoriaPorID(Integer idCategoria) {
		
		Optional<Categoria> cat = catRepo.findById(idCategoria);
		
		return cat.orElse(null);
		
	}
}
