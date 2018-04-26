package br.com.airtongodoy.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.airtongodoy.cursomc.domain.Cliente;
import br.com.airtongodoy.cursomc.repositories.ClienteRepository;
import br.com.airtongodoy.cursomc.services.exception.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente findById(Integer idCliente) {
		
		Optional<Cliente> cli = clienteRepository.findById(idCliente);
		
		 //() -> = Representação Lambda - Função vazia recebendo a Exception
		return cli.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + idCliente + ", Tipo: " + Cliente.class.getName()));

	}
	
}
