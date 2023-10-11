package org.example;

import java.text.MessageFormat;

import org.example.repository.GradeInMemoryRepositoryImpl;
import org.example.service.AcademicRecord;
import org.example.service.AcademicRecordImpl;

public class ApplicationRunner {
	public static void main(String[] args) {

		AcademicRecord academicRecord = new AcademicRecordImpl( new GradeInMemoryRepositoryImpl() );

		System.out.println( MessageFormat.format( "Suma de calificaciones: {0}", academicRecord.sumNumberOfGrades()));

		System.out.println( MessageFormat.format( "Promedio: {0}",academicRecord.calculateAverage()));
  }
}
