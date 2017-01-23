package aero.sita.mqtt.model.bimsxml;

public class GroundTransport {
	private String CarriageMediumCode;

	private String GroundTransportID;

	public String getCarriageMediumCode() {
		return CarriageMediumCode;
	}

	public void setCarriageMediumCode(String CarriageMediumCode) {
		this.CarriageMediumCode = CarriageMediumCode;
	}

	public String getGroundTransportID() {
		return GroundTransportID;
	}

	public void setGroundTransportID(String GroundTransportID) {
		this.GroundTransportID = GroundTransportID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CarriageMediumCode == null) ? 0 : CarriageMediumCode.hashCode());
		result = prime * result + ((GroundTransportID == null) ? 0 : GroundTransportID.hashCode());
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
		GroundTransport other = (GroundTransport) obj;
		if (CarriageMediumCode == null) {
			if (other.CarriageMediumCode != null)
				return false;
		} else if (!CarriageMediumCode.equals(other.CarriageMediumCode))
			return false;
		if (GroundTransportID == null) {
			if (other.GroundTransportID != null)
				return false;
		} else if (!GroundTransportID.equals(other.GroundTransportID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ClassPojo [CarriageMediumCode = " + CarriageMediumCode + ", GroundTransportID = " + GroundTransportID
				+ "]";
	}
}