package aero.sita.casandra.persistence.repository;

import java.util.Map;

import com.datastax.driver.core.Session;

import aero.sita.mqtt.model.bimsxml.BagMqtt;
import aero.sita.mqtt.model.bimsxml.BaggageActivity;

public interface BaggageActivityRepository {
	public void insertBaggageActivity(BagMqtt bagMqtt, Session session) throws Exception;

	public Map<String, BaggageActivity> selectBaggageActivity(Session session) throws Exception;
}
