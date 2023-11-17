package ar.edu.ies6.util;

import java.util.ArrayList;
import java.util.List;

import ar.edu.ies6.model.Alumno;

public class ListadoAlumnos {
	
	private static List<Alumno> listado = new ArrayList<>();
	
	public ListadoAlumnos() {
		// TODO Auto-generated constructor stub
	}

	public static List<Alumno> getListado() {
		return listado;
	}

	public static void setListado(List<Alumno> listado) {
		ListadoAlumnos.listado = listado;
	}
	

}