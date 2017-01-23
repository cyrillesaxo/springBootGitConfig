package aero.sita.mqtt.model.bimsxml;

public class SegmentServiceOffer {
	private String CabinClass;

	public String getCabinClass() {
		return CabinClass;
	}

	public void setCabinClass(String CabinClass) {
		this.CabinClass = CabinClass;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CabinClass == null) ? 0 : CabinClass.hashCode());
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
		SegmentServiceOffer other = (SegmentServiceOffer) obj;
		if (CabinClass == null) {
			if (other.CabinClass != null)
				return false;
		} else if (!CabinClass.equals(other.CabinClass))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ClassPojo [CabinClass = " + CabinClass + "]";
	}
}