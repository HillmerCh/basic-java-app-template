package org.example.exception;

import java.text.MessageFormat;

//Esta es una checked exception
public class GradeNotFoundException extends Exception{

	public GradeNotFoundException(String nombreProyecto) {
		super( MessageFormat.format( "No se encontro la nota para el proyecto {0}", nombreProyecto ) );
	}
}
