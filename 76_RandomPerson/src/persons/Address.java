package persons;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Address implements Serializable {
	String city;
	String street;
	int building;
	int flat;

	public Address(String city, String street, int building, int flat) {
		super();
		this.city = city;
		this.street = street;
		this.building = building;
		this.flat = flat;
	}

	@Override
	public String toString() {
		return "Address [city=" + city + ", street=" + street + ", building=" + building + ", flat=" + flat + "]";
	}

}
