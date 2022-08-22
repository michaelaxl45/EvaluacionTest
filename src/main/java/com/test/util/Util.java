package com.test.util;

public class Util {
	
	public static  String isNullBlank(Object texto) {
		
		String valorTexto=null;
		
		try {
			if(String.valueOf(texto).isEmpty() || String.valueOf(texto)=="") {
				valorTexto="";
			}else {valorTexto=String.valueOf(texto);}
		}catch(Exception ex) {
			valorTexto="";
		}
		

		 
		
		return valorTexto;
	}

}
