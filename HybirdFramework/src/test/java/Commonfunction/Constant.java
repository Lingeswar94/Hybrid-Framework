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
public static int ADTcount=Integer.parseInt(System.getProperty("Adultcount"));
public static int Chcount =Integer.parseInt(System.getProperty("Childcount"));
public static int InFcount =Integer.parseInt(System.getProperty("Infantcount"));
public static String AdultPax=Commondetails.properties.getProperty("AdultPax");
//public static String Adultpax= System.getProperty("Adultpax");
public static boolean isReturnTrip = Boolean.parseBoolean(System.getProperty("isReturnTrip"));
public static boolean addBaggage = Boolean.parseBoolean(System.getProperty("addBaggage"));
public static boolean addDepartureBaggage = Boolean.parseBoolean(System.getProperty("addDepartureBaggage"));
public static boolean addReturnBaggage = Boolean.parseBoolean(System.getProperty("addReturnBaggage"));
public static	String Baggagename=System.getProperty("Baggagename");


}
