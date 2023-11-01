package ar.edu.ies6.controller;
import ar.edu.ies6.model.Alumno;
import ar.edu.ies6.util.ListadoAlumnos;
import java.time.LocalDate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class AlumnoController {
	@GetMapping({"/index", "/", "/home", "/alumno"})
	public ModelAndView cargarAlumno() {
		
		Alumno alu = new Alumno ();
		
		alu.setFechaNac(LocalDate.of(1988, 8, 20));
		System.out.println("Edad: "+alu.obtenerEdad());
		
		ModelAndView modelView = new ModelAndView ("index");
		
		modelView.addObject("alumno", alu);
		
		return modelView;	
	}
	
	@PostMapping("/cargarAlumno")
    public ModelAndView cargarAlumno(@ModelAttribute("alumno") Alumno alumno) {
		
		ListadoAlumnos.getListado().add(alumno);
 	
        ModelAndView modelView = new ModelAndView ("listadoAlumnos");
		
		modelView.addObject("listado", ListadoAlumnos.getListado());
		
		return modelView;	
	}
	
	@GetMapping("/eliminarAlumno/{dni}")
	public ModelAndView eliminarAlumno(@PathVariable Integer dni) {
		
		for (int i = 0; i<ListadoAlumnos.getListado().size(); i++) {
			if (ListadoAlumnos.getListado().get(i).getDni().equals(dni))
				ListadoAlumnos.getListado().remove(i);;
		}
		
		ModelAndView modelView = new ModelAndView ("listadoAlumnos");
		
		modelView.addObject("listado", ListadoAlumnos.getListado());
		
		return modelView;	

		}

}
