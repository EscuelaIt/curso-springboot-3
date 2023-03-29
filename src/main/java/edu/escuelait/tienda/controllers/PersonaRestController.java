package edu.escuelait.tienda.controllers;

import edu.escuelait.tienda.domain.Persona;
import edu.escuelait.tienda.exceptions.PersonaNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/personas")
public class PersonaRestController {

    //Almacen para tener un lote de datos prueba
    ArrayList<Persona> personas = new ArrayList<>(
            List.of(new Persona(1L, "Rafael"),
                    new Persona(2L, "Miguel"),
                    new Persona(3L, "Alvaro")));

    @GetMapping("/{id}")
    public ResponseEntity<?> getPersonaById(@PathVariable Long id) {

        //pedido invalido
        if (id < 0) {
            return ResponseEntity.badRequest().build();
        }

        Persona persona = this.personas.stream().filter(per -> id == per.getId()).
                findFirst().orElseThrow(() -> new PersonaNotFoundException("no existe la persona"));

        return ResponseEntity.ok(persona);
    }

    @GetMapping
    public ResponseEntity<?> listPersonas() {

        return ResponseEntity.ok(this.personas);
    }

    @PostMapping
    public ResponseEntity<?> createPersona(@Validated @RequestBody Persona persona) {
        this.personas.add(persona);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(persona.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<?> updatePersona(@RequestBody Persona persona) {

        return this.personas.stream().filter(per -> per.getId() == persona.getId()).
                findFirst().map(per -> {
                    per.setLastName(persona.getLastName());
                    per.setName(persona.getName());
                    //TODO mas atributos
                    return ResponseEntity.ok(per);
                }).orElseThrow(() -> new PersonaNotFoundException("No se encontro la persona"));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePersona(@PathVariable Long id) {

        return this.personas.stream().filter(persona -> id == persona.getId()).
                findFirst().map(persona -> {
                            this.personas.remove(persona);
                            return ResponseEntity.noContent().build();
                        }
                ).orElseThrow(() -> new PersonaNotFoundException("no existe la persona"));

    }


}
