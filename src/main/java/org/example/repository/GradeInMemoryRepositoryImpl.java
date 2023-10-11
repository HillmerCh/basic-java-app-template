package org.example.repository;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import org.example.model.Grade;

public class GradeInMemoryRepositoryImpl implements GradeRepository {
  @Override
  public List<Grade> findAllGrades() {

    List<Grade> gradeList =
        List.of(
            new Grade("UNIDAD 1", 4.5D, LocalDate.of(2023, Month.AUGUST, 1)),
            new Grade("UNIDAD 2", 5D, LocalDate.of(2023, Month.SEPTEMBER, 1)),
            new Grade("UNIDAD 3", 3.6D, LocalDate.of(2023, Month.OCTOBER, 1)),
            new Grade("UNIDAD 4", 3.6D, LocalDate.of(2023, Month.OCTOBER, 10)));

    return gradeList;
  }
}
