package edu.escuelait.tienda.configurations;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
       info = @Info(
               title = "Tienda Escuela IT API",
               description = "Tienda Escuela IT Microservicio",
               contact = @Contact(
                       name = "Rafael Benedettelli",
                       url = "http://esculeait.com",
                       email = "rblbene@gmail.com"
               ),
               license = @License(
                       name = "MIT Licence",
                       url = "https://github.com/thombergs/code-examples/blob/master/LICENSE")),
       servers = @Server(url = "http://localhost:8080/escuelait/api/v1/endpoints")
)
public class SwaggerConfiguration {

}
