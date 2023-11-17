package ar.edu.ies6.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ar.edu.ies6.model.Docente;

public interface DocenteRepository extends CrudRepository <Docente, Integer>{
	public List<Docente> findByEstado(Boolean estado);
	
}