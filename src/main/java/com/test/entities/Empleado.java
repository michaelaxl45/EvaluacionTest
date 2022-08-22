package com.test.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Empleado")
public class Empleado {

	public String TipoIdentificacion;
	public String NumeroIdentificacion;
	public String CorreoElectronico;
	public String PrimerApellido;
	public String SegundoApellido;
	public String PrimerNombre;
	public String OtroNombre;
	public String PaisEmpleo;
	public String FechaIngreso;
	public String Area;
	public String Estado;
	public String FechaHoraRegistro;

	public Empleado() {

	}

	public Empleado(String tipoIdentificacion, String numeroIdentificacion, String correoElectronico,
			String primerApellido, String segundoApellido, String primerNombre, String otroNombre, 
			String paisEmpleo,
			String fechaIngreso, String area, String estado, String fechaHoraRegistro) {
		super();
		TipoIdentificacion = tipoIdentificacion;
		NumeroIdentificacion = numeroIdentificacion;
		CorreoElectronico = correoElectronico;
		PrimerApellido = primerApellido;
		SegundoApellido = segundoApellido;
		PrimerNombre = primerNombre;
		OtroNombre = otroNombre;
		PaisEmpleo = paisEmpleo;
		FechaIngreso = fechaIngreso;
		Area = area;
		Estado = estado;
		FechaHoraRegistro = fechaHoraRegistro;
	}

}
