package com.creditsuisse.stockapp.utils.impl;

import java.util.Calendar;
import java.util.Date;

import com.creditsuisse.stockapp.utils.DatesUtils;


public class DatesUtilsImpl implements DatesUtils {

	
	public DatesUtilsImpl(){
		
	}
	
	public Date getNowMovedMinutes(int minutes){
		Calendar now = Calendar.getInstance();
		now.add(Calendar.MINUTE, minutes);
		return now.getTime();
	}
}
