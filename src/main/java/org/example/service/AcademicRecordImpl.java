package org.example.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.example.model.Grade;
import org.example.repository.GradeRepository;

public class AcademicRecordImpl implements AcademicRecord {

  private static final Logger logger = LoggerFactory.getLogger( AcademicRecordImpl.class);
  private final GradeRepository gradeRepository;

  public AcademicRecordImpl(GradeRepository gradeRepository) {
    this.gradeRepository = gradeRepository;
  }


  @Override
  public Double calculateAverage() {
    return null;
  }

  @Override
  public Integer sumNumberOfGrades() {
    System.out.println("Sumando el número de calificaciones");
    logger.info( "Sumando el número de calificaciones" );
    logger.warn( "Sumando el número de calificaciones" );
    logger.error( "Sumando el número de calificaciones" );

    List<Grade> gradeList = this.gradeRepository.findAllGrades();
    //TODO sum number of grades and return the summation
    return null;
  }
}
