package com.test.pe.interfaceService;

import java.util.List;
import com.test.entities.EmpleadoEntity;
import com.test.pe.common.ApiResponse;
import com.test.pe.common.ApiResponseList;
import com.test.pe.request.EmpleadoRequest;
import com.test.pe.response.EmpleadoResponse;

public interface IEmpleadoServiceInterface {

	public interface IController {

		public ApiResponse<Object> Insert(EmpleadoRequest request);

		public ApiResponseList<EmpleadoResponse> ListarEmpresa(String NumeroID);

	}

	public interface IRepository {

		public ApiResponse<Object> Insert(EmpleadoEntity entidad);

		public List<EmpleadoResponse> ListaEmpresaID(String NumeroID);

	}

}
