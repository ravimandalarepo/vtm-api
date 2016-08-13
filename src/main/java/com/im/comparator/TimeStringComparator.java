package com.im.comparator;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.im.model.pickuppoint.entity.PickupPoint;

public class TimeStringComparator implements Comparator<PickupPoint>{
   private DateFormat primaryFormat = new SimpleDateFormat("h:mm a");
   private DateFormat secondaryFormat = new SimpleDateFormat("H:mm");

   public int compare(PickupPoint time1, PickupPoint time2){
       try {
		return timeInMillis(time1.getArrivalTime()) - timeInMillis(time2.getArrivalTime());
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return 0;
	}
   }

   public int timeInMillis(String time) throws ParseException{
       return timeInMillis(time, primaryFormat);
   }

   private int timeInMillis(String time, DateFormat format) throws ParseException {
        // you may need more advanced logic here when parsing the time if some times have am/pm and others don't.
       try{
            Date date = format.parse(time);
            return (int)date.getTime();
       }catch(ParseException e){
           if(format != secondaryFormat){
               return timeInMillis(time, secondaryFormat);
           }else{
               throw e;
           }
       }
    }

   public static void main(String[] args) throws ParseException{
       List<String> times = Arrays.asList(new String[]{"08:12 AM", "07:30 AM", "6:34 PM"});
     //  Collections.sort(times, new TimeStringComparator());
       System.out.println(times);
       SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
         LinkedHashMap<Long,String> objHashMap=new LinkedHashMap<Long,String>();
       objHashMap.put(new Long(2),"08:31 AM");
       objHashMap.put(new Long(3),"07:30 AM");
       objHashMap.put(new Long(4),"6:34 PM");
       Date date1 = new Date();
       DateFormat format1 = new SimpleDateFormat("h:mm a");
       Long key=objHashMap.keySet().iterator().next();
       String value=objHashMap.get(key);
       Date date=DateFormat.getTimeInstance(DateFormat.SHORT).parse(value);
        System.out.println(date);
        String dateToStr = DateFormat.getInstance().format(new Date());  
        System.out.println("Date Format using getInstance(): "+dateToStr);  
        System.out.println(sdf.format(new Date())+" "+value);
        SimpleDateFormat formathr = new SimpleDateFormat("MM/dd/yy HH:mm a");
        Date d1 = formathr.parse(dateToStr);
		Date d2 = formathr.parse(sdf.format(new Date())+" "+value);
		long diff = d2.getTime() - d1.getTime();

		long diffSeconds = diff / 1000 % 60;
		long diffMinutes = diff / (60 * 1000) % 60;
		System.out.print(diffMinutes + " minutes, ");
		System.out.print(diffSeconds + " seconds.");
		System.out.print(d1.before(d2) + " value.");
		
   }


}