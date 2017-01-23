package aero.sita.mqtt.model.bimsxml;

public class Bag {
	private BagPosition BagPosition;

	private BagSegment BagSegment;

	private BagTag BagTag;

	private Passenger Passenger;

	private BaggageActivity BaggageActivity;

	public BagPosition getBagPosition() {
		return BagPosition;
	}

	public void setBagPosition(BagPosition BagPosition) {
		this.BagPosition = BagPosition;
	}

	public BagSegment getBagSegment() {
		return BagSegment;
	}

	public void setBagSegment(BagSegment BagSegment) {
		this.BagSegment = BagSegment;
	}

	public BagTag getBagTag() {
		return BagTag;
	}

	public void setBagTag(BagTag BagTag) {
		this.BagTag = BagTag;
	}

	public Passenger getPassenger() {
		return Passenger;
	}

	public void setPassenger(Passenger Passenger) {
		this.Passenger = Passenger;
	}

	public BaggageActivity getBaggageActivity() {
		return BaggageActivity;
	}

	public void setBaggageActivity(BaggageActivity BaggageActivity) {
		this.BaggageActivity = BaggageActivity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((BagPosition == null) ? 0 : BagPosition.hashCode());
		result = prime * result + ((BagSegment == null) ? 0 : BagSegment.hashCode());
		result = prime * result + ((BagTag == null) ? 0 : BagTag.hashCode());
		result = prime * result + ((BaggageActivity == null) ? 0 : BaggageActivity.hashCode());
		result = prime * result + ((Passenger == null) ? 0 : Passenger.hashCode());
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
		Bag other = (Bag) obj;
		if (BagPosition == null) {
			if (other.BagPosition != null)
				return false;
		} else if (!BagPosition.equals(other.BagPosition))
			return false;
		if (BagSegment == null) {
			if (other.BagSegment != null)
				return false;
		} else if (!BagSegment.equals(other.BagSegment))
			return false;
		if (BagTag == null) {
			if (other.BagTag != null)
				return false;
		} else if (!BagTag.equals(other.BagTag))
			return false;
		if (BaggageActivity == null) {
			if (other.BaggageActivity != null)
				return false;
		} else if (!BaggageActivity.equals(other.BaggageActivity))
			return false;
		if (Passenger == null) {
			if (other.Passenger != null)
				return false;
		} else if (!Passenger.equals(other.Passenger))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ClassPojo [BagPosition = " + BagPosition + ", BagSegment = " + BagSegment + ", BagTag = " + BagTag
				+ ", Passenger = " + Passenger + ", BaggageActivity = " + BaggageActivity + "]";
	}
}