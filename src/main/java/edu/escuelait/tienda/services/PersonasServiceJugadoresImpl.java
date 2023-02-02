package edu.escuelait.tienda.services;

import edu.escuelait.tienda.domain.Persona;
import edu.escuelait.tienda.helpers.ReportPDFImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//@Primary
@Slf4j //Sirve para disponer de un logger (log)
@Lazy
@Service("jugadores")
@ConditionalOnProperty(prefix = "implementacion",value = "personas",havingValue = "jugadores")
public class PersonasServiceJugadoresImpl implements PersonasService{

    //@Autowired
    private ReportPDFImpl reportPDF;


    //Almacen para tener un lote de datos prueba
    ArrayList<Persona> jugadores = new ArrayList<>(
            List.of(new Persona(1L,"Maradona"),
                    new Persona(2L,"Pique"),
                    new Persona(3L,"Levandovski"))
    );

    public PersonasServiceJugadoresImpl(ReportPDFImpl reportPDF){
        this.reportPDF = reportPDF;
        log.info("Ejecutando constructor de PersonasServiceJugadoresImpl");
    }


    @Override
    public List<Persona> listAllPersonas() {
        this.reportPDF.generatePdfReport(this.jugadores);
        return this.jugadores;
    }
}

