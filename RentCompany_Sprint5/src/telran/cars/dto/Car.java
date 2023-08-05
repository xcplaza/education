package telran.cars.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Car implements Serializable
{
	private String regNumber;
	private String color;
	private State state;
	private String modelName;
	private boolean inUse;
	private boolean flRemoved;
	
	public Car(String regNumber, String color, String modelName)
	{
		super();
		this.regNumber = regNumber;
		this.color = color;
		this.modelName = modelName;
		state = State.EXCELLENT;
	}
	
	public Car()
	{
		// TODO Auto-generated constructor stub
	}

	public State getState()
	{
		return state;
	}

	public void setState(State state)
	{
		this.state = state;
	}

	public boolean isUse()
	{
		return inUse;
	}

	public void setUse(boolean isUse)
	{
		this.inUse = isUse;
	}

	public boolean isFlRemoved()
	{
		return flRemoved;
	}

	public void setFlRemoved(boolean flRemoved)
	{
		this.flRemoved = flRemoved;
	}

	public String getRegNumber()
	{
		return regNumber;
	}

	public String getColor()
	{
		return color;
	}

	public String getModelName()
	{
		return modelName;
	}
	
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((regNumber == null) ? 0 : regNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (regNumber == null)
		{
			if (other.regNumber != null)
				return false;
		} else if (!regNumber.equals(other.regNumber))
			return false;
		return true;
	}

	@Override
	public String toString()
	{
		return "Car [regNumber=" + regNumber + ", color=" + color + ", state=" + state + ", modelName=" + modelName
				+ ", isUse=" + inUse + ", flRemoved=" + flRemoved + "]";
	}
}
