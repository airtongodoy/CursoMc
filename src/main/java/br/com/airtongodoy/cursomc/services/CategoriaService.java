package br.com.airtongodoy.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.airtongodoy.cursomc.domain.Categoria;
import br.com.airtongodoy.cursomc.repositories.CategoriaRepository;
import br.com.airtongodoy.cursomc.services.exception.ObjectNotFoundException;

@Service
public class CategoriaService {

	/*@Autowired  instancia automáticamente a classe pelo Spring pelo mecanisco de Injeção de dependencias*/
	@Autowired 
	private CategoriaRepository catRepo;
	
	public Categoria buscarCategoriaPorID(Integer idCategoria) {
		
		Optional<Categoria> cat = catRepo.findById(idCategoria);
		
							 //() -> = Representação Lambda - Função vazia recebendo a Exception
		return cat.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + idCategoria + ", Tipo: " + Categoria.class.getName()));
		
	}
}
