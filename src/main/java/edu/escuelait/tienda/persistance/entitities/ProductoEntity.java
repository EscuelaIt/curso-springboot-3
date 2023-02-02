package edu.escuelait.tienda.persistance.entitities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity(name = "producto")
@Data
@NoArgsConstructor
public class ProductoEntity {


    @NonNull
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    //@Column(name = "nombre")
    @NonNull
    private String name;

    private String description;


}
