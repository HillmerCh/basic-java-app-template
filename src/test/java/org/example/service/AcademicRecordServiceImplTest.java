package org.example.service;

import static org.junit.jupiter.api.Assertions.*;

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
}
