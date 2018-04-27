package br.com.airtongodoy.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.airtongodoy.cursomc.domain.Pedido;
import br.com.airtongodoy.cursomc.services.PedidoService;

@RestController
@RequestMapping(value="/pedidos")
public class PedidoResource {
	
	@Autowired
	private PedidoService pedidoServiceProxy;
	
	@RequestMapping(value="/{id}")
	public ResponseEntity<?> listarPedidos(@PathVariable Integer id){
		
		Pedido pedido = pedidoServiceProxy.findPedidoByID(id);
		
		return ResponseEntity.ok().body(pedido);
	}

}
