package br.com.airtongodoy.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.airtongodoy.cursomc.domain.Estado;
import br.com.airtongodoy.cursomc.repositories.EstadoRepository;
import br.com.airtongodoy.cursomc.services.exception.ObjectNotFoundException;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository estadoRepositoryProxy;
	
	public Estado buscarEstadoPorId(Integer idEstado) {
		
		Optional<Estado> estado = estadoRepositoryProxy.findById(idEstado);
		
		return estado.orElseThrow((() -> new ObjectNotFoundException("Objeto não encontrado, Id: " + idEstado + ", Tipo: " + Estado.class.getName())));
	}
}
