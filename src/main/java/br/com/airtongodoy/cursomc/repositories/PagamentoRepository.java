package br.com.airtongodoy.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.airtongodoy.cursomc.domain.Pagamento;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer>{
	/*
	 * Para Fixar: 
	 * Quando faz o extends JpaRepository - Automáticamente temos acesso aos métodos principais de acesso a dados no Banco de Dados
	 * Não precisamos implementar e criar médotos desta Interface (PagamentoRepository), ja temos o que precisamos
	 * 
	 * as informações <Pagamento, Integer>
	 * Pagamento representa o Bean a qual este Repository (DAO) irá tratar (Deve o mesmo ser uma Entity)
	 * Integer é o Tipo do Atributo ID (Chave definida no Bean com anotação ID) do Pagamento
	 */
}
