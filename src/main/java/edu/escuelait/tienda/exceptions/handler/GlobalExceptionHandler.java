package edu.escuelait.tienda.exceptions.handler;

import edu.escuelait.tienda.exceptions.ProductoNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.net.URI;
import java.time.Instant;


@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


   @ExceptionHandler(ProductoNotFoundException.class)
   ProblemDetail handleBookmarkNotFoundException(ProductoNotFoundException e) {
       ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
       problemDetail.setTitle("Prodcuto Not Found");
       problemDetail.setType(URI.create("http://localhost:8080/escuelait/api/v1/endpoints/not-found"));
       problemDetail.setProperty("errorCategory", "Generic");
       problemDetail.setProperty("timestamp", Instant.now());
       return problemDetail;
   }

}

