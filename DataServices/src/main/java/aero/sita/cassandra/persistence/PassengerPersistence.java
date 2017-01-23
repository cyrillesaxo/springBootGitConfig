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

import aero.sita.casandra.persistence.repository.PassengerRepository;
import aero.sita.mqtt.model.bimsxml.AssignedPerson;
import aero.sita.mqtt.model.bimsxml.Bag;
import aero.sita.mqtt.model.bimsxml.BagEventPublishMessageNotif;
import aero.sita.mqtt.model.bimsxml.BagMqtt;
import aero.sita.mqtt.model.bimsxml.Passenger;
import aero.sita.mqtt.model.bimsxml.Tool;

public class PassengerPersistence extends CassandraConnector implements PassengerRepository {

	private static final Logger logger = LoggerFactory.getLogger(PassengerPersistence.class);


	public void insertPassenger(BagMqtt bagMqtt, Session session) throws Exception {
		logger.info("--> insertLocation Passenger :" + bagMqtt);
		Tool.validate(bagMqtt);
		
		String bagEventId = bagMqtt.getBagEventId();
		BagEventPublishMessageNotif bn = bagMqtt.getBagEventPublishMessageNotif();
		Bag bag = bn.getBag();
		Passenger passenger = bag.getPassenger();
		
		if (passenger == null)
			throw new Exception(" The parameter passenger of the method inserLocation of the class PassengerPersistence is null !");

		AssignedPerson assignedPerson = passenger.getAssignedPerson();
		String passengerNameRecordLocator = (passenger.getPassengerNameRecordLocator() != null)?passenger.getPassengerNameRecordLocator():"" ;
		String genderCode ="";
		String middleName ="";
		String titleName ="";
		String surName ="";
		String givenName ="";
		String birthDate =""; 
		
		if( assignedPerson  != null){
				genderCode = (assignedPerson.getGenderCode() != null)?assignedPerson.getGenderCode():"";
				middleName = (assignedPerson.getMiddleName() != null)?assignedPerson.getMiddleName():"";
				titleName = (assignedPerson.getTitleName() != null)?assignedPerson.getTitleName():"";
				surName = (assignedPerson.getSurName() != null)?assignedPerson.getSurName():"";
				givenName = (assignedPerson.getGivenName() != null)?assignedPerson.getGivenName():"";
				birthDate = (assignedPerson.getBirthDate() != null)?assignedPerson.getBirthDate():""; 
		}
		

		PreparedStatement prepared = session.prepare(
				"insert into BaggageEvent.Passenger"
				+ "( BagEventId ,PassengerNameRecordLocator ,GenderCode ,MiddleName ,"
				+ "  TitleName ,SurName ,GivenName ,BirthDate , BagEventDate ) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) ");

		
		BoundStatement bound = prepared.bind(bagEventId ,passengerNameRecordLocator ,genderCode ,middleName, 
								titleName ,surName ,givenName ,birthDate );
								bound.setTimestamp(8, new Date());
		session.execute(bound);
	}


	public Map<String, Passenger> selectPassenger(Session session) throws Exception {
		Map<String, Passenger> map = new HashMap<String, Passenger>();
		
		ResultSet resultSet = session.execute("SELECT * FROM BaggageEvent.Passenger ");
		logger.info(" RESULT FROM CASSANDRA ");
		
		String BagEventId = null;
		Passenger passenger;
		AssignedPerson assignedPerson = null;
		String passengerNameRecordLocator = null;
		String genderCode =null;
		String middleName =null;
		String titleName =null;
		String surName =null;
		String givenName =null;
		String birthDate =null; 
		String bagEventDate = null;

		for (Row row : (ResultSet) resultSet) {

			
			BagEventId= row.getString("BagEventId");
			passengerNameRecordLocator = row.getString("passengerNameRecordLocator");
			genderCode = row.getString("genderCode");
			middleName = row.getString("middleName");
			titleName = row.getString("titleName");
			surName = row.getString("surName");
			givenName = row.getString("givenName");
			birthDate = row.getString("birthDate");
			bagEventDate = "" + row.getTimestamp(1);

			assignedPerson = new AssignedPerson();
			assignedPerson.setGenderCode(genderCode);
			assignedPerson.setMiddleName(middleName);
			assignedPerson.setTitleName(titleName);
			assignedPerson.setSurName(surName);
			assignedPerson.setGivenName(givenName);
			assignedPerson.setBirthDate(birthDate);
			
			passenger = new Passenger();
			
			passenger.setAssignedPerson(assignedPerson);
			passenger.setPassengerNameRecordLocator(passengerNameRecordLocator);
			map.put(BagEventId, passenger);
			logger.info(" resultset  BagEventId:"+BagEventId+" --  passenger: "+passenger);

		}
		
		return map;
	}
}
