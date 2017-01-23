package aero.sita.mqtt.model.bimsxml;

public class AssignedPerson {
	private String GenderCode;

	private String TitleName;

	private String MiddleName;

	private String SurName;

	private String GivenName;

	private String BirthDate;

	public String getGenderCode() {
		return GenderCode;
	}

	public void setGenderCode(String GenderCode) {
		this.GenderCode = GenderCode;
	}

	public String getTitleName() {
		return TitleName;
	}

	public void setTitleName(String TitleName) {
		this.TitleName = TitleName;
	}

	public String getMiddleName() {
		return MiddleName;
	}

	public void setMiddleName(String MiddleName) {
		this.MiddleName = MiddleName;
	}

	public String getSurName() {
		return SurName;
	}

	public void setSurName(String SurName) {
		this.SurName = SurName;
	}

	public String getGivenName() {
		return GivenName;
	}

	public void setGivenName(String GivenName) {
		this.GivenName = GivenName;
	}

	public String getBirthDate() {
		return BirthDate;
	}

	public void setBirthDate(String BirthDate) {
		this.BirthDate = BirthDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((BirthDate == null) ? 0 : BirthDate.hashCode());
		result = prime * result + ((GenderCode == null) ? 0 : GenderCode.hashCode());
		result = prime * result + ((GivenName == null) ? 0 : GivenName.hashCode());
		result = prime * result + ((MiddleName == null) ? 0 : MiddleName.hashCode());
		result = prime * result + ((SurName == null) ? 0 : SurName.hashCode());
		result = prime * result + ((TitleName == null) ? 0 : TitleName.hashCode());
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
		AssignedPerson other = (AssignedPerson) obj;
		if (BirthDate == null) {
			if (other.BirthDate != null)
				return false;
		} else if (!BirthDate.equals(other.BirthDate))
			return false;
		if (GenderCode == null) {
			if (other.GenderCode != null)
				return false;
		} else if (!GenderCode.equals(other.GenderCode))
			return false;
		if (GivenName == null) {
			if (other.GivenName != null)
				return false;
		} else if (!GivenName.equals(other.GivenName))
			return false;
		if (MiddleName == null) {
			if (other.MiddleName != null)
				return false;
		} else if (!MiddleName.equals(other.MiddleName))
			return false;
		if (SurName == null) {
			if (other.SurName != null)
				return false;
		} else if (!SurName.equals(other.SurName))
			return false;
		if (TitleName == null) {
			if (other.TitleName != null)
				return false;
		} else if (!TitleName.equals(other.TitleName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ClassPojo [GenderCode = " + GenderCode + ", TitleName = " + TitleName + ", MiddleName = " + MiddleName
				+ ", SurName = " + SurName + ", GivenName = " + GivenName + ", BirthDate = " + BirthDate + "]";
	}
}