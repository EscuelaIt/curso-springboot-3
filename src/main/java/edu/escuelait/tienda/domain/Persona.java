package edu.escuelait.tienda.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import edu.escuelait.tienda.validators.Cuit;
import edu.escuelait.tienda.validators.groups.OnCreate;
import edu.escuelait.tienda.validators.groups.OnUpdate;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NonNull;

@Schema(description = "Esta es una Persona...")
@Data
@JsonPropertyOrder({"nombre", "edad", "id", "domicilio", "casado", "cuit"})
public class Persona {


    @NonNull
    @Schema(description = "Identificador único de persona.", example = "1")
    private Long id;

    @NonNull //Lombok, y es para hacer el atributo mandatorio en el constructor
    @JsonProperty("nombre")
    private String name;

    @JsonIgnore
    @NotNull(groups = OnCreate.class) //Valor si o si
    private String lastName;

    @NotBlank(groups = OnUpdate.class)
    @Size(min = 3, max = 6)
    private String domicilio;

    @Min(18)
    @Max(80)
    private int edad;

    @AssertFalse
    //@AssertTrue
    private boolean casado;

    @Cuit
    private String cuit;

/*
    @Email
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
*/
    //España NIF
    //Arg CUIT


}
