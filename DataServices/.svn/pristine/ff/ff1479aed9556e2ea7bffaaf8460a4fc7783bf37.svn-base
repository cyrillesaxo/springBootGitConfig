package aero.sita.casandra.persistence.repository;

import java.util.Map;

import com.datastax.driver.core.Session;

import aero.sita.mqtt.model.bimsxml.BagMqtt;
import aero.sita.mqtt.model.bimsxml.BagSegment;

public interface BagSegmentRepository {
	public void insertBagSegment(BagMqtt bagMqtt, Session session) throws Exception;
	
	public Map<String, BagSegment> selectBagSegment(Session session) throws Exception;
}
