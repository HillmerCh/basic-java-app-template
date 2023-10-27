package org.example;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.util.List;

import org.example.exception.GradeNotFoundException;
import org.example.model.Grade;
import org.example.repository.GradeInMemoryRepositoryImpl;
import org.example.service.AcademicRecordService;
import org.example.service.AcademicRecordServiceImpl;


public class ApplicationRunner {
  public static void main(String[] args) {

    AcademicRecordService academicRecordService =
        new AcademicRecordServiceImpl(new GradeInMemoryRepositoryImpl());

    //Disclaimer: Este metodo no sigue el principio SOLID de single responsibility
    System.out.println("Notas iniciales");
    List<Grade> gradeList1 =   academicRecordService.listAllGrades();
    gradeList1.forEach( System.out::println );//Impresion en estilo de programacion funcional


    Grade grade = new Grade( "PARCIAL", 4.5D, LocalDate.now() );
    academicRecordService.addGrade( grade );


    System.out.println("Notas despues de adicionar una nueva");
    List<Grade> gradeList2 =   academicRecordService.listAllGrades();
    gradeList2.forEach( System.out::println );//Impresion en estilo de programacion funcional


    System.out.println(
            MessageFormat.format(
                    "Suma de número calificaciones: {0}", academicRecordService.sumNumberOfGrades()));

    System.out.println(
            MessageFormat.format("Promedio: {0}", academicRecordService.calculateAverage()));


    System.out.println("Consulta una nota de un proyecto que no existe");//El siguiente codigo debe generar una excepcion con el mensaje de "No se encontro"
    String nombreProyecto = "Unidad 10";
    try {
      System.out.println(academicRecordService.getGrade( nombreProyecto ));
    }
    catch (GradeNotFoundException e) {
      System.out.println(MessageFormat.format("No se encontró una nota para la unidad {0} ", nombreProyecto));
    }

  }
}
