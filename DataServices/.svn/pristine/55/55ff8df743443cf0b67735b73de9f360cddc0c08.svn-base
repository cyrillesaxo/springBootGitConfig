package aero.sita.mqtt.model.bimsxml;

public class SegmentArrivalFacility {
	private String AirportCode;

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
		SegmentArrivalFacility other = (SegmentArrivalFacility) obj;
		if (AirportCode == null) {
			if (other.AirportCode != null)
				return false;
		} else if (!AirportCode.equals(other.AirportCode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ClassPojo [AirportCode = " + AirportCode + "]";
	}
}