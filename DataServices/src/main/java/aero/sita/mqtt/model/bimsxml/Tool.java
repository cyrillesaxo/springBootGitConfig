package aero.sita.mqtt.model.bimsxml;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import aero.sita.cassandra.persistence.CassandraConnector;

public class Tool {
	
	private static final Logger logger = LoggerFactory.getLogger(Tool.class);
	
	public static Properties prop(){
		Properties prop = new Properties();
    	InputStream input = null;

    	try {

    		String env = "";
    		env = (System.getProperty("env")!=null)? System.getProperty("env"):"";
    		
    		logger.info("env:"+env);
    		
    		String filename = "myapp"+env+".properties";
    		input = CassandraConnector.class.getClassLoader().getResourceAsStream(filename);
    		if(input==null){
    	            logger.info("Sorry, unable to find " + filename);
    		    return null;
    		}

    		prop.load(input);

    		return prop;
    		
    	} catch (IOException ex) {
    		ex.printStackTrace();
        } finally{
        	if(input!=null){
        		try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
        	}
        }
    	return prop;
	}
	
	public static void validate(BagMqtt bagMqtt) throws Exception{
		if (bagMqtt == null)
			throw new Exception(" The parameter bagMqtt of the method inserLocation  is null!");
		
		BagEventPublishMessageNotif bn= bagMqtt.getBagEventPublishMessageNotif();
		if (bn == null)
			throw new Exception(" BagEventPublishMessageNotif  is null!");
		
		Bag bg = bn.getBag();
		if (bg == null)
			throw new Exception(" Bag  is null!");
	}
	
	public static Date getDate(String dateInString) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
		// SimpleDateFormat formatter2 = new
		// SimpleDateFormat("yyyy-MM-dd'T'HH:mm:SSSZZ");
		// String dateInString = "2014-10-05T15:23:01Z";
		Date date = null;

		try {

			if (dateInString.contains("Z"))
				date = formatter.parse(dateInString.replaceAll("Z$", "+0000"));
			else if (dateInString.contains("+")) {
				date = formatter.parse(dateInString.replaceAll("[+].*", "+0000"));
			} else
				throw new ParseException(" No existing format", -1);

			logger.info("time zone : " + TimeZone.getDefault().getID());
			logger.info(formatter.format(date));
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
