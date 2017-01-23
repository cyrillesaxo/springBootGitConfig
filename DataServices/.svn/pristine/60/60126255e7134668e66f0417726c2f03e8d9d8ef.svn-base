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

import aero.sita.casandra.persistence.repository.BagSegmentRepository;
import aero.sita.mqtt.model.bimsxml.Aircraft;
import aero.sita.mqtt.model.bimsxml.Bag;
import aero.sita.mqtt.model.bimsxml.BagEventPublishMessageNotif;
import aero.sita.mqtt.model.bimsxml.BagMqtt;
import aero.sita.mqtt.model.bimsxml.BagSegment;
import aero.sita.mqtt.model.bimsxml.GroundTransport;
import aero.sita.mqtt.model.bimsxml.SegmentArrivalFacility;
import aero.sita.mqtt.model.bimsxml.SegmentDepartureFacility;
import aero.sita.mqtt.model.bimsxml.SegmentSecurityControl;
import aero.sita.mqtt.model.bimsxml.SegmentServiceOffer;
import aero.sita.mqtt.model.bimsxml.Tool;

public class BagSegmentPersistence extends CassandraConnector implements BagSegmentRepository {

	private static final Logger logger = LoggerFactory.getLogger(BagSegmentPersistence.class);

	public void insertBagSegment(BagMqtt bagMqtt, Session session) throws Exception {
		logger.info("--> insertBagSegment BagMqtt :" + bagMqtt);
		Tool.validate(bagMqtt);

		String bagEvenId = bagMqtt.getBagEventId();
		BagEventPublishMessageNotif bn = bagMqtt.getBagEventPublishMessageNotif();
		Bag bag = bn.getBag();
		BagSegment bagSegment = bag.getBagSegment();

		if (bagSegment == null)
			throw new Exception(
					" The parameter bagSegment of the method inserBagSegment of the class BagSegmentPersistence is null !");

		String 	SegmentAilineOperatorCode = (bagSegment.getSegmentAilineOperatorCode() != null)?bagSegment.getSegmentAilineOperatorCode():"";
		
		String SegmentFlightID = (bagSegment.getSegmentFlightID() != null)?bagSegment.getSegmentFlightID():"";
		String SegmentScheduledDepartureDate = bagSegment.getSegmentScheduledDepartureDate();
		
		
		SegmentServiceOffer segmentServiceOffer =bagSegment.getSegmentServiceOffer(); 
		String SegmentServiceOfferCabinClass ="";
		SegmentServiceOfferCabinClass = (segmentServiceOffer != null && segmentServiceOffer.getCabinClass() != null)?segmentServiceOffer.getCabinClass():"";
		
		String GroundTransportCarriageMediumCode = "";
		String GroundTransportGroundTransportID = "";
		GroundTransport groundTransport = new GroundTransport();
		groundTransport.setCarriageMediumCode(GroundTransportCarriageMediumCode);
		groundTransport.setGroundTransportID(GroundTransportGroundTransportID);
		
		String AircraftRegistrationPrefixCode = "";
		String AircraftRegistrationID = "";
		Aircraft aircraft = bagSegment.getAircraft();
		if(aircraft != null){
			AircraftRegistrationPrefixCode = aircraft.getRegistrationPrefixCode();
			AircraftRegistrationID = aircraft.getRegistrationID();
		}
		
		String SegmentSecurityControlContainerSealed = "";
		SegmentSecurityControl segmentSecurityControl = bagSegment.getSegmentSecurityControl();
		if(segmentSecurityControl != null){
			SegmentSecurityControlContainerSealed = segmentSecurityControl.getContainerSealed();
		}
		
		String SegmentArrivalFacilityAirportCode = "";
		SegmentArrivalFacility segmentArrivalFacility = bagSegment.getSegmentArrivalFacility();
		if( segmentArrivalFacility != null){
			SegmentArrivalFacilityAirportCode = segmentArrivalFacility.getAirportCode();
		}	
		
		String SegmentDepartureFacilityAirportCode = "";
		String SegmentDepartureFacilityTerminalID = "";
		String SegmentDepartureFacilityTerminalCheckInIdentfier = "";
		SegmentDepartureFacility segmentDepartureFacility = bagSegment.getSegmentDepartureFacility();
		if( segmentDepartureFacility != null){
				SegmentDepartureFacilityAirportCode = segmentDepartureFacility.getAirportCode();
				SegmentDepartureFacilityTerminalID = segmentDepartureFacility.getTerminalID();
				SegmentDepartureFacilityTerminalCheckInIdentfier = segmentDepartureFacility.getTerminalCheckInIdentfier();
		}
		
		
		PreparedStatement prepared = session
				.prepare("insert into BaggageEvent.BagSegment"
						+ "( "
						+" 	BagEvenId , "
						+" 	SegmentFlightID , "
						+" 	SegmentScheduledDepartureDate , "
						+" 	SegmentAilineOperatorCode , "
						+" 	SegmentServiceOfferCabinClass , "
						+" 	GroundTransportCarriageMediumCode , "
						+" 	GroundTransportGroundTransportID ,	 "
						+" 	AircraftRegistrationID , "
						+" 	AircraftRegistrationPrefixCode , "
						+" 	SegmentSecurityControlContainerSealed , "
						+" 	SegmentArrivalFacilityAirportCode ,	 "
						+" 	SegmentDepartureFacilityTerminalID , "
						+" 	SegmentDepartureFacilityTerminalCheckInIdentfier , "
						+" 	SegmentDepartureFacilityAirportCode ,	 "
						+" 	BagSegmentDate "
						+ "  ) "
						+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");

		BoundStatement bound = prepared.bind(
												bagEvenId ,
												SegmentFlightID ,
												SegmentScheduledDepartureDate ,
												SegmentAilineOperatorCode ,
												SegmentServiceOfferCabinClass ,
												GroundTransportCarriageMediumCode ,
												GroundTransportGroundTransportID ,	
												AircraftRegistrationID ,
												AircraftRegistrationPrefixCode ,
												SegmentSecurityControlContainerSealed ,
												SegmentArrivalFacilityAirportCode ,	
												SegmentDepartureFacilityTerminalID ,
												SegmentDepartureFacilityTerminalCheckInIdentfier ,
												SegmentDepartureFacilityAirportCode 	
											);
									bound.setTimestamp(14, new Date());
		session.execute(bound);
	}

	public Map<String, BagSegment> selectBagSegment(Session session) throws Exception {
		logger.info("--> selectBagSegment ");
		
		Map<String, BagSegment> map = new HashMap<String, BagSegment>();

		ResultSet resultSet = session.execute("SELECT * FROM BaggageEvent.BagSegment ");
		logger.info(" RESULT FROM CASSANDRA ");

		String bagEvenId = null;
		String segmentFlightID = null;
		String segmentScheduledDepartureDate = null;
		String segmentAilineOperatorCode = null;
		String segmentServiceOfferCabinClass = null;
		String groundTransportCarriageMediumCode = null;
		String groundTransportGroundTransportID = null;	
		String aircraftRegistrationID = null;
		String aircraftRegistrationPrefixCode = null;
		String segmentSecurityControlContainerSealed = null;
		String segmentArrivalFacilityAirportCode = null;	
		String segmentDepartureFacilityTerminalID = null;
		String segmentDepartureFacilityTerminalCheckInIdentfier = null;
		String segmentDepartureFacilityAirportCode = null;
		BagSegment bagSegment = null;

		for (Row row : (ResultSet) resultSet) {

			bagEvenId = row.getString("BagEventId");
			segmentFlightID = row.getString("BagEventId");
			segmentScheduledDepartureDate = row.getString("BagEventId");
			segmentAilineOperatorCode = row.getString("BagEventId");
			segmentServiceOfferCabinClass = row.getString("BagEventId");
			groundTransportCarriageMediumCode = row.getString("BagEventId");
			groundTransportGroundTransportID = row.getString("BagEventId");	
			aircraftRegistrationID = row.getString("BagEventId");
			aircraftRegistrationPrefixCode = row.getString("BagEventId");
			segmentSecurityControlContainerSealed = row.getString("BagEventId");
			segmentArrivalFacilityAirportCode = row.getString("BagEventId");	
			segmentDepartureFacilityTerminalID = row.getString("BagEventId");
			segmentDepartureFacilityTerminalCheckInIdentfier = row.getString("BagEventId");
			segmentDepartureFacilityAirportCode  = row.getString("BagEventId");
			
			
			SegmentServiceOffer segmentServiceOffer = new SegmentServiceOffer();
			segmentServiceOffer.setCabinClass(segmentServiceOfferCabinClass);
			
			
			GroundTransport groundTransport = new GroundTransport();
			groundTransport.setCarriageMediumCode(groundTransportCarriageMediumCode);
			groundTransport.setGroundTransportID(groundTransportGroundTransportID);
			
			Aircraft aircraft = new Aircraft();
			aircraft.setRegistrationID(aircraftRegistrationID);
			aircraft.setRegistrationPrefixCode(aircraftRegistrationPrefixCode);
			
			SegmentArrivalFacility segmentArrivalFacility = new SegmentArrivalFacility();
			segmentArrivalFacility.setAirportCode(segmentArrivalFacilityAirportCode);
			
			SegmentDepartureFacility segmentDepartureFacility = new SegmentDepartureFacility();
			segmentDepartureFacility.setAirportCode(segmentDepartureFacilityAirportCode);
			segmentDepartureFacility.setTerminalCheckInIdentfier(segmentDepartureFacilityTerminalCheckInIdentfier);
			segmentDepartureFacility.setTerminalID(segmentDepartureFacilityTerminalID);
			
			
			SegmentSecurityControl segmentSecurityControl = new SegmentSecurityControl();
			segmentSecurityControl.setContainerSealed(segmentSecurityControlContainerSealed);
			
			bagSegment  = new BagSegment();
			bagSegment.setSegmentServiceOffer(segmentServiceOffer);
			bagSegment.setAircraft(aircraft);
			bagSegment.setGroundTransport(groundTransport);
			bagSegment.setSegmentAilineOperatorCode(segmentAilineOperatorCode);
			bagSegment.setSegmentArrivalFacility(segmentArrivalFacility);
			bagSegment.setSegmentDepartureFacility(segmentDepartureFacility);
			bagSegment.setSegmentFlightID(segmentFlightID);
			bagSegment.setSegmentScheduledDepartureDate(segmentScheduledDepartureDate);
			bagSegment.setSegmentSecurityControl(segmentSecurityControl);
			bagSegment.setSegmentServiceOffer(segmentServiceOffer);
			
			map.put(bagEvenId, bagSegment);
			logger.info(" resultset  BagEventId:" + bagEvenId + " --  bagSegment: " + bagSegment);

		}

		return map;
	}
}
