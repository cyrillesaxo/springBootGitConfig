package aero.sita.mqtt.model.bimsxml;

public class BaggageActivity {
	private String ActivitySequenceOrdinal;

	private String ActivityActualDateTime;

	private String ActivityEarliestDateTime;

	private String ActivitySecondaryCode;

	private String ActivityDescriptionText;

	private String BaggageActivityCode;

	private String ActivityLatestDateTime;

	public String getActivitySequenceOrdinal() {
		return ActivitySequenceOrdinal;
	}

	public void setActivitySequenceOrdinal(String ActivitySequenceOrdinal) {
		this.ActivitySequenceOrdinal = ActivitySequenceOrdinal;
	}

	public String getActivityActualDateTime() {
		return ActivityActualDateTime;
	}

	public void setActivityActualDateTime(String ActivityActualDateTime) {
		this.ActivityActualDateTime = ActivityActualDateTime;
	}

	public String getActivityEarliestDateTime() {
		return ActivityEarliestDateTime;
	}

	public void setActivityEarliestDateTime(String ActivityEarliestDateTime) {
		this.ActivityEarliestDateTime = ActivityEarliestDateTime;
	}

	public String getActivitySecondaryCode() {
		return ActivitySecondaryCode;
	}

	public void setActivitySecondaryCode(String ActivitySecondaryCode) {
		this.ActivitySecondaryCode = ActivitySecondaryCode;
	}

	public String getActivityDescriptionText() {
		return ActivityDescriptionText;
	}

	public void setActivityDescriptionText(String ActivityDescriptionText) {
		this.ActivityDescriptionText = ActivityDescriptionText;
	}

	public String getBaggageActivityCode() {
		return BaggageActivityCode;
	}

	public void setBaggageActivityCode(String BaggageActivityCode) {
		this.BaggageActivityCode = BaggageActivityCode;
	}

	public String getActivityLatestDateTime() {
		return ActivityLatestDateTime;
	}

	public void setActivityLatestDateTime(String ActivityLatestDateTime) {
		this.ActivityLatestDateTime = ActivityLatestDateTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ActivityActualDateTime == null) ? 0 : ActivityActualDateTime.hashCode());
		result = prime * result + ((ActivityDescriptionText == null) ? 0 : ActivityDescriptionText.hashCode());
		result = prime * result + ((ActivityEarliestDateTime == null) ? 0 : ActivityEarliestDateTime.hashCode());
		result = prime * result + ((ActivityLatestDateTime == null) ? 0 : ActivityLatestDateTime.hashCode());
		result = prime * result + ((ActivitySecondaryCode == null) ? 0 : ActivitySecondaryCode.hashCode());
		result = prime * result + ((ActivitySequenceOrdinal == null) ? 0 : ActivitySequenceOrdinal.hashCode());
		result = prime * result + ((BaggageActivityCode == null) ? 0 : BaggageActivityCode.hashCode());
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
		BaggageActivity other = (BaggageActivity) obj;
		if (ActivityActualDateTime == null) {
			if (other.ActivityActualDateTime != null)
				return false;
		} else if (!ActivityActualDateTime.equals(other.ActivityActualDateTime))
			return false;
		if (ActivityDescriptionText == null) {
			if (other.ActivityDescriptionText != null)
				return false;
		} else if (!ActivityDescriptionText.equals(other.ActivityDescriptionText))
			return false;
		if (ActivityEarliestDateTime == null) {
			if (other.ActivityEarliestDateTime != null)
				return false;
		} else if (!ActivityEarliestDateTime.equals(other.ActivityEarliestDateTime))
			return false;
		if (ActivityLatestDateTime == null) {
			if (other.ActivityLatestDateTime != null)
				return false;
		} else if (!ActivityLatestDateTime.equals(other.ActivityLatestDateTime))
			return false;
		if (ActivitySecondaryCode == null) {
			if (other.ActivitySecondaryCode != null)
				return false;
		} else if (!ActivitySecondaryCode.equals(other.ActivitySecondaryCode))
			return false;
		if (ActivitySequenceOrdinal == null) {
			if (other.ActivitySequenceOrdinal != null)
				return false;
		} else if (!ActivitySequenceOrdinal.equals(other.ActivitySequenceOrdinal))
			return false;
		if (BaggageActivityCode == null) {
			if (other.BaggageActivityCode != null)
				return false;
		} else if (!BaggageActivityCode.equals(other.BaggageActivityCode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BaggageActivity [ActivitySequenceOrdinal=" + ActivitySequenceOrdinal + ", ActivityActualDateTime="
				+ ActivityActualDateTime + ", ActivityEarliestDateTime=" + ActivityEarliestDateTime
				+ ", ActivitySecondaryCode=" + ActivitySecondaryCode + ", ActivityDescriptionText="
				+ ActivityDescriptionText + ", BaggageActivityCode=" + BaggageActivityCode + ", ActivityLatestDateTime="
				+ ActivityLatestDateTime + "]";
	}
}