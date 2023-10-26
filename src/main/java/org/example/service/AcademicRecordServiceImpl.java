package org.example.service;

import java.util.List;

import org.example.exception.GradeNotFoundException;
import org.example.model.Grade;
import org.example.repository.GradeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AcademicRecordServiceImpl implements AcademicRecordService {

  private static final Logger logger = LoggerFactory.getLogger(AcademicRecordServiceImpl.class);
  private final GradeRepository gradeRepository;

  public AcademicRecordServiceImpl(GradeRepository gradeRepository) {
    this.gradeRepository = gradeRepository;
  }

  @Override
  public Double calculateAverage() {
    logger.info("Calculando el promedio de calificaciones");
    List<Grade> gradeList = this.gradeRepository.findAllGrades();
    return gradeList.stream().mapToDouble( Grade::grade ).average().getAsDouble();
  }

  @Override
  public Integer sumNumberOfGrades() {
    logger.info("Sumando el número de calificaciones");
    List<Grade> gradeList = this.gradeRepository.findAllGrades();
    return gradeList.size();
  }

  @Override
  public Grade getGrade(String unidad) throws GradeNotFoundException {
    return this.gradeRepository.getGrade( unidad );
  }
}
