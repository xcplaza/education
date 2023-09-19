package calculator.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import calculator.dto.CalculatorData;
import calculator.service.ICalculator;

@RestController
public class CalculatorController
{
	@Autowired
	@Qualifier("service1")
	ICalculator service;

	@GetMapping(value = "/operations")
	public Set<String> getOperationCodes()
	{
		return service.getOperationCodes();
	}

	@PostMapping("/calculate")
	public double calculate(@RequestBody CalculatorData data)
	{
		return service.calculate(data.getOp1(), data.getOp2(), data.getOperator());
	}
}
