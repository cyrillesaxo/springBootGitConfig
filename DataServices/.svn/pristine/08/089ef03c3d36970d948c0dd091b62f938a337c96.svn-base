package aero.sita.casandra.persistence.repository;

import java.util.Map;

import com.datastax.driver.core.Session;

import aero.sita.mqtt.model.bimsxml.BagMqtt;
import aero.sita.mqtt.model.bimsxml.BagPosition;

public interface BagPositionRepository {
	public void insertBagPosition(BagMqtt bagMqtt, Session session) throws Exception;
	
	public Map<String, BagPosition> selectBagPosition( Session session) throws Exception;
}
