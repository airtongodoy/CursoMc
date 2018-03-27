package br.com.airtongodoy.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.airtongodoy.cursomc.domain.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{
	/*
	 * Para Fixar: 
	 * Quando faz o extends JpaRepository - Automáticamente temos acesso aos métodos principais de acesso a dados no Banco de Dados
	 * Não precisamos implementar e criar médotos desta Interface (CategoriaRepository), ja temos o que precisamos
	 * 
	 * as informações <Categoria, Integer>
	 * Categoria representa o Bean a qual este Repository (DAO) irá tratar
	 * Integer é o Tipo do Atributo ID (Chave definida no Bean com anotação ID) da categoria
	 */
	
}
