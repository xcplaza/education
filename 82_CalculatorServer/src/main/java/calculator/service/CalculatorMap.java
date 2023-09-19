package calculator.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BinaryOperator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

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
	
	Logger logger = LoggerFactory.getLogger(CalculatorMap.class);
	
	@Value("${wrongValue:-10000}")
	double value;
	
	@PostConstruct
	public void welcomeMessage()
	{
		logger.info("Welcome with wrong value = " + value);
	}
	
	@PreDestroy
	public void footerMessage()
	{
		logger.info("Bye with wrong value = " + value);
	}
	
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

	public int numberLength(int number)
	{
		return Integer.toString(number).length();
	}
}
