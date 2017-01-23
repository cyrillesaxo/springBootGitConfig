package aero.sita.cassandra.persistence;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

import aero.sita.casandra.persistence.repository.BagPositionRepository;
import aero.sita.mqtt.model.bimsxml.Bag;
import aero.sita.mqtt.model.bimsxml.BagEventPublishMessageNotif;
import aero.sita.mqtt.model.bimsxml.BagMqtt;
import aero.sita.mqtt.model.bimsxml.BagPosition;
import aero.sita.mqtt.model.bimsxml.Tool;

public class BagPositionPersistence extends CassandraConnector implements BagPositionRepository {

	private static final Logger logger = LoggerFactory.getLogger(BagPositionPersistence.class);

	public void insertBagPosition(BagMqtt bagMqtt, Session session) throws Exception {
		logger.info("--> insertBagPosition BagMqtt :" + bagMqtt);
		Tool.validate(bagMqtt);

		String bagEventId = bagMqtt.getBagEventId();
		BagEventPublishMessageNotif bn = bagMqtt.getBagEventPublishMessageNotif();
		Bag bag = bn.getBag();
		BagPosition bagPosition = bag.getBagPosition();

		if (bagPosition == null)
			throw new Exception(
					" The parameter bagPosition of the method inserBagPosition of the class BagPositionPersistence is null !");

		String areaID = bagPosition.getAreaID();

		PreparedStatement prepared = session.prepare("insert into BaggageEvent.BagPosition"
				+ "( BagEvenId , AreaID, BagPositionDate  )" + "VALUES (?, ?, ?) ");

		BoundStatement bound = prepared.bind(bagEventId, areaID);
		bound.setTimestamp(2, new Date());
		session.execute(bound);
	}

	public Map<String, BagPosition> selectBagPosition( Session session) throws Exception {
		logger.info("--> selectBagPosition ");
		Map<String, BagPosition> map = new HashMap<String, BagPosition>();

		BagPosition bagPosition = null;
		ResultSet resultSet = session.execute("SELECT BagEvenId , AreaID, BagPositionDate  FROM BaggageEvent.BagPosition ");
		logger.info(" RESULT FROM CASSANDRA ");

		String BagEventId = null;
		String areaID = null;
		String bagPositionDate = null;

		for (Row row : (ResultSet) resultSet) {

			BagEventId = row.getString("BagEvenId");
			areaID = row.getString("AreaID");
			//bagPositionDate = "" + row.getTimestamp(1);

			bagPosition = new BagPosition();
			bagPosition.setAreaID(areaID);

			map.put(BagEventId, bagPosition);
			logger.info(" resultset  BagEventId:" + BagEventId + " --  bagTag: " + bagPosition);
		}

		return map;
	}
}
