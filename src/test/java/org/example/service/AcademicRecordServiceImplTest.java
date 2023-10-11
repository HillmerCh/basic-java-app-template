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
  void calculateAverage() {}

  @Test
  void summation_of_number_of_grades_should_return_a_valid_number() {
    Integer numberOfGrades = this.academicRecordService.sumNumberOfGrades();

    assertNotNull(numberOfGrades);
  }
}
