package aero.sita.mqtt.model.bimsxml;

public class BagSegment {
	private String SegmentFlightID;

	private SegmentArrivalFacility SegmentArrivalFacility;

	private Aircraft Aircraft;

	private SegmentDepartureFacility SegmentDepartureFacility;

	private SegmentServiceOffer SegmentServiceOffer;

	private GroundTransport GroundTransport;

	private SegmentSecurityControl SegmentSecurityControl;

	private String SegmentAilineOperatorCode;

	private String SegmentScheduledDepartureDate;

	public String getSegmentFlightID() {
		return SegmentFlightID;
	}

	public void setSegmentFlightID(String SegmentFlightID) {
		this.SegmentFlightID = SegmentFlightID;
	}

	public SegmentArrivalFacility getSegmentArrivalFacility() {
		return SegmentArrivalFacility;
	}

	public void setSegmentArrivalFacility(SegmentArrivalFacility SegmentArrivalFacility) {
		this.SegmentArrivalFacility = SegmentArrivalFacility;
	}

	public Aircraft getAircraft() {
		return Aircraft;
	}

	public void setAircraft(Aircraft Aircraft) {
		this.Aircraft = Aircraft;
	}

	public SegmentDepartureFacility getSegmentDepartureFacility() {
		return SegmentDepartureFacility;
	}

	public void setSegmentDepartureFacility(SegmentDepartureFacility SegmentDepartureFacility) {
		this.SegmentDepartureFacility = SegmentDepartureFacility;
	}

	public SegmentServiceOffer getSegmentServiceOffer() {
		return SegmentServiceOffer;
	}

	public void setSegmentServiceOffer(SegmentServiceOffer SegmentServiceOffer) {
		this.SegmentServiceOffer = SegmentServiceOffer;
	}

	public GroundTransport getGroundTransport() {
		return GroundTransport;
	}

	public void setGroundTransport(GroundTransport GroundTransport) {
		this.GroundTransport = GroundTransport;
	}

	public SegmentSecurityControl getSegmentSecurityControl() {
		return SegmentSecurityControl;
	}

	public void setSegmentSecurityControl(SegmentSecurityControl SegmentSecurityControl) {
		this.SegmentSecurityControl = SegmentSecurityControl;
	}

	public String getSegmentAilineOperatorCode() {
		return SegmentAilineOperatorCode;
	}

	public void setSegmentAilineOperatorCode(String SegmentAilineOperatorCode) {
		this.SegmentAilineOperatorCode = SegmentAilineOperatorCode;
	}

	public String getSegmentScheduledDepartureDate() {
		return SegmentScheduledDepartureDate;
	}

	public void setSegmentScheduledDepartureDate(String SegmentScheduledDepartureDate) {
		this.SegmentScheduledDepartureDate = SegmentScheduledDepartureDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Aircraft == null) ? 0 : Aircraft.hashCode());
		result = prime * result + ((GroundTransport == null) ? 0 : GroundTransport.hashCode());
		result = prime * result + ((SegmentAilineOperatorCode == null) ? 0 : SegmentAilineOperatorCode.hashCode());
		result = prime * result + ((SegmentArrivalFacility == null) ? 0 : SegmentArrivalFacility.hashCode());
		result = prime * result + ((SegmentDepartureFacility == null) ? 0 : SegmentDepartureFacility.hashCode());
		result = prime * result + ((SegmentFlightID == null) ? 0 : SegmentFlightID.hashCode());
		result = prime * result
				+ ((SegmentScheduledDepartureDate == null) ? 0 : SegmentScheduledDepartureDate.hashCode());
		result = prime * result + ((SegmentSecurityControl == null) ? 0 : SegmentSecurityControl.hashCode());
		result = prime * result + ((SegmentServiceOffer == null) ? 0 : SegmentServiceOffer.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BagSegment other = (BagSegment) obj;
		if (Aircraft == null) {
			if (other.Aircraft != null)
				return false;
		} else if (!Aircraft.equals(other.Aircraft))
			return false;
		if (GroundTransport == null) {
			if (other.GroundTransport != null)
				return false;
		} else if (!GroundTransport.equals(other.GroundTransport))
			return false;
		if (SegmentAilineOperatorCode == null) {
			if (other.SegmentAilineOperatorCode != null)
				return false;
		} else if (!SegmentAilineOperatorCode.equals(other.SegmentAilineOperatorCode))
			return false;
		if (SegmentArrivalFacility == null) {
			if (other.SegmentArrivalFacility != null)
				return false;
		} else if (!SegmentArrivalFacility.equals(other.SegmentArrivalFacility))
			return false;
		if (SegmentDepartureFacility == null) {
			if (other.SegmentDepartureFacility != null)
				return false;
		} else if (!SegmentDepartureFacility.equals(other.SegmentDepartureFacility))
			return false;
		if (SegmentFlightID == null) {
			if (other.SegmentFlightID != null)
				return false;
		} else if (!SegmentFlightID.equals(other.SegmentFlightID))
			return false;
		if (SegmentScheduledDepartureDate == null) {
			if (other.SegmentScheduledDepartureDate != null)
				return false;
		} else if (!SegmentScheduledDepartureDate.equals(other.SegmentScheduledDepartureDate))
			return false;
		if (SegmentSecurityControl == null) {
			if (other.SegmentSecurityControl != null)
				return false;
		} else if (!SegmentSecurityControl.equals(other.SegmentSecurityControl))
			return false;
		if (SegmentServiceOffer == null) {
			if (other.SegmentServiceOffer != null)
				return false;
		} else if (!SegmentServiceOffer.equals(other.SegmentServiceOffer))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BagSegment [SegmentFlightID=" + SegmentFlightID + ", SegmentArrivalFacility=" + SegmentArrivalFacility
				+ ", Aircraft=" + Aircraft + ", SegmentDepartureFacility=" + SegmentDepartureFacility
				+ ", SegmentServiceOffer=" + SegmentServiceOffer + ", GroundTransport=" + GroundTransport
				+ ", SegmentSecurityControl=" + SegmentSecurityControl + ", SegmentAilineOperatorCode="
				+ SegmentAilineOperatorCode + ", SegmentScheduledDepartureDate=" + SegmentScheduledDepartureDate + "]";
	}
}
