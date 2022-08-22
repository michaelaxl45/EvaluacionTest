package com.test.pe;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EvaluacionEmpresaApplication {

	private static final Logger logger = LoggerFactory.getLogger(EvaluacionEmpresaApplication.class);

	public static void main(String[] args) {

		String idTransaccion = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());

		long tiempoInicio = System.currentTimeMillis();

		String msjTx = "[" + idTransaccion + "] ";
		try {
			SpringApplication.run(EvaluacionEmpresaApplication.class, args);

		} catch (Exception e) {
			logger.error(msjTx + "Error al Levantar Contexto: " + e.getMessage(), e);
			e.printStackTrace();

		} finally {
			logger.info(msjTx + "###### [FIN] . Tiempo total de proceso: " + (System.currentTimeMillis() - tiempoInicio)
					+ "(ms) ######");

			logger.info("===========================================================================================");

		}

	}

}
