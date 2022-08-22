package com.test.pe.common;

import java.util.List;

public class ApiResponseListBase<TEntity> {
	public int Code = 0;
	public String Message = "Success Operatión";
	public Boolean Result = true;
	public List<TEntity> Data = null;
}
