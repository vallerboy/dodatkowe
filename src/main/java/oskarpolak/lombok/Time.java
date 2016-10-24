package oskarpolak.lombok;

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
		  payAfter(dt, dt.minusDays(1));
	 }
	 
	 // JODATIME
	 private void payAfter(DateTime now, DateTime afterTime) { 
		  if(now.isAfter(afterTime)) System.out.println("Termin płatności minął!");
	 }
	 
}
