package br.edu.unibratec.myExpenses.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilDateTime {
	
	public static String getDataHoraHojeAgora() {
		return new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
	}
	
}