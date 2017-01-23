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

import aero.sita.casandra.persistence.repository.BaggageActivityRepository;
import aero.sita.mqtt.model.bimsxml.Bag;
import aero.sita.mqtt.model.bimsxml.BagEventPublishMessageNotif;
import aero.sita.mqtt.model.bimsxml.BagMqtt;
import aero.sita.mqtt.model.bimsxml.BaggageActivity;
import aero.sita.mqtt.model.bimsxml.Tool;

public class BaggageActivityPersistence extends CassandraConnector implements BaggageActivityRepository {

	private static final Logger logger = LoggerFactory.getLogger(BaggageActivityPersistence.class);

	public void insertBaggageActivity(BagMqtt bagMqtt, Session session) throws Exception {
		logger.info("--> insertBaggageActivity BagMqtt :" + bagMqtt);
		Tool.validate(bagMqtt);

		String bagEventId = bagMqtt.getBagEventId();
		BagEventPublishMessageNotif bn = bagMqtt.getBagEventPublishMessageNotif();
		Bag bag = bn.getBag();
		BaggageActivity baggageActivity = bag.getBaggageActivity();

		if (baggageActivity == null)
			throw new Exception(
					" The parameter baggageActivity of the method inserBaggageActivity of the class BaggageActivityPersistence is null !");

		String activitySequenceOrdinal 	=  (baggageActivity.getActivitySequenceOrdinal() != null)?baggageActivity.getActivitySequenceOrdinal():"";
		String activityActualDateTime 	= (baggageActivity.getActivityActualDateTime() != null)?baggageActivity.getActivityActualDateTime():"";
		String activityEarliestDateTime = (baggageActivity.getActivityEarliestDateTime() != null)?baggageActivity.getActivityEarliestDateTime():"";
		String activitySecondaryCode 	=  (baggageActivity.getActivitySecondaryCode() != null)?baggageActivity.getActivitySecondaryCode():"";
		String activityDescriptionText 	= (baggageActivity.getActivityDescriptionText() != null)?baggageActivity.getActivityDescriptionText():"";
		String activityLatestDateTime 	=  (baggageActivity.getActivityLatestDateTime() != null)?baggageActivity.getActivityLatestDateTime():"";
		String baggageActivityCode 		= (baggageActivity.getBaggageActivityCode() != null)?baggageActivity.getBaggageActivityCode():"";


		PreparedStatement prepared = session
				.prepare("insert into BaggageEvent.BaggageActivity"
						+ "( "
						+" BagEvenId, activitySequenceOrdinal , ActivityActualDateTime , ActivityEarliestDateTime , "
						+" ActivitySecondaryCode , ActivityDescriptionText , BaggageActivityCode, ActivityLatestDateTime,  "
						+ " BaggageActivityDate"
						+ "  ) "
						+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) ");

		BoundStatement bound = prepared.bind(bagEventId, activitySequenceOrdinal, activityActualDateTime, activityEarliestDateTime, activitySecondaryCode,
											activityDescriptionText, activityLatestDateTime, baggageActivityCode);
											bound.setTimestamp(8, new Date());
		session.execute(bound);
	}

	public Map<String, BaggageActivity> selectBaggageActivity(Session session) throws Exception {
		logger.info("--> selectBaggageActivity ");
		Map<String, BaggageActivity> map = new HashMap<String, BaggageActivity>();

		ResultSet resultSet = session.execute("SELECT "
				+" BagEvenId, activitySequenceOrdinal , ActivityActualDateTime , ActivityEarliestDateTime , "
				+" ActivitySecondaryCode , ActivityDescriptionText , BaggageActivityCode, ActivityLatestDateTime,  "
				+ " BaggageActivityDate"
				+ " FROM BaggageEvent.BaggageActivity ");
		logger.info(" RESULT FROM CASSANDRA ");

		String BagEventId = null;
		String activityActualDateTime = null;
		String activityDescriptionText = null;
		String activityEarliestDateTime = null;
		String activityLatestDateTime =  null;
		String activitySecondaryCode =  null;
		String activitySequenceOrdinal =  null;
		String baggageActivityCode = null;
		String bagEventDate = null;

		for (Row row : (ResultSet) resultSet) {

			BagEventId = row.getString("BagEvenId");
			activityActualDateTime = row.getString("activitySequenceOrdinal");
			activityDescriptionText = row.getString("ActivityActualDateTime");
			activityEarliestDateTime = row.getString("ActivityEarliestDateTime");
			activityLatestDateTime =  row.getString("ActivitySecondaryCode");
			activitySecondaryCode =  row.getString("ActivityDescriptionText");
			activitySequenceOrdinal =  row.getString("BaggageActivityCode");
			baggageActivityCode = row.getString("ActivityLatestDateTime");
			bagEventDate = "" + row.getTimestamp(1);

			BaggageActivity baggageActivity = new BaggageActivity();

			baggageActivity.setActivityActualDateTime(activityActualDateTime);
			baggageActivity.setActivityDescriptionText(activityDescriptionText);
			baggageActivity.setActivityEarliestDateTime(activityEarliestDateTime);
			baggageActivity.setActivityLatestDateTime(activityLatestDateTime);
			baggageActivity.setActivitySecondaryCode(activitySecondaryCode);
			baggageActivity.setActivitySequenceOrdinal(activitySequenceOrdinal);
			baggageActivity.setBaggageActivityCode(baggageActivityCode);
			
			map.put(BagEventId, baggageActivity);
			logger.info(" resultset  BagEventId:" + BagEventId + " --  baggageActivity: " + baggageActivity);
		}

		return map;
	}
}
