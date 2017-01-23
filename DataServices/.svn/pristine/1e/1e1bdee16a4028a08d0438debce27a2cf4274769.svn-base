package aero.sita.mqtt.model.bimsxml;

public class BagPosition {
	private String AreaID;


	public String getAreaID() {
		return AreaID;
	}

	public void setAreaID(String AreaID) {
		this.AreaID = AreaID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((AreaID == null) ? 0 : AreaID.hashCode());
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
		BagPosition other = (BagPosition) obj;
		if (AreaID == null) {
			if (other.AreaID != null)
				return false;
		} else if (!AreaID.equals(other.AreaID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BagPosition [AreaID=" + AreaID + "]";
	}
}