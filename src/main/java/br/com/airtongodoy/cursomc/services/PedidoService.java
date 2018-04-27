package br.com.airtongodoy.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.airtongodoy.cursomc.domain.Pedido;
import br.com.airtongodoy.cursomc.repositories.PedidoRepository;
import br.com.airtongodoy.cursomc.services.exception.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepositoryProxy;
	
	public Pedido findPedidoByID(Integer idPedido) {
		
		Optional<Pedido> pedido = pedidoRepositoryProxy.findById(idPedido);
		
		return pedido.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado, Id: " + idPedido + ", Tipo: " + Pedido.class.getName()));
		//return estado.orElseThrow((() -> new ObjectNotFoundException("Objeto não encontrado, Id: " + idEstado + ", Tipo: " + Estado.class.getName())));
	}
}
