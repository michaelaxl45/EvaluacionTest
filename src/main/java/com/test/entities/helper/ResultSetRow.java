package com.test.entities.helper;


import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.*;



public class ResultSetRow {
	public static Logger logger = Logger.getLogger("ResultSetRow");
	
	/**Devuelve un valor Integer si el nombre de campo existe en la consulta, caso contrario, devolverá nulo.
	@param rs ResultSet de consulta SQL
	@param column Nombre de columna de la consulta SQL
	@return Integer| null
	@throws Ignora el error y devuelve NULL*/
	public static Integer getInteger(ResultSet rs, String column){
	    try{ return rs.getInt(column);}
	    catch (SQLException ex){
	    	logger.log(Level.SEVERE,ex.getMessage());
	    	return null;
	    }
	}
	
	/**Devuelve un valor Integer si el nombre de campo existe en la consulta, caso contrario, devolverá nulo.
	@param rs ResultSet de consulta SQL
	@param column Nombre de columna de la consulta SQL
	@param throw_ex Indica devuelve throws SQLException en caso ocurra error.
	@return Integer| null | throw SQLException
	@throws SQLException*/
	public static Integer getInteger(ResultSet rs, String column,boolean throw_ex) throws SQLException{
	    try{ return rs.getInt(column);} 
	    catch (SQLException ex){
	    	logger.log(Level.SEVERE,ex.getMessage());
	    	if(throw_ex) {throw new SQLException(ex);}
	    	else { return null;}
	    }
	}
	
	/**Devuelve un valor Short si el nombre de campo existe en la consulta, caso contrario, devolverá nulo.
	@param rs ResultSet de consulta SQL
	@param column Nombre de columna de la consulta SQL
	@return Short| null
	@throws Ignora el error y devuelve NULL*/
	public static Short getShort(ResultSet rs, String column){
	    try{ return rs.getShort(column);}
	    catch (SQLException ex){
	    	logger.log(Level.SEVERE,ex.getMessage());
	    	return null;
	    }
	}
	
	/**Devuelve un valor Short si el nombre de campo existe en la consulta, caso contrario, devolverá nulo.
	@param rs ResultSet de consulta SQL
	@param column Nombre de columna de la consulta SQL
	@param throw_ex Indica devuelve throws SQLException en caso ocurra error.
	@return Short| null | throw SQLException
	@throws SQLException*/
	public static Short getShort(ResultSet rs, String column,boolean throw_ex) throws SQLException{
	    try{ return rs.getShort(column);} 
	    catch (SQLException ex){
	    	logger.log(Level.SEVERE,ex.getMessage());
	    	if(throw_ex) {throw new SQLException(ex);}
	    	else { return null;}
	    }
	}
	
	/**Devuelve un valor String si el nombre de campo existe en la consulta, caso contrario, devolverá nulo.
	@param rs ResultSet de consulta SQL
	@param column Nombre de columna de la consulta SQL
	@return String | null
	@throws Ignora el error y devuelve NULL*/
	public static String getString(ResultSet rs, String column){
	    try{ return rs.getString(column);}
	    catch (SQLException ex){
	    	logger.log(Level.SEVERE,ex.getMessage());
	    	return null;
	    }
	}
	
	/**Devuelve un valor String si el nombre de campo existe en la consulta, caso contrario, devolverá nulo.
	@param rs ResultSet de consulta SQL
	@param column Nombre de columna de la consulta SQL
	@param throw_ex Indica devuelve throws SQLException en caso ocurra error.
	@return String | null | throw SQLException
	@throws SQLException*/
	public static String getString(ResultSet rs, String column,boolean throw_ex) throws SQLException{
	    try{ return rs.getString(column);} 
	    catch (SQLException ex){
	    	logger.log(Level.SEVERE,ex.getMessage());
	    	if(throw_ex) {throw new SQLException(ex);}
	    	else { return null;}
	    }
	}
	
	/**Devuelve un valor Date si el nombre de campo existe en la consulta, caso contrario, devolverá nulo.
	@param rs ResultSet de consulta SQL
	@param column Nombre de columna de la consulta SQL
	@return Date | null
	@throws Ignora el error y devuelve NULL*/
	public static Date getDate(ResultSet rs, String column){
	    try{ return rs.getDate(column);}
	    catch (SQLException ex){
	    	logger.log(Level.SEVERE,ex.getMessage());
	    	return null;
	    }
	}
	
	/**Devuelve un valor Date si el nombre de campo existe en la consulta, caso contrario, devolverá nulo.
	@param rs ResultSet de consulta SQL
	@param column Nombre de columna de la consulta SQL
	@param throw_ex Indica devuelve throws SQLException en caso ocurra error.
	@return Date | null | throw SQLException
	@throws SQLException*/
	public static Date getDate(ResultSet rs, String column,boolean throw_ex) throws SQLException{
	    try{ return rs.getDate(column);} 
	    catch (SQLException ex){
	    	logger.log(Level.SEVERE,ex.getMessage());
	    	if(throw_ex) {throw new SQLException(ex);}
	    	else { return null;}
	    }
	}
	
	/**Devuelve un valor Boolean si el nombre de campo existe en la consulta, caso contrario, devolverá nulo.
	@param rs ResultSet de consulta SQL
	@param column Nombre de columna de la consulta SQL
	@return Boolean | null
	@throws Ignora el error y devuelve NULL*/
	public static Boolean getBoolean(ResultSet rs, String column){
	    try{ return rs.getBoolean(column);}
	    catch (SQLException ex){
	    	logger.log(Level.SEVERE,ex.getMessage());
	    	return null;
	    }
	}
	
	/**Devuelve un valor Boolean si el nombre de campo existe en la consulta, caso contrario, devolverá nulo.
	@param rs ResultSet de consulta SQL
	@param column Nombre de columna de la consulta SQL
	@param throw_ex Indica devuelve throws SQLException en caso ocurra error.
	@return Boolean | null | throw SQLException
	@throws SQLException*/
	public static Boolean getBoolean(ResultSet rs, String column,boolean throw_ex) throws SQLException{
	    try{ return rs.getBoolean(column);} 
	    catch (SQLException ex){
	    	logger.log(Level.SEVERE,ex.getMessage());
	    	if(throw_ex) {throw new SQLException(ex);}
	    	else { return null;}
	    }
	}
	
	/** Busca dentro del nombre de columnas de ResultSet para identificar si existe algun prefijo anexado. si lo encuentra devuelve true.*/
	public static Boolean isIncluded(ResultSet rs, String prefijo) {
		Boolean result = false;
		try {
			ResultSetMetaData meta = rs.getMetaData();
			for (int i = 1; i <= meta.getColumnCount(); i++ ) {
			  String name = meta.getColumnName(i);
			  String str = name.substring(0, prefijo.length());
			  if(str.toLowerCase().indexOf(prefijo.toLowerCase()) != -1) {
				 result = true;
			  } 
			}
		}
		catch(SQLException ex) { }
		return result;
	}	
	


}
