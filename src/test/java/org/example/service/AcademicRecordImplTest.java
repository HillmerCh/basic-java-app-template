package org.example.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.example.repository.GradeInMemoryRepositoryImpl;

import static org.junit.jupiter.api.Assertions.*;
class AcademicRecordImplTest {

	private AcademicRecord academicRecord;

	@BeforeEach
	void setUp() {
		this.academicRecord = new AcademicRecordImpl( new GradeInMemoryRepositoryImpl() );
	  }

	@Test
	void calculateAverage() {

	  }

	@Test
	void summation_of_number_of_grades_should_return_a_valid_number() {
		Integer numberOfGrades = this.academicRecord.sumNumberOfGrades();

		assertNotNull( numberOfGrades );
	  }
}
