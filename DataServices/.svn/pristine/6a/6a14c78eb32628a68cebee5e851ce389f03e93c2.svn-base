package aero.sita.model.mapper;

import aero.sita.generated.BagPublishNotif;
import aero.sita.generated.BagSegmentType;
import aero.sita.generated.BagSpatialPositionType;
import aero.sita.generated.BagTagLabelType;
import aero.sita.generated.BagType;
import aero.sita.generated.BaggageActivityType;
import aero.sita.generated.PassengerType;
import aero.sita.generated.PersonType;
import aero.sita.mqtt.model.bimsxml.Aircraft;
import aero.sita.mqtt.model.bimsxml.AssignedPerson;
import aero.sita.mqtt.model.bimsxml.Bag;
import aero.sita.mqtt.model.bimsxml.BagEventPublishMessageNotif;
import aero.sita.mqtt.model.bimsxml.BagMqtt;
import aero.sita.mqtt.model.bimsxml.BagPosition;
import aero.sita.mqtt.model.bimsxml.BagSegment;
import aero.sita.mqtt.model.bimsxml.BagTag;
import aero.sita.mqtt.model.bimsxml.BaggageActivity;
import aero.sita.mqtt.model.bimsxml.GroundTransport;
import aero.sita.mqtt.model.bimsxml.Passenger;
import aero.sita.mqtt.model.bimsxml.SegmentArrivalFacility;
import aero.sita.mqtt.model.bimsxml.SegmentDepartureFacility;
import aero.sita.mqtt.model.bimsxml.SegmentSecurityControl;
import aero.sita.mqtt.model.bimsxml.SegmentServiceOffer;

public class BagPublishNotifBagMqttMapper {

	public BagPublishNotif getBagPublishNotif(BagMqtt bagMqtt) {
		BagPublishNotif bagPublishNotif = new BagPublishNotif();

		return bagPublishNotif;
	}

	public BagMqtt getBagMqtt(BagPublishNotif bagPublishNotif) throws Exception {
		if (bagPublishNotif == null)
			throw new Exception(" bagPublishNotif is null");
		String bagEventId;

		BagType bagType = bagPublishNotif.getBag();

		if (bagType == null)
			throw new Exception("bagType is null");
		PassengerType jaxbPassengerType = bagType.getPassenger();
		BaggageActivityType jaxbBaggageActivityType = bagType.getBaggageActivity();
		BagSpatialPositionType jaxbBagSpatialPositionType = bagType.getBagPosition();

		BagSegmentType jaxbBagSegmentType = (bagType.getBagSegment() != null && bagType.getBagSegment().size() > 0)
				? bagType.getBagSegment().get(0) : null;

		BagTagLabelType jaxbBagTagLabelType = bagType.getBagTag();

		if (jaxbPassengerType == null)
			throw new Exception(" jaxbPassengerType is null");
		if (jaxbBaggageActivityType == null)
			throw new Exception(" jaxbBaggageActivityType is null");
		if (jaxbBagSpatialPositionType == null)
			throw new Exception(" jaxbBagSpatialPositionType is null");
		if (jaxbBagSegmentType == null)
			throw new Exception(" jaxbBagSegmentType is null");
		if (jaxbBagTagLabelType == null)
			throw new Exception(" jaxbBagTagLabelType is null");

		AssignedPerson assignedPerson = new AssignedPerson();

		PersonType jaxbPersonType = jaxbPassengerType.getAssignedPerson();
		String passengerNameRecordLocator = (jaxbPassengerType.getPassengerNameRecordLocator() != null
				&& jaxbPassengerType.getPassengerNameRecordLocator().getValue() != null)
						? jaxbPassengerType.getPassengerNameRecordLocator().getValue() : "";

		String genderCode = (jaxbPersonType.getGenderCode() != null && jaxbPersonType.getGenderCode().getValue() != null
				&& jaxbPersonType.getGenderCode().getValue().value() != null)
						? jaxbPersonType.getGenderCode().getValue().value() : "";

		String middleName = (jaxbPersonType.getMiddleName() != null && jaxbPersonType.getMiddleName().get(0) != null
				&& jaxbPersonType.getMiddleName().get(0).getValue() != null)
						? jaxbPersonType.getMiddleName().get(0).getValue() : "";

		String titleName = (jaxbPersonType.getTitleName() != null && jaxbPersonType.getTitleName().getValue() != null)
				? jaxbPersonType.getTitleName().getValue() : "";

		String surName = (jaxbPersonType.getSurName() != null && jaxbPersonType.getSurName().getValue() != null)
				? jaxbPersonType.getSurName().getValue() : "";

		String givenName = (jaxbPersonType.getGivenName() != null && jaxbPersonType.getGivenName().getValue() != null)
				? jaxbPersonType.getGivenName().getValue() : "";

		String birthDate = (jaxbPersonType.getBirthDate() != null && jaxbPersonType.getBirthDate().toString() != null)
				? jaxbPersonType.getBirthDate().toString() : "";

		String activityActualDateTime = (jaxbBaggageActivityType.getActivityActualDateTime() != null
				&& jaxbBaggageActivityType.getActivityActualDateTime().getValue() != null
				&& jaxbBaggageActivityType.getActivityActualDateTime().getValue().toString() != null)
						? jaxbBaggageActivityType.getActivityActualDateTime().getValue().toString() : "";

		String activityDescriptionText = (jaxbBaggageActivityType.getActivityDescriptionText() != null)
				? jaxbBaggageActivityType.getActivityDescriptionText() : "";

		String activityEarliestDateTime = (jaxbBaggageActivityType.getActivityEarliestDateTime() != null
				&& jaxbBaggageActivityType.getActivityEarliestDateTime().getValue() != null
				&& jaxbBaggageActivityType.getActivityEarliestDateTime().getValue().toString() != null)
						? jaxbBaggageActivityType.getActivityEarliestDateTime().getValue().toString() : "";

		String activityLatestDateTime = (jaxbBaggageActivityType.getActivityLatestDateTime() != null
				&& jaxbBaggageActivityType.getActivityLatestDateTime().getValue() != null
				&& jaxbBaggageActivityType.getActivityLatestDateTime().getValue().toString() != null)
						? jaxbBaggageActivityType.getActivityLatestDateTime().getValue().toString() : "";

		String activitySecondaryCode = (jaxbBaggageActivityType.getActivitySecondaryCode() != null
				&& jaxbBaggageActivityType.getActivitySecondaryCode().getValue() != null)
						? jaxbBaggageActivityType.getActivitySecondaryCode().getValue() : "";

		String activitySequenceOrdinal = (jaxbBaggageActivityType.getActivitySequenceOrdinal() != null
				&& jaxbBaggageActivityType.getActivitySequenceOrdinal().toString() != null)
						? jaxbBaggageActivityType.getActivitySequenceOrdinal().toString() : "";

		String baggageActivityCode = (jaxbBaggageActivityType.getBaggageActivityCode() != null
				&& jaxbBaggageActivityType.getBaggageActivityCode().getValue() != null)
						? jaxbBaggageActivityType.getBaggageActivityCode().getValue() : "";

		String areaID = (jaxbBagSpatialPositionType.getAreaID() != null
				&& jaxbBagSpatialPositionType.getAreaID().getValue() != null)
						? jaxbBagSpatialPositionType.getAreaID().getValue() : "";

		String tagID = (jaxbBagTagLabelType.getTagID() != null && jaxbBagTagLabelType.getTagID().getValue() != null)
				? jaxbBagTagLabelType.getTagID().getValue() : "";

		String segmentFlightID = (jaxbBagSegmentType.getSegmentFlightID() != null
				&& jaxbBagSegmentType.getSegmentFlightID().getValue() != null)
						? jaxbBagSegmentType.getSegmentFlightID().getValue() : "";

		String segmentScheduledDepartureDate = (jaxbBagSegmentType.getSegmentScheduledDepartureDate() != null
				&& jaxbBagSegmentType.getSegmentScheduledDepartureDate().getValue() != null
				&& jaxbBagSegmentType.getSegmentScheduledDepartureDate().getValue().toString() != null)
						? jaxbBagSegmentType.getSegmentScheduledDepartureDate().getValue().toString() : "";

		String segmentAilineOperatorCode = (jaxbBagSegmentType.getSegmentAilineOperatorCode() != null
				&& jaxbBagSegmentType.getSegmentAilineOperatorCode().getValue() != null)
						? jaxbBagSegmentType.getSegmentAilineOperatorCode().getValue() : "";

		String segmentServiceOfferCabinClass = (jaxbBagSegmentType.getServiceOffer() != null &&
				jaxbBagSegmentType.getServiceOffer().getCabinClass() != null
				&& jaxbBagSegmentType.getServiceOffer().getCabinClass().getValue() != null)
						? jaxbBagSegmentType.getServiceOffer().getCabinClass().getValue() : "";

		String groundTransportCarriageMediumCode = (jaxbBagSegmentType.getGroundTransport() != null
				&& jaxbBagSegmentType.getGroundTransport().getGroundTransportID() != null
				&& jaxbBagSegmentType.getGroundTransport().getGroundTransportID().getValue() != null)
						? jaxbBagSegmentType.getGroundTransport().getGroundTransportID().getValue() : "";

		String groundTransportGroundTransportID = (jaxbBagSegmentType.getGroundTransport() != null
				&& jaxbBagSegmentType.getGroundTransport().getGroundTransportID() != null
				&& jaxbBagSegmentType.getGroundTransport().getGroundTransportID().getValue() != null)
						? jaxbBagSegmentType.getGroundTransport().getGroundTransportID().getValue() : "";

		String aircraftRegistrationID = (jaxbBagSegmentType.getAircraft() != null
				&& jaxbBagSegmentType.getAircraft().getRegistrationID() != null
				&& jaxbBagSegmentType.getAircraft().getRegistrationID().getValue() != null)
						? jaxbBagSegmentType.getAircraft().getRegistrationID().getValue() : "";

		String aircraftRegistrationPrefixCode = (jaxbBagSegmentType.getAircraft() != null
				&& jaxbBagSegmentType.getAircraft().getRegistrationPrefixCode() != null
				&& jaxbBagSegmentType.getAircraft().getRegistrationPrefixCode().getValue() != null)
						? jaxbBagSegmentType.getAircraft().getRegistrationPrefixCode().getValue() : "";

		String segmentSecurityControlContainerSealed = (jaxbBagSegmentType.getSecurityControl() != null
				&& jaxbBagSegmentType.getSecurityControl().isContainerSealed()) ? "true" : "false";

		String segmentArrivalFacilityAirportCode = (jaxbBagSegmentType.getArrivalAirport() != null
				&& jaxbBagSegmentType.getArrivalAirport().getAirportCode() != null
				&& jaxbBagSegmentType.getArrivalAirport().getAirportCode().getValue() != null)
						? jaxbBagSegmentType.getArrivalAirport().getAirportCode().getValue() : "";

		String segmentDepartureFacilityTerminalID = (jaxbBagSegmentType.getDepartureAirport() != null
				&& jaxbBagSegmentType.getDepartureAirport().getTerminalID() != null
				&& jaxbBagSegmentType.getDepartureAirport().getTerminalID().getValue() != null)
						? jaxbBagSegmentType.getDepartureAirport().getTerminalID().getValue() : "";

		String segmentDepartureFacilityTerminalCheckInIdentfier = null;
		String segmentDepartureFacilityAirportCode = null;

		assignedPerson.setBirthDate(birthDate);
		assignedPerson.setGenderCode(genderCode);
		assignedPerson.setGivenName(givenName);
		assignedPerson.setMiddleName(middleName);
		assignedPerson.setSurName(surName);
		assignedPerson.setTitleName(titleName);

		Passenger passenger = new Passenger();
		passenger.setAssignedPerson(assignedPerson);
		passenger.setPassengerNameRecordLocator(passengerNameRecordLocator);

		BagTag bagTag = new BagTag();
		bagTag.setTagID(tagID);

		BagPosition bagPosition = new BagPosition();
		bagPosition.setAreaID(areaID);

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

		BagSegment bagSegment = new BagSegment();
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

		BaggageActivity baggageActivity = new BaggageActivity();
		baggageActivity.setActivityActualDateTime(activityActualDateTime);
		baggageActivity.setActivityDescriptionText(activityDescriptionText);
		baggageActivity.setActivityEarliestDateTime(activityEarliestDateTime);
		baggageActivity.setActivityLatestDateTime(activityLatestDateTime);
		baggageActivity.setActivitySecondaryCode(activitySecondaryCode);
		baggageActivity.setActivitySequenceOrdinal(activitySequenceOrdinal);
		baggageActivity.setBaggageActivityCode(baggageActivityCode);

		BagMqtt bagMqtt = new BagMqtt();
		BagEventPublishMessageNotif bagEventPublishMessageNotif = new BagEventPublishMessageNotif();
		Bag bag = new Bag();
		bag.setBaggageActivity(baggageActivity);
		bag.setBagPosition(bagPosition);
		bag.setBagSegment(bagSegment);
		bag.setBagTag(bagTag);
		bag.setPassenger(passenger);

		bagEventPublishMessageNotif.setBag(bag);
		bagMqtt.setBagEventPublishMessageNotif(bagEventPublishMessageNotif);

		return bagMqtt;
	}
}
