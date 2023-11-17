package ar.edu.ies6.controller;

import ar.edu.ies6.model.Alumno;
import ar.edu.ies6.service.AlumnoService;
import ar.edu.ies6.util.ListadoAlumnos;
import ch.qos.logback.core.model.Model;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AlumnoController {
	@Autowired
	Alumno alu;
	
	@Autowired
	AlumnoService alumnoService;
	
	@GetMapping({"/index"})
	public String index(Model model) {
		return "index";
	}

	@GetMapping({"/alumno"})
	public ModelAndView cargarAlumno() {
		
		//alu.setFechaNac(LocalDate.of(1988, 8, 20));
		//System.out.println("Edad: "+alu.obtenerEdad());
		
		ModelAndView modelView = new ModelAndView ("alumno");
		modelView.addObject("alumno", alu);
		
		return modelView;	
	}
	
	@PostMapping("/cargarAlumno")
    public ModelAndView cargarAlumno(@ModelAttribute Alumno alumno) {
		
		//ListadoAlumnos.getListado().add(alumno);
		alumnoService.guardarAlumno(alumno);
        ModelAndView modelView = new ModelAndView ("listadoAlumnos");
		//modelView.addObject("listado", ListadoAlumnos.getListado());
        modelView.addObject("listado", alumnoService.buscarTodosAlumnos());
		return modelView;	
	}
	
	//Metodo para eliminar un registro
	@GetMapping("/eliminarAlumno/{dni}")
	public String eliminarAlumno(@PathVariable Integer dni) throws Exception {
		alumnoService.eliminarAlumno(dni);
		
		return "redirect:/mostrarListado";	
	}
	
	@GetMapping("/mostrarListado")
	public ModelAndView mostrarAlumnos(){

		ModelAndView listado = new ModelAndView("listadoAlumnos");
		listado.addObject("listado", alumnoService.buscarTodosAlumnos());
		//listado.addObject("listado", ListadoAlumnos.getListado());
		
		return listado;	
	}
	
	//Metodo para modificar alumno
	@GetMapping("/modificarAlumno/{dni}")
	public ModelAndView modificarAlumno(@PathVariable Integer dni) throws Exception {
		
		//modifica un alumno (dni)
		ModelAndView modificaAlumno = new ModelAndView("alumno");
		modificaAlumno.addObject("alumno", alumnoService.encontrarUnAlumno(dni));
		
		return modificaAlumno;	
	}
	
	@PostMapping("/modificarAlumno")
    public ModelAndView modificarUnAlumno(@ModelAttribute("alumno") Alumno alumno) {
		
        alumnoService.guardarAlumno(alumno);
        ModelAndView modelView = new ModelAndView ("listadoAlumnos");
		
        modelView.addObject("listado", alumnoService.buscarTodosAlumnos());
		return modelView;	
	}
	
}