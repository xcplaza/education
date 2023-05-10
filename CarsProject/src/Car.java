
public class Car {

	private String model;
	private String color;
	private int year;
	private double motorValue;

//	public Car(String model1, String color1, int year1, double motor) {
//		if (model1 != null && !model1.isBlank())
//			model = model1;
//		else {
//			model = "No model";
//		}
//		if (color1 != null && !color1.isBlank())
//			color = color1;
//		else {
//			color = "No color";
//		}
//		if (year >= 1945 || year <= 2022)
//			year = year1;
//		else {
//			year = -1;
//		}
//		if (motor >= 0.5 || motor <= 9.0)
//			motorValue = motor;
//		else {
//			motorValue = -1;
//		}
//	}

	public Car(String model, String color, int year, double motorValue) {
		if (model != null && !model.isEmpty())
			this.model = model;
		else
			this.model = "No model!";

		if (color != null && !color.isEmpty())
			this.color = color;
		else
			this.color = "No color!";

//		if (year >= 1945 && year <= 2022)
//			this.year = year;

		setYear(year);

//		if (motorValue >= 0.5 && motorValue <= 9.)
//			this.motorValue = motorValue;
		setMotorValue(motorValue);
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		if (model != null && !model.isEmpty())
			this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		if (color != null && !color.isEmpty())
			this.color = color;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		if (year >= 1945 && year <= 2022)
			this.year = year;
	}

	public double getMotorValue() {
		return motorValue;
	}

	public void setMotorValue(double motorValue) {
		if (motorValue >= 0.5 && motorValue <= 9.)
			this.motorValue = motorValue;
	}

	public void display() {
		String str = ("Model: " + model + "\nColor: " + color + "\nYear: " + year + "\nMotorValue: " + motorValue
				+ "\n=================================\n");
		System.out.println(str);
	}
}
