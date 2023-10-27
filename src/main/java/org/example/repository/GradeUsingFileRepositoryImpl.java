package org.example.repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.example.model.Grade;

public class GradeUsingFileRepositoryImpl implements GradeRepository {
  private static final Logger logger = LoggerFactory.getLogger( GradeUsingFileRepositoryImpl.class);
  private List<Grade> gradeList;

  public GradeUsingFileRepositoryImpl() {
    this.gradeList = new ArrayList<>(loadGrades());//Al momento de construir el Repository se cargan los datos desde el archivo
  }

  private List<Grade> loadGrades(){
    logger.info( "Cargando los datos desde archivo" );
    List<String> plainTextGradeList =  readFileWithGrades();
    List<Grade> gradeList = plainTextGradeList.stream().map( this::buildGrade ).toList();
    return gradeList;
  }

  private List<String> readFileWithGrades(){
    //Este método lee el archivo y adiciona cada linea en una posicion de una Lista

    //Para el ejercicio se utiliza la ruta donde se encentra el archivo en el codigo fuente.
    //Este ruta es diferente al momento de empaquetar el proyecto

    Path path = Paths.get( "./src/main/resources/notas.txt");
    try (Stream<String> stream = Files.lines( path)) {
      return stream.toList();
    } catch (IOException x) {
      logger.error("IOException: {0}", x);
    }
    return Collections.emptyList();//Devuelve una lista vacía
  }

  private Grade buildGrade(String plainTextGrade){
    /*Este metodo toma una linea del archivo para generar un vector
   y con dicho vector generar una Nota
     */
    String[] questionArray = plainTextGrade.split(",");//En el archivo las notas vienen separadas por comas por ejemplo: UNIDAD 1,4.5D,2023-08-01

    Grade grade = new Grade( questionArray[0], Double.valueOf(questionArray[1]), LocalDate.parse( questionArray[2], DateTimeFormatter.ISO_DATE));

    return grade;
  }


  @Override
  public List<Grade> findAllGrades() {
    return gradeList;
  }

  @Override
  public Optional<Grade> getGrade(String unidad) {
    return this.gradeList.stream().filter( p->p.project().equals( unidad ) ).findAny();
  }

  @Override
  public Grade addGrade(Grade newGrade) {
    this.gradeList.add( newGrade );

    return this.gradeList.stream()
            .filter( isTheGradeOfTheProject( newGrade ) )//Busca la nota en la lista que corresponda al proyecto de la nota recien creada
            .findAny()
            .orElse( null );//Si no la encuentra devuelve nulo
  }

  private Predicate<Grade> isTheGradeOfTheProject(Grade newGrade) {
    return p -> p.project().equals( newGrade.project() );
  }



}
