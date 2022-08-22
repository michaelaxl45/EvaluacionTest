package com.test.pe.common;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ApiResponseList<TEntity> extends ApiResponseListBase<TEntity> {

	public ApiResponseList() {
	}

	public ApiResponseList(List<TEntity> data) {
		if (data != null) {
			if (data.size() > 0) {
				this.Data = data;
				this.Result = true;
				this.Message = "Operación exitosa";
				this.Code = 200;
			} else {
				this.Message = "No es posible encontrar resultados";
				this.Result = false;
				this.Code = 200;
			}
		} else {
			this.Message = "Valor de entrada de lista es nulo. Error interno";
			this.Result = false;
			this.Code = 401;
		}
	}

	public ApiResponseList(List<TEntity> data, String Message, Boolean Result) {
		this.Data = data;
		this.Message = Message;
		this.Result = Result;
	}

	public ApiResponseList(List<TEntity> data, String Message, Boolean Result, int Code) {
		this.Data = data;
		this.Message = Message;
		this.Result = Result;
		this.Code = Code;
	}

	public ApiResponseList<TEntity> get(List<TEntity> data) {
		if (data != null) {
			if (data.size() > 0) {
				this.Data = data;
				this.Result = true;
				this.Message = "Operación exitosa";
				this.Code = 200;
			} else {
				this.Message = "No es posible encontrar resultados";
				this.Result = false;
				this.Code = 200;
			}
		} else {
			this.Message = "Valor de entrada de lista es nulo. Error interno";
			this.Result = false;
			this.Code = 401;
		}
		return this;
	}

	public ApiResponseList<TEntity> get(List<TEntity> data, String Message, Boolean Result) {
		this.Data = data;
		this.Message = Message;
		this.Result = Result;
		return this;
	}

	public ApiResponseList<TEntity> get(List<TEntity> data, String Message, Boolean Result, int Code) {
		this.Data = data;
		this.Message = Message;
		this.Result = Result;
		this.Code = Code;
		return this;
	}
}
