package aero.sita.mqtt.model.bimsxml;

public class SegmentDepartureFacility {
	private String TerminalID;

	private String TerminalCheckInIdentfier;

	private String AirportCode;

	public String getTerminalID() {
		return TerminalID;
	}

	public void setTerminalID(String TerminalID) {
		this.TerminalID = TerminalID;
	}

	public String getTerminalCheckInIdentfier() {
		return TerminalCheckInIdentfier;
	}

	public void setTerminalCheckInIdentfier(String TerminalCheckInIdentfier) {
		this.TerminalCheckInIdentfier = TerminalCheckInIdentfier;
	}

	public String getAirportCode() {
		return AirportCode;
	}

	public void setAirportCode(String AirportCode) {
		this.AirportCode = AirportCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((AirportCode == null) ? 0 : AirportCode.hashCode());
		result = prime * result + ((TerminalCheckInIdentfier == null) ? 0 : TerminalCheckInIdentfier.hashCode());
		result = prime * result + ((TerminalID == null) ? 0 : TerminalID.hashCode());
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
		SegmentDepartureFacility other = (SegmentDepartureFacility) obj;
		if (AirportCode == null) {
			if (other.AirportCode != null)
				return false;
		} else if (!AirportCode.equals(other.AirportCode))
			return false;
		if (TerminalCheckInIdentfier == null) {
			if (other.TerminalCheckInIdentfier != null)
				return false;
		} else if (!TerminalCheckInIdentfier.equals(other.TerminalCheckInIdentfier))
			return false;
		if (TerminalID == null) {
			if (other.TerminalID != null)
				return false;
		} else if (!TerminalID.equals(other.TerminalID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ClassPojo [TerminalID = " + TerminalID + ", TerminalCheckInIdentfier = " + TerminalCheckInIdentfier
				+ ", AirportCode = " + AirportCode + "]";
	}
}
