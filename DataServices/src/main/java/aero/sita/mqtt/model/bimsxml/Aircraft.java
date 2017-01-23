package aero.sita.mqtt.model.bimsxml;

public class Aircraft {
	private String RegistrationID;

	private String RegistrationPrefixCode;

	public String getRegistrationID() {
		return RegistrationID;
	}

	public void setRegistrationID(String RegistrationID) {
		this.RegistrationID = RegistrationID;
	}

	public String getRegistrationPrefixCode() {
		return RegistrationPrefixCode;
	}

	public void setRegistrationPrefixCode(String RegistrationPrefixCode) {
		this.RegistrationPrefixCode = RegistrationPrefixCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((RegistrationID == null) ? 0 : RegistrationID.hashCode());
		result = prime * result + ((RegistrationPrefixCode == null) ? 0 : RegistrationPrefixCode.hashCode());
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
		Aircraft other = (Aircraft) obj;
		if (RegistrationID == null) {
			if (other.RegistrationID != null)
				return false;
		} else if (!RegistrationID.equals(other.RegistrationID))
			return false;
		if (RegistrationPrefixCode == null) {
			if (other.RegistrationPrefixCode != null)
				return false;
		} else if (!RegistrationPrefixCode.equals(other.RegistrationPrefixCode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ClassPojo [RegistrationID = " + RegistrationID + ", RegistrationPrefixCode = " + RegistrationPrefixCode
				+ "]";
	}
}