package com.test.pe.common;

import org.springframework.stereotype.Component;

@Component
public class ApiResponse<TEntity> extends ApiResponseBase<TEntity> {

	public ApiResponse() {

	}

	public ApiResponse(TEntity data) {
		this.Data = data;
	}

	public ApiResponse(TEntity data, String Message, Boolean Result) {
		this.Data = data;
		this.Message = Message;
		this.Result = Result;
	}

	public ApiResponse(TEntity data, String Message, Boolean Result, int Code) {
		this.Data = data;
		this.Message = Message;
		this.Result = Result;
		this.Code = Code;
	}

	public ApiResponse<TEntity> get(TEntity data) {
		if (data != null) {
			this.Data = data;
			this.Message = "Elemento encontrado";
			this.Result = true;
			this.Code = 0;
		} else {
			this.Data = null;
			this.Message = "No es posible encontrar elemento";
			this.Result = false;
			this.Code = 405;
		}
		return this;
	}

	public ApiResponse<TEntity> get(TEntity data, String Message, Boolean Result) {
		this.Data = data;
		this.Message = Message;
		this.Result = Result;
		return this;
	}

	public ApiResponse<TEntity> get(TEntity data, String Message, Boolean Result, int Code) {
		this.Data = data;
		this.Message = Message;
		this.Result = Result;
		this.Code = Code;
		return this;
	}
}
