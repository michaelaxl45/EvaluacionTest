package com.test.pe.common;

public class ApiResponseBase<TEntity> {
	public int Code = 0;
	public String Message = "Success Operatión";
	public Boolean Result = true;
	public TEntity Data = null;
}
