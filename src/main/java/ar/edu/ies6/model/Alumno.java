package ar.edu.ies6.model;

import java.time.LocalDate;
import java.time.Period;
import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Component
public class Alumno {
	@Column
	private String nombre;
	@Column
	private String apellido;
	@Column
	private String direccionCalle;
	@Column
	private Integer direccionNumero;
	@Column
	private String direccionBarrio;
	@Column
	private String direccionCiudad;
	@Column
	private String direccionLocalidad;
	@Column
	private Integer direccionCP;
	@Id
	//@GenerateValue (strategy = GenerationType.AUTO)
	private Integer dni;
	@Column
	private LocalDate fechaNac;
	@Column
	private String telefono;
	@Column
	private String correoElectronico;
	@Column
	private Boolean estado;
	
	public Alumno() {
		// TODO Auto-generated constructor stub
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccionCalle() {
		return direccionCalle;
	}

	public void setDireccionCalle(String direccionCalle) {
		this.direccionCalle = direccionCalle;
	}

	public Integer getDireccionNumero() {
		return direccionNumero;
	}

	public void setDireccionNumero(Integer direccionNumero) {
		this.direccionNumero = direccionNumero;
	}

	public String getDireccionBarrio() {
		return direccionBarrio;
	}

	public void setDireccionBarrio(String direccionBarrio) {
		this.direccionBarrio = direccionBarrio;
	}

	public String getDireccionCiudad() {
		return direccionCiudad;
	}

	public void setDireccionCiudad(String direccionCiudad) {
		this.direccionCiudad = direccionCiudad;
	}

	public String getDireccionLocalidad() {
		return direccionLocalidad;
	}

	public void setDireccionLocalidad(String direccionLocalidad) {
		this.direccionLocalidad = direccionLocalidad;
	}

	public Integer getDireccionCP() {
		return direccionCP;
	}

	public void setDireccionCP(Integer direccionCP) {
		this.direccionCP = direccionCP;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public LocalDate getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	public Integer obtenerEdad() {
		int edad=0;
		
		LocalDate fechaActual = LocalDate.now();
		Period periodo = Period.between(fechaNac, fechaActual);
		edad = periodo.getYears();
		
		return edad;
	}

}