package aero.sita.casandra.persistence.repository;

import java.util.Map;

import com.datastax.driver.core.Session;

import aero.sita.mqtt.model.bimsxml.BagMqtt;
import aero.sita.mqtt.model.bimsxml.Passenger;

public interface PassengerRepository {
	public void insertPassenger(BagMqtt bagMqtt, Session session) throws Exception;
	
	public Map<String, Passenger> selectPassenger(Session session) throws Exception;
}
