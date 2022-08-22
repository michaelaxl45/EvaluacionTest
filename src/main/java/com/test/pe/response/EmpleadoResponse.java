package com.test.pe.response;

import java.sql.ResultSet;
import com.test.entities.helper.ResultSetRow;
import com.test.pe.common.Prefijo;

public class EmpleadoResponse {

	public String tipoidentificacion;
	public String numeroidentificacion;
	public String correoelectronico;
	public String primerapellido;
	public String segundoapellido;
	public String primernombre;
	public String otronombre;
	public String paisempleo;
	public String fechaingreso;
	public String area;
	public String estado;
	public String fechahoraregistro;

	public EmpleadoResponse() {

	}

	public EmpleadoResponse(ResultSet rs) {
		this.ConvertFromResultSet(rs, Prefijo.Empleado);
	}

	public EmpleadoResponse(ResultSet rs, String prefijo) {
		this.ConvertFromResultSet(rs, prefijo);
	}

	private void ConvertFromResultSet(ResultSet rs, String prefijo) {

		this.tipoidentificacion = ResultSetRow.getString(rs, "TipoIdentificacion");
		this.numeroidentificacion = ResultSetRow.getString(rs, "NumeroIdentificacion");
		this.correoelectronico = ResultSetRow.getString(rs, "CorreoElectronico");
		this.primerapellido = ResultSetRow.getString(rs, "PrimerApellido");
		this.segundoapellido = ResultSetRow.getString(rs, "SegundoApellido");
		this.primernombre = ResultSetRow.getString(rs, "PrimerNombre");
		this.otronombre = ResultSetRow.getString(rs, "OtroNombre");
		this.paisempleo = ResultSetRow.getString(rs, "PaisEmpleo");
		this.fechaingreso = ResultSetRow.getString(rs, "FechaIngreso");
		this.area = ResultSetRow.getString(rs, "Area");
		this.estado = ResultSetRow.getString(rs, "Estado");
		this.fechahoraregistro = ResultSetRow.getString(rs, "FechaHoraRegistro");

	}
}
