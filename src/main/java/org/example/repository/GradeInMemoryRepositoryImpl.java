package org.example.repository;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.example.exception.GradeNotFoundException;
import org.example.model.Grade;

public class GradeInMemoryRepositoryImpl implements GradeRepository {

  private List<Grade> gradeList =
          List.of(
                  new Grade("UNIDAD 1", 4.5D, LocalDate.of(2023, Month.AUGUST, 1)),
                  new Grade("UNIDAD 2", 5D, LocalDate.of(2023, Month.SEPTEMBER, 1)),
                  new Grade("UNIDAD 3", 3.6D, LocalDate.of(2023, Month.OCTOBER, 1)),
                  new Grade("UNIDAD 4", 3.6D, LocalDate.of(2023, Month.OCTOBER, 10)));


  @Override
  public List<Grade> findAllGrades() {
    return gradeList;
  }

  @Override
  public Grade getGrade(String unidad)throws GradeNotFoundException {
    var grade = this.gradeList.stream().filter( p->p.project().equals( unidad ) ).findAny();

    if(!grade.isPresent()){
      throw new GradeNotFoundException();
    }

    return grade.get();
  }


}
