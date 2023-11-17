package ar.edu.ies6.util;

import java.util.ArrayList;
import java.util.List;

import ar.edu.ies6.model.Docente;

public class ListaDocentes {
    private static List<Docente> listado2 = new ArrayList<>();
	
	public ListaDocentes() {
		// TODO Auto-generated constructor stub
	}

	public static List<Docente> getListado2() {
		return listado2;
	}

	public static void setListado2(List<Docente> listado2) {
		ListaDocentes.listado2 = listado2;
	}

}