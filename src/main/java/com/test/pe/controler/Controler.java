package com.test.pe.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.test.pe.common.ApiResponse;
import com.test.pe.common.ApiResponseList;
import com.test.pe.interfaceService.IEmpleadoServiceInterface;
import com.test.pe.request.EmpleadoRequest;
import com.test.pe.response.EmpleadoResponse;
import com.test.pe.service.EmpleadoService;



@RestController
@RequestMapping("/Empleados")
public class Controler implements IEmpleadoServiceInterface.IController {

	@Autowired
	private EmpleadoService service;

	@Override
	@PostMapping("/Registro")
	public ApiResponse<Object> Insert(@RequestBody EmpleadoRequest request) {

		try {
			return this.service.Insert(request);
		} catch (Exception ex) {
			return new ApiResponse<Object>(null, ex.getMessage(), false);
		}

	}

	@Override
	@GetMapping("/listarRegistros/{NumeroID}")
	public ApiResponseList<EmpleadoResponse> ListarEmpresa(@PathVariable(required=true)String NumeroID)  {

		return this.service.ListarEmpresa(NumeroID);

	}
	 


}
