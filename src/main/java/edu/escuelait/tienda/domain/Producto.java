package edu.escuelait.tienda.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NonNull;

@Data
public class Producto {

    @NonNull
    private Long id;

    @NonNull
    private String name;

    private String description;


}
