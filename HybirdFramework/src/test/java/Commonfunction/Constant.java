package Commonfunction;

import java.util.Properties;

public class Constant {

	
	
public static	String JourneyTrip = System.getProperty("JourneyTrip");
public static	String MonthandYear = System.getProperty("MonthandYear");
public static	String date = System.getProperty("date");
public static	String returnmonth = System.getProperty("returnmonth");
public static	String redate = System.getProperty("redate");
public static	String Departurecity = System.getProperty("Departurecity");
public static	String ArrivalCity = System.getProperty("ArrivalCity");
public static	String Adultcount =System.getProperty("Adultcount");
public static	String Childcount =System.getProperty("Childcount");
public static	String Infantcount=System.getProperty("Infantcount");
public static int ADTcount=Integer.parseInt(Adultcount);
public static int Chcount =Integer.parseInt(Childcount);
public static int InFcount =Integer.parseInt(Infantcount);
//public static String AdultPax=Commondetails.properties.getProperty("AdultPax");
public static String Adultpax=System.getProperty("AdultPax");

}
