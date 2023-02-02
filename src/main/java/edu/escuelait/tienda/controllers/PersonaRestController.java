package edu.escuelait.tienda.controllers;

import edu.escuelait.tienda.configurations.AppConfig;
import edu.escuelait.tienda.configurations.TiendaParametrosConfig;
import edu.escuelait.tienda.domain.Persona;
import edu.escuelait.tienda.services.PersonasService;
import edu.escuelait.tienda.validators.groups.OnCreate;
import edu.escuelait.tienda.validators.groups.OnUpdate;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
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
@Tag(name = "API personas",
        description = "CRUD de personas de tienda")
public class PersonaRestController {


    //@Autowired
    PersonasService personasService;

    AppConfig appConfig;

    TiendaParametrosConfig tiendaParametrosConfig;


    //Se recomienda esta inyeccion
    public PersonaRestController(@Lazy PersonasService personasService,
                                       AppConfig appConfig,
                                       TiendaParametrosConfig tiendaParametrosConfig){

        log.info("AppConfig {}", appConfig);
        log.info("tiendaParametrosConfig {}", tiendaParametrosConfig);


        this.personasService = personasService;
    }

    //Almacen para tener un lote de datos prueba
    ArrayList<Persona> personas = new ArrayList<>(
            List.of(new Persona(1L,"Rafael"),
                    new Persona(2L,"Miguel"),
                    new Persona(3L,"Alvaro"),
                    new Persona(4L,"Miguel1"),
                    new Persona(5L,"Alvaro1"),
                    new Persona(6L,"Miguel1"),
                    new Persona(7L,"Alvaro2"),
                    new Persona(8L,"Rafael2"),
                    new Persona(9L,"Miguel2"),
                    new Persona(10L,"Alvaro3"),
                    new Persona(11L,"Miguel3"),
                    new Persona(12L,"Alvaro3"),
                    new Persona(13L,"Miguel4"),
                    new Persona(14L,"Alvaro4"))
    );



    @ApiResponse(responseCode = "200", description = "Operación exitosa")
    @ApiResponse(responseCode = "400", description = "Error de petición")
    @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    @Operation(summary = "Recupera una persona por Id", description = "Recupera una persona dado un id de tipo numérico")
    @GetMapping("/{id}")
    public ResponseEntity<?> getPersonaById(
            @Parameter(description="Id de persona. Valor entero", required=true,example = "1")
            @PathVariable Long id){

        if (id < 0){
            return ResponseEntity.badRequest().build();
        }

        //Recorrer cada persona del array de personas
        for (Persona persona : this.personas ) {
            //buscar cual tiene el id igual al solicitado
            if (persona.getId().equals(id)){
                //retornar es persona
                return ResponseEntity.ok(persona);
            }
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<?> listPersonas(){
        List<Persona> personas = personasService.listAllPersonas();
        return ResponseEntity.ok(personas);
    }

    @PostMapping
    public ResponseEntity<?> createPersona(@RequestBody @Validated(OnCreate.class) Persona persona){

        this.personas.add(persona);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(persona.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<?> updatePersona(@RequestBody @Validated(OnUpdate.class) Persona persona){

        //Recorrer cada persona del array de personas
        for (Persona per : this.personas ) {
            //buscar cual tiene el id igual al solicitado
            if (per.getId().equals(persona.getId())){

               per.setName(persona.getName());
               per.setLastName(persona.getLastName());
               return ResponseEntity.ok(persona);
            }
        }

        return ResponseEntity.notFound().build();

    }



    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePersona(@PathVariable Long id){

        //Recorrer cada persona del array de personas
        for (Persona persona : this.personas ) {
            //buscar cual tiene el id igual al solicitado
            if (persona.getId().equals(id)){
                //borrar la persona
                this.personas.remove(persona);
                return ResponseEntity.noContent().build();
            }
        }

        return ResponseEntity.notFound().build();

    }


    //Modifica solo un atributo del recurso
    @PatchMapping("/{id}")
    public ResponseEntity<?> modificarAtributo(@PathVariable Long id,
                                               String attributeName,String newValue){

        //Recorrer cada persona del array de personas
        for (Persona persona : this.personas ) {
            //buscar cual tiene el id igual al solicitado
            if (persona.getId().equals(id)){
                //borrar la persona
                if (attributeName.equalsIgnoreCase("name")){
                    persona.setName(newValue);
                }else if (attributeName.equalsIgnoreCase("lastName")){
                    persona.setLastName(newValue);
                }

                return ResponseEntity.ok(persona);
            }
        }

        return ResponseEntity.notFound().build();


    }


}
