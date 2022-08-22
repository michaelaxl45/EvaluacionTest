package com.test.pe.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.test.entities.EmpleadoEntity;
import com.test.pe.common.ApiResponse;
import com.test.pe.common.ApiResponseList;
import com.test.pe.interfaceService.IEmpleadoServiceInterface;
import com.test.pe.repository.EmpleadoRepository;
import com.test.pe.request.EmpleadoRequest;
import com.test.pe.response.EmpleadoResponse;
import com.test.util.Constantes;

@Service
public class EmpleadoService implements IEmpleadoServiceInterface.IController {

	private static final Logger logger = LoggerFactory.getLogger(EmpleadoService.class);

	@Autowired
	EmpleadoRepository empleadoRepository;
	public String msjTx = "";

	@Override
	public ApiResponse<Object> Insert(EmpleadoRequest request) {

		try {

			DateTimeFormatter fecha = DateTimeFormatter.ofPattern(Constantes.FORMATO_FECHA_1);
			String fechaactual = fecha.format(LocalDateTime.now());

			logger.info(msjTx + "fecha Actual :" + fechaactual);

			boolean flag1, flag2, flag3, flag4 = false;

			EmpleadoEntity e = new EmpleadoEntity();

			String primerape = request.primerapellido;
			String segundoape = request.segundoapellido;
			String primerNombre = request.primernombre;
			String numeroId = request.numeroidentificacion;

			logger.info(msjTx + "se Valida Primer Apellido");
			logger.info(msjTx + "Primer Apellido: " + primerape);
			logger.info(msjTx + "se Valida Segundo Apellido");
			logger.info(msjTx + "Primer Apellido : " + segundoape);
			logger.info(msjTx + "se Valida Primer Nombre");
			logger.info(msjTx + "Primer Apellido :" + primerNombre);
			logger.info(msjTx + "se Valida Numero de  Identifacion");
			logger.info(msjTx + " Numero de ID :" + numeroId);

			flag1 = ValidarCaracter(primerape);
			flag2 = ValidarCaracter(segundoape);
			flag3 = ValidarCaracter(primerNombre);
			flag4 = ValidarCaracter(numeroId);

			if ((flag1 = true) || (flag2 = true) || (flag3 = true) || (flag4 = true)) {

				logger.info(msjTx + "Primer Apellido  Correcto");
				logger.info(msjTx + "Segundo Apellido Correcto");
				logger.info(msjTx + "Primer Nombre    Correcto");
				logger.info(msjTx + "Numero de ID      Correcto");
				logger.info(msjTx + "===================================");

				String NumeroIdentificacion = request.numeroidentificacion;
				String valordominiopais = request.paisempleo;
				String valorconcatenado = concatenarCorreo(primerape, segundoape, NumeroIdentificacion,
						valordominiopais);
				String estado = Constantes.ESTADO;

				String Tipoid = request.tipoidentificacion;
				logger.info(msjTx + "TipoIdentificacion :" + Tipoid);
				e.TipoIdentificacion = Tipoid;

				e.NumeroIdentificacion = numeroId;
				e.PrimerApellido = primerape;
				e.SegundoApellido = segundoape;
				e.PrimerNombre = primerNombre;
				e.CorreoElectronico = valorconcatenado;
				e.OtroNombre = request.otronombre;
				e.PaisEmpleo = request.paisempleo;
				e.FechaIngreso = request.fechaingreso;
				e.Area = request.area;
				e.Estado = estado;
				e.FechaHoraRegistro = fechaactual;

			} else {

				logger.info(msjTx + "ocurrio un error ,Validar Primer Apellido,Segundo Apellido o Nombre");

			}

			ApiResponse<Object> a = this.empleadoRepository.Insert(e);
			return new ApiResponse<Object>(null, a.Message, a.Result);

		} catch (Exception ex) {
			return new ApiResponse<Object>(null, ex.getMessage(), false);
		}

	}



	public String concatenarCorreo(String primernombre, String primerapellido, String id, String paisdominio) {

		String dominio = "";

		if (paisdominio != Constantes.PAIS_COLOMBIA) {

			dominio = Constantes.DOMINIO_USA;

		} else {

			dominio = Constantes.DOMINIO_COLOMBIA;
		}

		String concatena = primernombre + Constantes.PUNTO + primerapellido + Constantes.PUNTO + Constantes.ARROBA
				+ Constantes.CIDENET + Constantes.PUNTO + Constantes.DOMINIO_COM + Constantes.PUNTO + dominio;
		return concatena;

	}

	public static boolean ValidarCaracter(String nombrecompleto) {

		boolean caractervalidado = false;
		Pattern patron20 = Pattern.compile("[0-9A-Za-zñÑáéíóú¡!¿?@#$%()=+-€/.,]{1,20}");

		Matcher comprobacion = patron20.matcher(nombrecompleto);

		if (comprobacion.matches()) {
			caractervalidado = true;
		}

		return caractervalidado;

	}



	@Override
	public ApiResponseList<EmpleadoResponse> ListarEmpresa(String NumeroID) {
		try {
			List<EmpleadoResponse> lst = this.empleadoRepository.ListaEmpresaID(NumeroID);
			return new ApiResponseList<EmpleadoResponse>(lst);
		} catch (Exception ex) {
			return new ApiResponseList<EmpleadoResponse>(null, ex.getMessage(), false);
		}
	}
	

	

	
	
	
	
	
	
	
	
	
	
	
	
	
}
