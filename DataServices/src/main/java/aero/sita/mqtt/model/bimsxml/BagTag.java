package aero.sita.mqtt.model.bimsxml;

public class BagTag {
	private String TagID;


	public String getTagID() {
		return TagID;
	}

	public void setTagID(String TagID) {
		this.TagID = TagID;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((TagID == null) ? 0 : TagID.hashCode());
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
		BagTag other = (BagTag) obj;
		if (TagID == null) {
			if (other.TagID != null)
				return false;
		} else if (!TagID.equals(other.TagID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BagTag [TagID=" + TagID + "]";
	}
}