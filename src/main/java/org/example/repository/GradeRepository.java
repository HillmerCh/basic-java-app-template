package org.example.repository;

import java.util.List;

import org.example.exception.GradeNotFoundException;
import org.example.model.Grade;

public interface GradeRepository {

  List<Grade> findAllGrades();

  Grade getGrade(String unidad) throws GradeNotFoundException;

}
