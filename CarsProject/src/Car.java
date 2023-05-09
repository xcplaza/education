
public class Car {

	private String model;
	private String color;
	private int year;
	private double motorValue;

	public Car(String model1, String color1, int year1, double motor) {
		if (model1 != null && !model1.isBlank())
			model = model1;
		else {
			model = "No model";
		}
		if (color1 != null && !color1.isBlank())
			color = color1;
		else {
			color = "No color";
		}
		if (year >= 1945 || year <= 2022)
			year = year1;
		else {
			year = -1;
		}
		if (motor >= 0.5 || motor <= 9.0)
			motorValue = motor;
		else {
			motorValue = -1;
		}
	}

	public String getModel() {
		return model;
	}

	public String getColor() {
		return color;
	}

	public int getYear() {
		return year;
	}

	public double getMotor() {
		return motorValue;
	}

	public void setModel(String model1) {
		if (model1 != null && !model1.isBlank())
			model = model1;
	}

	public void setColor(String color1) {
		if (color1 != null && !color1.isBlank())
			color = color1;
	}

	public void setYear(int year1) {
		if (year >= 1945 || year <= 2022)
			year = year1;
	}

	public void setMotorValue(double motor) {
		if (motor >= 0.5 || motor <= 9.0)
			motorValue = motor;
	}

	public void display() {
		System.out.println("Model: " + model + "\nColor: " + color + "\nYear: " + year + "\nMotorValue: " + motorValue);
		System.out.println();
	}
}
