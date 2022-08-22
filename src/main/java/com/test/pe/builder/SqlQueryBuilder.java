package com.test.pe.builder;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.lang.Nullable;

public class SqlQueryBuilder {
	
	@Autowired
	public JdbcTemplate jdbcTemplate;
	
	public ArrayList<SqlParam> parameters = new ArrayList<SqlParam>();
    public String query="";
    public String tablename ="";
    public SqlQueryBuilder(){}
    public SqlQueryBuilder(String tablename){this.tablename = tablename;}
    
    public void setString(String _param,String _value){
        this.parameters.add(new SqlParam(_param,_value));
    }
    
    public void setDate(String _param,Date _value){
    	if(_value != null) {
    		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
            this.parameters.add(new SqlParam(_param,format.format(_value)));
    	} else {
    		this.parameters.add(new SqlParam(_param,null));
    	}
    	
    }
    
    public void setInt(String _param,Integer _value){
        this.parameters.add(new SqlParam(_param,_value+""));
    }
    
    public void setShort(String _param,Short _value){
        this.parameters.add(new SqlParam(_param,_value+""));
    }
    
    public void setBoolean(String _param,Boolean _value){
        this.parameters.add(new SqlParam(_param,_value+""));
    }
    /*public void setDouble(String _param,double _value,int decimal_length){
        this.parameters.add(new SqlParam(_param,Default.roundTo(_value, decimal_length)));
    }*/
    public void addBoolean(String _param,Boolean _value){
        this.parameters.add(new SqlParam(_param,_value+""));
    }
    
    public String getSqlDatetime() {return "now()";}
    public String getSqlDate() {return "now()::date";}
    
    
    public String getInsertQuery() {
    	String str_column="";
        String str_value="";
    	for (int a = 0; a < this.parameters.size(); a++) {
    		SqlParam column_parameter = this.parameters.get(a);
    		//str_column += "\""+column_parameter.parameter +"\",";
    		str_column += column_parameter.parameter+",";
    		if (column_parameter.value == null) {
                str_value +="NULL,";
            } else {
                if (column_parameter.value.equals("now()") || column_parameter.value.equals("now()::date")) {
                    str_value += column_parameter.value +",";
                }
                 else {
                    str_value +="'"+column_parameter.value+"',";
                }
            }
    	}
    	str_column = (str_column + "#").replace(",#", "");
        str_value = (str_value + "#").replace(",#", "");
        String sql ="insert into " + this.tablename + "(" +str_column + ") values ("+str_value+");";
        return sql;
    }
   
    public String getUpdateQuery(String condicion){
    	//String str_column="";
        String str_value="";
    	for (int a = 0; a < this.parameters.size(); a++) {
    		SqlParam column_parameter = this.parameters.get(a);
    		String column = "\""+column_parameter.parameter+"\"";
            String value = column_parameter.value;
            if (value == null) {
                str_value += (column + "=NULL,");
            } else {
                if (value.equals("now()") || value.equals("now()::date")) {
                    str_value += (column + "=" + value +",");
                }
                 else {
                    str_value += (column +"='"+value+"',");
                }
            }
    	}
    	str_value = (str_value + "#").replace(",#", "");
        String sql ="update \"" + this.tablename + "\" set " + str_value + " where " + condicion;
        return sql;
    }
    
    public Integer Update(String condition) {
    	return this.jdbcTemplate.update(this.getUpdateQuery(condition));
    }
    public Integer Update(String condition, @Nullable Object... args) {
    	return this.jdbcTemplate.update(this.getUpdateQuery(condition),args);
    }
    
    
    public void reset() {
    	this.parameters.clear();
    }

}
