package edu.escuelait.tienda.domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import edu.escuelait.tienda.validators.Cuit;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDate;

@Data
public class Persona {


    @NonNull
    private Long id;

    @NonNull //Lombok, y es para hacer el atributo mandatorio en el constructor
    private String name;

    private String lastName;

    @Size(min = 3, max = 6)
    private String domicilio;

    @Min(18)
    @Max(80)
    private int edad;

    @AssertFalse
    //@AssertTrue
    private boolean casado;

    @Email
    @JsonIgnore
    private String mail;

    @Positive
    //@PositiveOrZero
    private int puntuacion;

    @Negative
    //@NegativeOrZero
    private int ranking;

    @Past
    //@PastOrPresent
    private LocalDate fechaNacimiento;

    @FutureOrPresent
    //@Future
    private LocalDate registro;

    //Custom validators
    @Cuit
    private String cuit;

}
