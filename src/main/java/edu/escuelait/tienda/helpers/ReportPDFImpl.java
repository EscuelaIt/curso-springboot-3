package edu.escuelait.tienda.helpers;

import edu.escuelait.tienda.domain.Persona;
import edu.escuelait.tienda.stereotypes.Report;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Report
public class ReportPDFImpl {

    public void generatePdfReport(List<Persona> personas) {
      log.info("Generate PDF Report {}", personas);
    }
}
