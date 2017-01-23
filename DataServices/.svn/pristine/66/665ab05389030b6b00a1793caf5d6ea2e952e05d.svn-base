package aero.sita.model.mapper;

import java.util.List;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import aero.sita.baggage.bim.model.BagEvent;
import aero.sita.mqtt.model.bimsxml.Aircraft;
import aero.sita.mqtt.model.bimsxml.AssignedPerson;
import aero.sita.mqtt.model.bimsxml.Bag;
import aero.sita.mqtt.model.bimsxml.BagEventPublishMessageNotif;
import aero.sita.mqtt.model.bimsxml.BagMqtt;
import aero.sita.mqtt.model.bimsxml.BagPosition;
import aero.sita.mqtt.model.bimsxml.BagSegment;
import aero.sita.mqtt.model.bimsxml.BagTag;
import aero.sita.mqtt.model.bimsxml.BaggageActivity;
import aero.sita.mqtt.model.bimsxml.Passenger;
import aero.sita.mqtt.model.bimsxml.SegmentArrivalFacility;
import aero.sita.mqtt.model.bimsxml.SegmentDepartureFacility;
import aero.sita.mqtt.model.bimsxml.SegmentSecurityControl;
import aero.sita.mqtt.model.bimsxml.SegmentServiceOffer;

public class BagMqttEventBagMapper {
	
	private static final Logger log = LoggerFactory.getLogger(BagMqttEventBagMapper.class);
	private BagMqtt bagMqtt;
	private BagEvent bagEvent;
	
	public BagMqtt bagEventToBagMqtt(BagEvent bagEvent) throws Exception{
		
		//if(! (ex.getIn().getBody(BagEvent.class) instanceof BagEvent)) throw new Exception("The body in the exchange is not BagEvent");
		//BagEvent bagEvent = ex.getIn().getBody(BagEvent.class);
		
		log.info(" --->  bagEventToBagMqtt :" + bagEvent);
		
		if(bagEvent == null) throw new Exception(" bagEvent is nulls");
		
		BagMqtt bagMqtt = new BagMqtt();
		
		List<aero.sita.baggage.bim.model.Passenger> bpassengers = bagEvent.getPaxNameList();
		aero.sita.baggage.bim.model.Passenger  bpassenger = null;
		if( bpassengers != null && bpassengers.size() > 0 )bpassenger = bpassengers.get(0);
		
		String bPassengerMiddleName ="";
		String bPassengerName = "";
		
		if(bpassenger != null){
			bPassengerMiddleName = bpassenger.getFirstName();
			bPassengerName = bpassenger.getLastName();
		}
		
		String passengerNameRecordLocator ="";
		passengerNameRecordLocator =bagEvent.getLocator();
		
		String birthDate = "";
		String genderCode = "";
		String givenName = bPassengerName;
		
		String middleName = bPassengerMiddleName;
		String surName = "";
		String titleName ="";
		
		aero.sita.mqtt.model.bimsxml.AssignedPerson assignedPerson = new AssignedPerson();
		assignedPerson.setBirthDate(birthDate);
		assignedPerson.setGenderCode(genderCode);
		assignedPerson.setGivenName(givenName);
		assignedPerson.setMiddleName(middleName);
		assignedPerson.setSurName(surName);
		assignedPerson.setTitleName(titleName);
		
		aero.sita.mqtt.model.bimsxml.Passenger passenger = new Passenger();
		passenger.setAssignedPerson(assignedPerson);
		passenger.setPassengerNameRecordLocator(passengerNameRecordLocator);
		
		String TagID ="";
		List<String> fqTagNumberList = null;
		fqTagNumberList = bagEvent.getFqTagNumberList();
		if( fqTagNumberList != null  && fqTagNumberList.size() > 0)
			TagID = fqTagNumberList.get(0);
		
		aero.sita.mqtt.model.bimsxml.BagTag bagTag = new BagTag();
		bagTag.setTagID(TagID);
		
		
		
		aero.sita.mqtt.model.bimsxml.Aircraft aircraft = new Aircraft();
		String registrationID = "";
		if( bagEvent.getOutbound() != null) registrationID = bagEvent.getOutbound().getFltNum();
		String registrationPrefixCode ="";
		
		aircraft.setRegistrationID(registrationID);
		aircraft.setRegistrationPrefixCode(registrationPrefixCode);
		
		aero.sita.mqtt.model.bimsxml.GroundTransport groundTransport = new aero.sita.mqtt.model.bimsxml.GroundTransport();
		String carriageMediumCode = "";
		String groundTransportID = "";
		groundTransport.setCarriageMediumCode(carriageMediumCode);
		groundTransport.setGroundTransportID(groundTransportID);
		
		String segmentAilineOperatorCode = "";
		if( bagEvent.getOutbound() != null) segmentAilineOperatorCode = bagEvent.getOutbound().getAirlineCode();
		
		aero.sita.mqtt.model.bimsxml.SegmentArrivalFacility segmentArrivalFacility = new SegmentArrivalFacility();
		
		String arr_airportCode = "";
		if( bagEvent.getOutbound() != null) arr_airportCode =bagEvent.getOutbound().getAirportCode();
		
		segmentArrivalFacility.setAirportCode(arr_airportCode);
		
		aero.sita.mqtt.model.bimsxml.SegmentDepartureFacility segmentDepartureFacility = new SegmentDepartureFacility();
		
		String dep_airportCode = "";
		if( bagEvent.getOnwards() != null &&   bagEvent.getOnwards().size() > 1 && bagEvent.getOnwards().get(0) != null) 
				dep_airportCode = bagEvent.getOnwards().get(0).getAirlineCode();
		segmentDepartureFacility.setAirportCode(dep_airportCode);
		
		String terminalCheckInIdentfier = "";
		segmentDepartureFacility.setTerminalCheckInIdentfier(terminalCheckInIdentfier);
		
		String terminalID = "";
		segmentDepartureFacility.setTerminalID(terminalID);
		
		String segmentFlightID = null;
		if( bagEvent.getOutbound() != null) segmentFlightID = bagEvent.getOutbound().getFltNum();
		
		String segmentScheduledDepartureDate = null;
		if( bagEvent.getOutbound() != null)segmentScheduledDepartureDate = bagEvent.getOutbound().getDate();
			
		aero.sita.mqtt.model.bimsxml.SegmentSecurityControl segmentSecurityControl = new SegmentSecurityControl();
		String containerSealed = "";
		segmentSecurityControl.setContainerSealed(containerSealed);
		aero.sita.mqtt.model.bimsxml.SegmentServiceOffer segmentServiceOffer = new SegmentServiceOffer();
		
		String cabinClass = "";
		if( bagEvent.getOutbound() != null) cabinClass = bagEvent.getOutbound().getClassOfService();
		segmentServiceOffer.setCabinClass(cabinClass);
		
		aero.sita.mqtt.model.bimsxml.BagSegment  bagSegment = new BagSegment();
		bagSegment.setAircraft(aircraft);
		bagSegment.setGroundTransport(groundTransport);
		bagSegment.setSegmentAilineOperatorCode(segmentAilineOperatorCode);
		bagSegment.setSegmentArrivalFacility(segmentArrivalFacility);
		bagSegment.setSegmentDepartureFacility(segmentDepartureFacility);
		bagSegment.setSegmentFlightID(segmentFlightID);
		bagSegment.setSegmentScheduledDepartureDate(segmentScheduledDepartureDate);
		bagSegment.setSegmentSecurityControl(segmentSecurityControl);
		bagSegment.setSegmentServiceOffer(segmentServiceOffer);
		
		
		String areaID ="";
		
		aero.sita.mqtt.model.bimsxml.BagPosition bagPosition = new BagPosition();
		bagPosition.setAreaID(areaID);
		
		
		String activityActualDateTime = "";
		String activityDescriptionText = "";
		String activityEarliestDateTime = "";
		String activityLatestDateTime =  "";
		String activitySecondaryCode =  "";
		String activitySequenceOrdinal =  "";
		String baggageActivityCode = "";
		
		aero.sita.mqtt.model.bimsxml.BaggageActivity baggageActivity = new BaggageActivity();
		baggageActivity.setActivityActualDateTime(activityActualDateTime);
		baggageActivity.setActivityDescriptionText(activityDescriptionText);
		baggageActivity.setActivityEarliestDateTime(activityEarliestDateTime);
		baggageActivity.setActivityLatestDateTime(activityLatestDateTime);
		baggageActivity.setActivitySecondaryCode(activitySecondaryCode);
		baggageActivity.setActivitySequenceOrdinal(activitySequenceOrdinal);
		baggageActivity.setBaggageActivityCode(baggageActivityCode);
		
		aero.sita.mqtt.model.bimsxml.Bag bag = new Bag();
		bag.setBaggageActivity(baggageActivity);
		bag.setBagPosition(bagPosition);
		bag.setBagSegment(bagSegment);
		bag.setBagTag(bagTag);
		bag.setPassenger(passenger);
		
		BagEventPublishMessageNotif bagEventPublishMessageNotif= new BagEventPublishMessageNotif();
		bagEventPublishMessageNotif.setBag(bag);
		
		
		bagMqtt.setBagEventPublishMessageNotif(bagEventPublishMessageNotif);
		return bagMqtt;
	}
	
	public BagEvent bagMqttToBagEvent(BagMqtt bagMqtt){
		log.info(" --->  bagMqttToBagEvent :" + bagMqtt);
		BagEvent bagEvent = new BagEvent();
		
		
		
		/*bagEvent.setAirlineDataSet(airlineDataSet);
		bagEvent.setAirportCode(airportCodeParam);
		bagEvent.setAllFInvalid(allFInvalid);
		bagEvent.setAllIInvalid(allIInvalid);
		bagEvent.setBackChain(backChainParam);
		bagEvent.setBagByPNR(bagByPNRParam);
		bagEvent.setBaggageSourceIndicator(baggageSourceIndicatorParam);
		bagEvent.setBagTagForPNR(bagTagForPNR);
		bagEvent.setBagTagNumber(bagTagNumberParam);
		bagEvent.setBagTagPrinter(bagTagPrinterParam);
		bagEvent.setBagTagPrinter(bagTagPrinterParam);
		bagEvent.setBagWeightDetails(bagWeightDetailsParam);
		bagEvent.setBimVersion(bimVersionParam);
		bagEvent.setDelayed(delayedParam);
		bagEvent.setDepartedFromDate(departedFromDate);
		bagEvent.setEventDetails(eventDetailsParam);
		bagEvent.setEventType(eventTypeParam);
		bagEvent.setExceptionData(exceptionData);
		bagEvent.setForwardChain(forwardChainParam);
		bagEvent.setFqLocator(fqLocatorParam);
		bagEvent.setFqTagNumberList(tagNumberListParam);
		bagEvent.setFreeFormText(freeFormTextParam);
		bagEvent.setFreeFormTextList(freeFormTextListParam);
		bagEvent.setHandlingLocation(handlingLocationParam);
		bagEvent.setInbound(inbound);
		bagEvent.setIrregularity(irregularityParam);
		bagEvent.setIrregularityList(irregularityListParam);
		bagEvent.setIrregularityList1(irregularityListParam);
		bagEvent.setLatitude(latitude);
		bagEvent.setLoadingData(loadingDataParam);
		bagEvent.setLoadSequence(loadSequenceParam);
		bagEvent.setLocator(locatorParam);
		bagEvent.se */
		
		
		return  bagEvent;
	}
	
	public String toString(Exchange ex)throws Exception{
		log.info(" --->  toString :" + ex);
		if(ex == null) throw new Exception(" exchange is null");
		String str = ex.getIn().getBody(String.class);
		log.info(" --->  toString : str " + str);
		String str2 = "BSM\r\n.V/1LLHR\r\n.F/AL001/20AUG/BLR/Y\r\n.O/IT007/21AUG/JFK/Y\r\n.O/AB001/22AUG/MAA/Y\r\n.N/0789511136001\r\n.P/JHON/SMITH\r\n.R/FLIGHT DEPARTED\r\nENDBSM";
		
		if(!str.equalsIgnoreCase(str2))
			log.info("str:"+str+": is different from str2:"+str2);
		return str.trim();
	}
}
