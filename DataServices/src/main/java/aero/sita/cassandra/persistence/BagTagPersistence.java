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

import aero.sita.casandra.persistence.repository.BagTagRepository;
import aero.sita.mqtt.model.bimsxml.Bag;
import aero.sita.mqtt.model.bimsxml.BagEventPublishMessageNotif;
import aero.sita.mqtt.model.bimsxml.BagMqtt;
import aero.sita.mqtt.model.bimsxml.BagTag;
import aero.sita.mqtt.model.bimsxml.Tool;

public class BagTagPersistence extends CassandraConnector implements BagTagRepository {

	private static final Logger logger = LoggerFactory.getLogger(BaggageActivityPersistence.class);

	public void insertBagTag(BagMqtt bagMqtt, Session session) throws Exception {
		logger.info("--> insertBagTag BagMqtt :" + bagMqtt);
		Tool.validate(bagMqtt);

		String bagEventId = bagMqtt.getBagEventId();
		BagEventPublishMessageNotif bn = bagMqtt.getBagEventPublishMessageNotif();
		Bag bag = bn.getBag();
		BagTag bagTag = bag.getBagTag();

		if (bagTag == null)
			throw new Exception(
					" The parameter bagTag of the method inserBagTag of the class BagTagPersistence is null !");

		String tagID = bagTag.getTagID();
		bagTag.setTagID(tagID);

		PreparedStatement prepared = session
				.prepare("insert into BaggageEvent.BagTag ( BagEvenId , TagID, BagTagDate  )"
						+ "VALUES (?, ?, ?) ");

		BoundStatement bound = prepared.bind(bagEventId, tagID);
						bound.setTimestamp(2, new Date());
		session.execute(bound);
	}

	public Map<String, BagTag> selectBagTag(Session session) throws Exception {
		logger.info("--> selectBagTag " );
		Map<String, BagTag> map = new HashMap<String, BagTag>();

		BagTag bagTag = null;
		ResultSet resultSet = session.execute("SELECT * FROM BaggageEvent.BagTag ");
		logger.info(" RESULT FROM CASSANDRA ");

		String BagEventId = null;
		String tagID = null;
		String bagEventDate = null;

		for (Row row : (ResultSet) resultSet) {

			BagEventId = row.getString("BagEventId");
			tagID = row.getString("TagID");
			bagEventDate = "" + row.getTimestamp(1);

			bagTag = new BagTag();
			bagTag.setTagID(tagID);
			
			
			map.put(BagEventId, bagTag);
			logger.info(" resultset  BagEventId:" + BagEventId + " --  bagTag: " + bagTag);
		}

		return map;
	}
}