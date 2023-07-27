package telran.library.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@SuppressWarnings("serial")
public class Reader implements Serializable {
	private int readerId;
	private String name;
	private String phone;
	private LocalDate birthDate;

	public Reader() {
	}

	public Reader(int readerId, String name, String phone, LocalDate birthDate) {
		super();
		this.readerId = readerId;
		this.name = name;
		this.phone = phone;
		this.birthDate = birthDate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getReaderId() {
		return readerId;
	}

	public String getName() {
		return name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(readerId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Reader))
			return false;
		Reader other = (Reader) obj;
		return readerId == other.readerId;
	}

	@Override
	public String toString() {
		return "Reader [readerId=" + readerId + ", name=" + name + ", phone=" + phone + ", birthDate=" + birthDate
				+ "]";
	}

}
