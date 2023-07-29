package telran.interfaces.dto;

import java.util.Objects;

public class Ostrich extends Bird implements IRunable {
	double speed;

	public Ostrich() {
	}

	public Ostrich(String subspecies, double speed) {
		super(subspecies);
		this.speed = speed;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	@Override
	public String toString() {
		return "Ostrich [subspecies=" + subspecies + ", speed=" + speed + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(speed);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Ostrich))
			return false;
		Ostrich other = (Ostrich) obj;
		return Double.doubleToLongBits(speed) == Double.doubleToLongBits(other.speed);
	}

	@Override
	public void run() {
		System.out.println("Ostrich run!");
	}

}
