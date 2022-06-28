package com.thanura.dep8.advice;

import com.thanura.dep8.service.exception.DuplicateEmailException;
import com.thanura.dep8.service.exception.NotFoundException;
import com.thanura.dep8.service.exception.UnauthorizedAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(DuplicateEmailException.class)
    public String handleDuplicateEmailException(DuplicateEmailException dx){
        dx.initCause(new ResponseStatusException(HttpStatus.CONFLICT,dx.getMessage()));
        return dx.getMessage();
    }
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(NotFoundException.class)
    public String handleUserNotFoundException(NotFoundException nx){
        nx.initCause(new ResponseStatusException(HttpStatus.CONFLICT,nx.getMessage()));
        return nx.getMessage();
    }
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(UnauthorizedAccessException.class)
    public String handleUnauthorizedException(NotFoundException nx){
        nx.initCause(new ResponseStatusException(HttpStatus.FORBIDDEN, nx.getMessage()));
        return nx.getMessage();
    }
}
