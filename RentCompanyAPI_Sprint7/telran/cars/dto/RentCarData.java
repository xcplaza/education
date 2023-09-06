package telran.cars.dto;

import java.io.Serializable;
import java.time.LocalDate;

@SuppressWarnings("serial")
public class RentCarData implements Serializable {
	String regNumber;
	long licenseId;
	LocalDate rentDate;
	int rentDays;
	
	public RentCarData() {}

	public RentCarData(String regNumber, long licenseId, LocalDate rentDate, int rentDays) {
		super();
		this.regNumber = regNumber;
		this.licenseId = licenseId;
		this.rentDate = rentDate;
		this.rentDays = rentDays;
	}

	public String getRegNumber() {
		return regNumber;
	}

	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}

	public long getLicenseId() {
		return licenseId;
	}

	public void setLicenseId(long licenseId) {
		this.licenseId = licenseId;
	}

	public LocalDate getRentDate() {
		return rentDate;
	}

	public void setRentDate(LocalDate rentDate) {
		this.rentDate = rentDate;
	}

	public int getRentDays() {
		return rentDays;
	}

	public void setRentDays(int rentDays) {
		this.rentDays = rentDays;
	}
	
	

}
