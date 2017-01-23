package aero.sita.mqtt.model.bimsxml;

public class Passenger {
	private String PassengerNameRecordLocator;

	private AssignedPerson AssignedPerson;


	public String getPassengerNameRecordLocator() {
		return PassengerNameRecordLocator;
	}

	public void setPassengerNameRecordLocator(String PassengerNameRecordLocator) {
		this.PassengerNameRecordLocator = PassengerNameRecordLocator;
	}

	public AssignedPerson getAssignedPerson() {
		return AssignedPerson;
	}

	public void setAssignedPerson(AssignedPerson AssignedPerson) {
		this.AssignedPerson = AssignedPerson;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((AssignedPerson == null) ? 0 : AssignedPerson.hashCode());
		result = prime * result + ((PassengerNameRecordLocator == null) ? 0 : PassengerNameRecordLocator.hashCode());
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
		Passenger other = (Passenger) obj;
		if (AssignedPerson == null) {
			if (other.AssignedPerson != null)
				return false;
		} else if (!AssignedPerson.equals(other.AssignedPerson))
			return false;
		if (PassengerNameRecordLocator == null) {
			if (other.PassengerNameRecordLocator != null)
				return false;
		} else if (!PassengerNameRecordLocator.equals(other.PassengerNameRecordLocator))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Passenger [PassengerNameRecordLocator=" + PassengerNameRecordLocator + ", AssignedPerson="
				+ AssignedPerson + "]";
	}
}
