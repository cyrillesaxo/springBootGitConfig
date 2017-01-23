package aero.sita.model;

import java.io.InputStream;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import aero.sita.generated.BagPublishNotif;
import aero.sita.generated.ObjectFactory;

public class BagPublishNotifFactory {
	
	private BagPublishNotif cl;
	
	public BagPublishNotif get() throws Exception{
        final JAXBContext jaxbContext = JAXBContext
                .newInstance(ObjectFactory.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        InputStream in = getClass().getResourceAsStream("BagEventPublishMessageNotif.xml");
        cl = (BagPublishNotif) jaxbUnmarshaller.unmarshal(in);
        return cl;
	}
	
	public void printContacts(BagPublishNotif bag){
		
		System.out.println("#################  UNMARSHALLED DATA ######################");
		
			System.out.println("PassengerNameRecordLocator:"+bag.getBag().getPassenger().getPassengerNameRecordLocator().getValue());
			System.out.println("AssignedPerson TitleName:"+ bag.getBag().getPassenger().getAssignedPerson().getTitleName().getValue());
			System.out.println("AssignedPerson GivenName:"+ bag.getBag().getPassenger().getAssignedPerson().getGivenName().getValue());
			System.out.println("AssignedPerson SurName:"+ bag.getBag().getPassenger().getAssignedPerson().getSurName().getValue());
			System.out.println("AssignedPerson BirthDate:"+ bag.getBag().getPassenger().getAssignedPerson().getBirthDate().getYear());
			System.out.println("AssignedPerson GenderCode:"+ bag.getBag().getPassenger().getAssignedPerson().getGenderCode().getValue());
			System.out.println("BagTag TagID:"+ bag.getBag().getBagTag().getTagID().getValue());
			System.out.println("BagPosition AreaID:"+ bag.getBag().getBagPosition().getAreaID().getValue());
			System.out.println("BagSegment SegmentAilineOperatorCode:"+ bag.getBag().getBagSegment().get(0).getSegmentAilineOperatorCode().getValue());
			System.out.println("BagSegment SegmentFlightID:"+ bag.getBag().getBagSegment().get(0).getSegmentAilineOperatorCode().getValue());
			System.out.println("BagSegment SegmentScheduledDepartureDate:"+ bag.getBag().getBagSegment().get(0).getSegmentFlightID().getValue());
			System.out.println("BagSegment SegmentServiceOffer CabinClass:"+ bag.getBag().getBagSegment().get(0).getServiceOffer().getCabinClass().getValue());
			System.out.println("BagSegment GroundTransport CarriageMediumCode:"+ bag.getBag().getBagSegment().get(0).getGroundTransport().getCarriageMediumCode().getValue());

	}
	
}
