package edu.escuelait.tienda.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HolaMundoRestController {

    @GetMapping("/saludo/{user}")
    public String holaMundo(@PathVariable String user) {

        return "Hola Mundo Spring " + user;
    }

}