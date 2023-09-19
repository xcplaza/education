package calculator.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BinaryOperator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Service;

@Service(value="service1")
@ManagedResource
@EnableMBeanExport
public class CalculatorMap implements ICalculator
{
	static Map<String, BinaryOperator<Double>> mapOperations;
	static
	{
		mapOperations = new HashMap<>();
		mapOperations.put("+", (o1, o2) -> o1+o2);
		mapOperations.put("-", (op1, op2) -> op1-op2);
		mapOperations.put("*", (op1, op2) -> op1*op2);
		mapOperations.put("/", (op1, op2) -> op2==0 ? null : op1/op2);
	}
	
	@Value("${wrongValue:-10000}")
	double value;
	
	@ManagedAttribute
	public double getValue()
	{
		return value;
	}

	@ManagedAttribute
	public void setValue(double value)
	{
		this.value = value;
	}

	@Override
	public Set<String> getOperationCodes()
	{
		return mapOperations.keySet();
	}

	@ManagedOperation
	public double calculate(double op1, double op2, String operation)
	{
		try
		{
			return mapOperations.get(operation).apply(op1, op2);
		} catch (Exception e)
		{
			return value;
		}
	}
}
