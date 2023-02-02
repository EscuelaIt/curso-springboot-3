package edu.escuelait.tienda.configurations;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "app")
public class AppConfig {

    //Se debe aplicar mismo nombre que las claves del application.properties
    private String nombre;
    private String description;
    private String language;
    private String version;


}
