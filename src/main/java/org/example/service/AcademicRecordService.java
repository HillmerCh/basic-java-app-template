package org.example.service;

import org.example.exception.GradeNotFoundException;
import org.example.model.Grade;

public interface AcademicRecordService {
  Double calculateAverage();

  Integer sumNumberOfGrades();


  Grade getGrade(String unidad) throws GradeNotFoundException;
}
