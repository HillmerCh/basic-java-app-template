package org.example.repository;

import java.util.List;
import java.util.Optional;

import org.example.model.Grade;

public interface GradeRepository {

  List<Grade> findAllGrades();

  Optional<Grade> getGrade(String unidad);

	Grade addGrade(Grade newGrade);
}
