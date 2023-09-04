package calculator.service;

import java.util.Set;

public interface ICalculator
{
	Set<String> getOperationCodes();
	double calculate(double op1, double op2, String operation);
}
