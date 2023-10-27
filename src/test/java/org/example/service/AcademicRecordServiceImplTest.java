package org.example.service;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import org.example.model.Grade;
import org.example.repository.GradeInMemoryRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AcademicRecordServiceImplTest {

  private AcademicRecordService academicRecordService;

  @BeforeEach
  void setUp() {
    this.academicRecordService = new AcademicRecordServiceImpl(new GradeInMemoryRepositoryImpl());
  }

  @Test
  void summation_of_number_of_grades_should_return_a_valid_number() {
    Integer numberOfGrades = this.academicRecordService.sumNumberOfGrades();

    assertNotNull(numberOfGrades);
    assertEquals(
        4,
        numberOfGrades); // Debido a que solo son 4 notas definidas en el
                         // GradeInMemoryRepositoryImpl, al realizar la suma el valor debe ser 4
  }

  @Test
  void average_of_grades_should_calculated_successful() {
    /*
     * Las notas actuales defnidas en GradeInMemoryRepositoryImpl son
     * UNIDAD 1 = 4.5
     * UNIDAD 2 = 5
     * UNIDAD 3 = 3.6
     * UNIDAD 4 = 3.6
     *
     * El promedio es 4.175. Este es el valor verificado en el caso de prueba.
     * */
    Double average = this.academicRecordService.calculateAverage();

    assertNotNull(average); // Se verifica que el promedio (average) no sea nulo
    assertEquals(4.175D, average); // Se verifica que el promedio (average) sea igual a 4.175
  }


  @Test
  void a_new_grade_is_added_successful() {
    /*
     * Se adiciona una nueva nota a la lista
     * */
    Grade newGrade = new Grade( "PROJECT FINAL", 5D, LocalDate.now() );
    Grade createdGrade = this.academicRecordService.addGrade(newGrade);

    assertNotNull(createdGrade); // Se verifica que la nota creada no sea nula
    assertEquals(newGrade.grade(), createdGrade.grade()); // Se verifica que el valor de la nota creada sea igual al valor definido
  }

  @Test
  void listing_all_grades_should_be_return_successful() {
    /*
     * Consulta todas las notas
     * */
    List<Grade> grades = this.academicRecordService.listAllGrades();

    assertNotNull(grades); // Se verifica que la lista no sea nula
    assertFalse(grades.isEmpty()); // Se verifica que la lista no sea vacia
    assertEquals(4, grades.size());//Se verifican que esten las 4 notas originalmente definidas UNIDAD 1 , UNIDAD 2 , UNIDAD 3 y UNIDAD 4
  }


}
