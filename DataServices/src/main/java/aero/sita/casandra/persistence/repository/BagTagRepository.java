package aero.sita.casandra.persistence.repository;

import java.util.Map;

import com.datastax.driver.core.Session;

import aero.sita.mqtt.model.bimsxml.BagMqtt;
import aero.sita.mqtt.model.bimsxml.BagTag;

public interface BagTagRepository {
	public void insertBagTag(BagMqtt bagMqtt, Session session) throws Exception;
	
	public Map<String, BagTag> selectBagTag(Session session) throws Exception;
}
