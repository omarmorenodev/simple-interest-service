package com.test.app.common;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class WeeklySchedulerPayment {	
	private static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	
	public static List<String> calculateDatesByTerms(int terms) {
        Date current = new Date();
        Date date = current;
        
        List<String> dates = new ArrayList<String>();
        Calendar calendar = Calendar.getInstance();
        
        for (int i = 0; i < terms; i++) {            
            calendar.setTime(date);
            calendar.add(Calendar.DAY_OF_YEAR, 7);
            date = calendar.getTime();
            dates.add(DATE_FORMAT.format(date));
        }

        return dates;
    }
}
