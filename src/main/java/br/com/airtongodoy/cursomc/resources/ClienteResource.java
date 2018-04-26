package br.com.airtongodoy.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.airtongodoy.cursomc.domain.Cliente;
import br.com.airtongodoy.cursomc.services.ClienteService;

@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {

	@Autowired
	private ClienteService clienteProxy;
	
	/*
	 * @RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> listar(@PathVariable Integer id) {
	ResponseEntity.ok().body(cat);
	 */
	@RequestMapping(value="/{id}")
	public ResponseEntity<?> listarClientes(@PathVariable Integer id){
		
		Cliente  cli = clienteProxy.findById(id);
		
		return ResponseEntity.ok().body(cli);
	}
}
