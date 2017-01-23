package aero.sita.mqtt.model.bimsxml;

public class SegmentSecurityControl {
	private String ContainerSealed;

	public String getContainerSealed() {
		return ContainerSealed;
	}

	public void setContainerSealed(String ContainerSealed) {
		this.ContainerSealed = ContainerSealed;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ContainerSealed == null) ? 0 : ContainerSealed.hashCode());
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
		SegmentSecurityControl other = (SegmentSecurityControl) obj;
		if (ContainerSealed == null) {
			if (other.ContainerSealed != null)
				return false;
		} else if (!ContainerSealed.equals(other.ContainerSealed))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ClassPojo [ContainerSealed = " + ContainerSealed + "]";
	}
}