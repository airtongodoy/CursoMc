package br.com.airtongodoy.cursomc.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.airtongodoy.cursomc.services.exception.ObjectNotFoundException;

/*
 * Por Default @ControllerAdvice será aplicada para TODAS as classes que usam @Controller (@RestController extends desta também)
 * 	-> Se quiser limitar a algum pacote especifico deve usar @ControllerAdvice("meu.pacote.desejado") ou citar uma classe e ele irá definir o pacote dela como alvo (@ControllerAdvice(basePackageClasses = MinhaClasse.class))
 *  -> Se quiser limitar somente para alguma classe, deve usar assim: @ControllerAdvice(assignableTypes = MinhaClasseRestController.class)
 * 
 */
@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandartError> objectNotFound(ObjectNotFoundException err, HttpServletRequest request) {
		StandartError error = new StandartError(HttpStatus.NOT_FOUND.value(), err.getMessage(), System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
}
