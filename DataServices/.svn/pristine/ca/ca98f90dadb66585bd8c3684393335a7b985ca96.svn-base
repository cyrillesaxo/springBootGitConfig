package aero.sita.mqtt.model.bimsxml;

public class BagEventPublishMessageNotif {
	private Bag Bag;

	public Bag getBag() {
		return Bag;
	}

	public void setBag(Bag Bag) {
		this.Bag = Bag;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Bag == null) ? 0 : Bag.hashCode());
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
		BagEventPublishMessageNotif other = (BagEventPublishMessageNotif) obj;
		if (Bag == null) {
			if (other.Bag != null)
				return false;
		} else if (!Bag.equals(other.Bag))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BagEventPublishMessageNotif [Bag=" + Bag + "]";
	}
}