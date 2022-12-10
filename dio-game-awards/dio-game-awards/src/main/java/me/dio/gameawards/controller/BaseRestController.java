package me.dio.gameawards.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import exception.BusinessException;
import exception.NoContentException;
import me.dio.gameawards.dto.ApiErrorDTO;


@RequestMapping("/api")
public abstract class BaseRestController {
    
	@ExceptionHandler(NoContentException.class)
	public ResponseEntity<Void> handlerNoContent(NoContentException exception){
		return ResponseEntity.noContent().build();
	    
	}
	
	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<ApiErrorDTO> handlerBusinessException(BusinessException exception){
		ApiErrorDTO error = new ApiErrorDTO(exception.getMessage());
		return ResponseEntity.badRequest().body(error);
	    
	}
	
	@ExceptionHandler(Throwable.class)
	public ResponseEntity<ApiErrorDTO> handlerUnexpectedException(BusinessException exception){
		ApiErrorDTO error = new ApiErrorDTO("Ocorreu um erro inesperado");
		return ResponseEntity.internalServerError().body(error);
	    
	}
	
}
