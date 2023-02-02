package edu.escuelait.tienda.configurations;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Data
@Configuration
@ConfigurationProperties(prefix = "tienda")
@PropertySource(value = "classpath:parametros.properties")
public class TiendaParametrosConfig {

    //Se debe aplicar mismo nombre que las claves del application.properties
    private String moneda;
    private String region;


}
