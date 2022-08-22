package com.test.pe.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.test.entities.EmpleadoEntity;
import com.test.pe.builder.SqlQueryBuilder;
import com.test.pe.common.ApiResponse;
import com.test.pe.interfaceService.IEmpleadoServiceInterface;
import com.test.pe.response.EmpleadoResponse;


@Repository
public class EmpleadoRepository extends SqlQueryBuilder implements IEmpleadoServiceInterface.IRepository {

	private static final Logger logger = LoggerFactory.getLogger(EmpleadoRepository.class);
	
	
	
	public EmpleadoRepository() {

		super("Empleado");
	}

	@Override
	public ApiResponse<Object> Insert(EmpleadoEntity entidad) {

		try {
			
			this.reset();
			this.setString("TipoIdentificacion", entidad.TipoIdentificacion);
			this.setString("NumeroIdentificacion", entidad.NumeroIdentificacion);
			this.setString("CorreoElectronico", entidad.CorreoElectronico);
			this.setString("PrimerApellido", entidad.PrimerApellido);
			this.setString("SegundoApellido", entidad.SegundoApellido);
			this.setString("PrimerNombre", entidad.PrimerNombre);
			this.setString("OtroNombre", entidad.OtroNombre);
			this.setString("PaisEmpleo", entidad.PaisEmpleo);
			this.setString("FechaIngreso", entidad.FechaIngreso);
			this.setString("Area", entidad.Area);
			this.setString("Estado", entidad.Estado);
			this.setString("FechaHoraRegistro", entidad.FechaHoraRegistro);

			int result = this.jdbcTemplate.update(this.getInsertQuery());
			if (result > 0) {
				return new ApiResponse<Object>(null, "Registrado correctamente.", true);
			} else {
				return new ApiResponse<Object>(null, "No es posible registrar, error interno.", false);
			}

		} catch (Exception ex) {
			throw ex;
		}

	}

	@Override
	public List<EmpleadoResponse> ListaEmpresaID(String NumeroID) {
		try {


			String query = "select * from EMPLEADO where NumeroIdentificacion="+"'"+NumeroID+"'";
			
			logger.info( "NumeroID " + NumeroID);

			    

			List<EmpleadoResponse> lst = jdbcTemplate.query(query, new RowMapper<EmpleadoResponse>() {
				public EmpleadoResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
					return new EmpleadoResponse(rs);
				}
			});
			return lst;
		} catch (Exception ex) {
			throw ex;
		}

	}
}
