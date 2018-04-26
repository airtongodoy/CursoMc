package br.com.airtongodoy.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.airtongodoy.cursomc.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	/*
	 * Para Fixar: 
	 * Quando faz o extends JpaRepository - Automáticamente temos acesso aos métodos principais de acesso a dados no Banco de Dados
	 * Não precisamos implementar e criar médotos desta Interface (ClienteRepository), ja temos o que precisamos
	 * 
	 * as informações <Cliente, Integer>
	 * Cliente representa o Bean a qual este Repository (DAO) irá tratar (Deve o mesmo ser uma Entity)
	 * Integer é o Tipo do Atributo ID (Chave definida no Bean com anotação ID) do cliente
	 */
}
