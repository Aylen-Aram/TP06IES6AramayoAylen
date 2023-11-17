package ar.edu.ies6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.ies6.model.Docente;
import ar.edu.ies6.repository.DocenteRepository;

@Service
public class DocenteService {
	
	@Autowired
	DocenteRepository docenteRepository;
	
	public void guardarDocente(Docente docente) {
		docente.setEstado(true);
		docenteRepository.save(docente);
		
	}
	
	public void eliminarDocente(Integer dni) throws Exception {
		Docente auxiliar = new Docente ();
		auxiliar = encontrarUnDocente(dni);
		auxiliar.setEstado(false);
		docenteRepository.save(auxiliar);
		
	}
	
	public List<Docente> buscarTodosDocentes(){
		return (List<Docente>) docenteRepository.findByEstado(true);
	}
	
	public void modificarDocente (Docente docente) {
		
	}
	
	public Docente encontrarUnDocente(Integer dni) throws Exception {
		return docenteRepository.findById(dni).orElseThrow(()-> new Exception("Docente no encontrado"));
	}

}