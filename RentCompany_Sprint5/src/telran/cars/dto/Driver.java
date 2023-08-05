package telran.cars.dto;

import java.io.Serializable;
import java.util.Objects;

@SuppressWarnings("serial")
public class Driver implements Serializable {
	private long licenseId;
	private String name;
	private int birthYear;
	private String phone;
	
	public Driver() {}

	public Driver(long licenseId, String name, int birthYear, String phone) {
		super();
		this.licenseId = licenseId;
		this.name = name;
		this.birthYear = birthYear;
		this.phone = phone;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public long getLicenseId() {
		return licenseId;
	}

	public String getName() {
		return name;
	}

	public int getBirthYear() {
		return birthYear;
	}

	@Override
	public String toString() {
		return "Driver [licenseId=" + licenseId + ", name=" + name + ", birthYear=" + birthYear + ", phone=" + phone
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(licenseId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Driver))
			return false;
		Driver other = (Driver) obj;
		return licenseId == other.licenseId;
	}
	
}
