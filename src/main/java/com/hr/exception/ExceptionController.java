package com.hr.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {


    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ExceptionMessage> handleException(){
        return new ResponseEntity<>(new ExceptionMessage(""), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundApplicantException.class)
    protected ResponseEntity<ExceptionMessage> handleNotFoundApplicantException(){
        return new ResponseEntity<>(new ExceptionMessage("Претендента в базе не обнаружено!"), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NotFoundPersonException.class)
    protected ResponseEntity<ExceptionMessage> handleNotFoundPersonException(){
        return new ResponseEntity<>(new ExceptionMessage("Указанная персона не найдена!"), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NotFoundVacancyException.class)
    protected ResponseEntity<ExceptionMessage> handleNotFoundVacancyException(){
        return new ResponseEntity<>(new ExceptionMessage("Указанная вакансии не найдено!"), HttpStatus.NOT_FOUND);
    }

    @Data
    @AllArgsConstructor
    private static class ExceptionMessage{
        private String error;
    }
}
