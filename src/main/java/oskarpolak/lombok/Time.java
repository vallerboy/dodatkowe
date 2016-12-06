package oskarpolak.lombok;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import org.joda.time.DateTime;

public class Time {
 
	// JODATIME
	 public Time() { 
	
		  java.util.Date juDate = new Date();
		
		  
		  DateTime dt = new DateTime(juDate);
		 
	
		
		  
		  System.out.println("Mamy dziś " + dt.getDayOfYear() + " dzień roku.");
		  
		  // niestety nie ma polskiego locale, trzeba ręcznie tłumaczyć np. switchem.
		  System.out.println("Teraźniejszy miesiąc: " +  dt.monthOfYear().getAsText(Locale.ENGLISH));
				  
		  
		  //Ukazanie sprawności w porównywaniu dat.
		//  payAfter(dt, dt.plusDays(1));
		  
		  convert();
	 }
	 
	 // JODATIME
	 private void payAfter(DateTime now, DateTime afterTime) { 
		  if(now.isAfter(afterTime)) System.out.println("Termin płatności minął!");
	 }
	 
	 private void convert(){ 
		
		  DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		  String myDate = "1991/05/18 22:30:30";
		  
		  Date convertedData = null; 
		  try {
			convertedData = df.parse(myDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 DateTime jodaConvertedTime = new DateTime(convertedData);
		 DateTime changedTime = jodaConvertedTime.plusDays(2);
	
		 
		 System.out.println(df.format(changedTime.toDate()));
		 
		 
		 
	 }
	 
}
