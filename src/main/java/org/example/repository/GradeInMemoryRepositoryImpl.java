package org.example.repository;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.example.model.Grade;

public class GradeInMemoryRepositoryImpl implements GradeRepository {

  private static final Logger logger = LoggerFactory.getLogger( GradeInMemoryRepositoryImpl.class);

  private List<Grade> gradeList;

  public GradeInMemoryRepositoryImpl() {
    this.gradeList = new ArrayList<>(loadGrades());//Al momento de construir el Repository se cargan los datos "quemados" en la clase
  }

  private List<Grade> loadGrades(){
    logger.info( "Cargando los datos predefinidos " );
    return List.of(
            new Grade("UNIDAD 1", 4.5D, LocalDate.of(2023, Month.AUGUST, 1)),
            new Grade("UNIDAD 2", 5D, LocalDate.of(2023, Month.SEPTEMBER, 1)),
            new Grade("UNIDAD 3", 3.6D, LocalDate.of(2023, Month.OCTOBER, 1)),
            new Grade("UNIDAD 4", 3.6D, LocalDate.of(2023, Month.OCTOBER, 10)));
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
