package aero.sita.cassandra.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import aero.sita.casandra.persistence.repository.BagMqttRepository;
import aero.sita.mqtt.model.bimsxml.Bag;
import aero.sita.mqtt.model.bimsxml.BagEventPublishMessageNotif;
import aero.sita.mqtt.model.bimsxml.BagMqtt;
import aero.sita.mqtt.model.bimsxml.BagPosition;
import aero.sita.mqtt.model.bimsxml.BagSegment;
import aero.sita.mqtt.model.bimsxml.BagTag;
import aero.sita.mqtt.model.bimsxml.BaggageActivity;
import aero.sita.mqtt.model.bimsxml.Passenger;

public class BagMqttPersistence extends CassandraConnector implements BagMqttRepository{

	private static final Logger logger = LoggerFactory.getLogger(BagMqttPersistence.class);
	
	private PassengerPersistence  passengerPersistence;
	private BagTagPersistence bagTagPersistence;
	private BagPositionPersistence bagPositionPersistence;
	private BagSegmentPersistence bagSegmentPersistence;
	private BaggageActivityPersistence baggageActivityPersistence;
	
	public BagMqttPersistence(){
		this.connect();
		passengerPersistence 		= new PassengerPersistence();
		bagTagPersistence 			= new BagTagPersistence();
		bagPositionPersistence 		= new BagPositionPersistence();
		bagSegmentPersistence 		= new BagSegmentPersistence();
		baggageActivityPersistence 	= new BaggageActivityPersistence();
	}
	
	public void insertBagMqtt(Exchange ex)throws Exception {
		logger.info("--> InsertBagMqtt  exchange:"+ex);
		
		if(!(ex.getIn().getBody(BagMqtt.class) instanceof BagMqtt))throw new Exception(" The parameter provided in the method insertBagMqtt is not BagMqtt !");
		BagMqtt bagMqtt =  (BagMqtt)ex.getIn().getBody(BagMqtt.class);
		
		if(bagMqtt ==null)throw new Exception(" bagMqtt parameter is null!");
		logger.debug("parameter  bagMqtt:"+bagMqtt);
		
		passengerPersistence.insertPassenger(bagMqtt,this.getSession());
		bagTagPersistence.insertBagTag(bagMqtt,this.getSession());
		bagPositionPersistence.insertBagPosition(bagMqtt,this.getSession());
		bagSegmentPersistence.insertBagSegment(bagMqtt,this.getSession());
		baggageActivityPersistence.insertBaggageActivity(bagMqtt,this.getSession());
		
	}
	
	public List<BagMqtt> selectBagMqtt(Exchange ex)throws Exception{
		logger.info("--> selectBagMqtt ");
		
		List<BagMqtt> listOfBagMqtt = new ArrayList<BagMqtt>();
		BagMqtt bagMqtt = null;
		BagEventPublishMessageNotif bagEventPublishMessageNotif = null;
		Bag bag  = null;
		String bagEventId;
		
		Passenger passenger = null;
		BagTag bagTag = null;
		BagPosition bagPosition = null;
		BagSegment bagSegment = null;
		BaggageActivity baggageActivity=null;
		
		Map<String,Passenger> listOfPassenger = passengerPersistence.selectPassenger(this.getSession());
		Map<String,BagTag> listOfPassengerBagTag = bagTagPersistence.selectBagTag(this.getSession());
		Map<String,BagPosition> listOfBagPositionPersistence = bagPositionPersistence.selectBagPosition(this.getSession());
		Map<String,BagSegment> listOfBagSegmentPersistence = bagSegmentPersistence.selectBagSegment(this.getSession());
		Map<String,BaggageActivity> listOfBaggageActivityPersistence = baggageActivityPersistence.selectBaggageActivity(this.getSession());
		
		for(String _bagEventId: listOfPassenger.keySet()){
			bagEventId = _bagEventId;
			bagMqtt = new BagMqtt();
			bagEventPublishMessageNotif = new BagEventPublishMessageNotif();
			bag = new Bag();
			
			passenger 		= listOfPassenger.get(bagEventId);
			bagTag			= listOfPassengerBagTag.get(bagEventId);
			bagPosition 	= listOfBagPositionPersistence.get(bagEventId);
			bagSegment 		= listOfBagSegmentPersistence.get(bagEventId);
			baggageActivity = listOfBaggageActivityPersistence.get(bagEventId);			
			
			bag.setBaggageActivity(baggageActivity);
			bag.setBagPosition(bagPosition);
			bag.setBagSegment(bagSegment);
			bag.setBagTag(bagTag);
			bag.setPassenger(passenger);
			
			bagEventPublishMessageNotif.setBag(bag);
			bagMqtt.setBagEventPublishMessageNotif(bagEventPublishMessageNotif);
			listOfBagMqtt.add(bagMqtt);
			
			logger.debug(" --> selectBagMqtt bagEventId:"+bagEventId+" - BagMqtt:"+bagMqtt);
		}
		
		return listOfBagMqtt;
	}
}
