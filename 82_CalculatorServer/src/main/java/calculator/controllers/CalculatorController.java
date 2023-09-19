package calculator.controllers;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import calculator.dto.CalculatorData;
import calculator.service.CalculatorMap;
import calculator.service.ICalculator;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
public class CalculatorController
{
	@Autowired
	@Qualifier("service1")
	ICalculator service;
	
	Logger logger = LoggerFactory.getLogger(CalculatorController.class);

	@ApiResponse(description = "My operation code")
	@GetMapping(value = "/operations")
	public Set<String> getOperationCodes()
	{
		return service.getOperationCodes();
	}

	@ApiResponse(description = "Calculate integer numbers")
	@PostMapping("/calculate")
	public double calculate(@RequestBody CalculatorData data)
	{
		return service.calculate(data.getOp1(), data.getOp2(), data.getOperator());
	}
	
//	@GetMapping("/length/{num}")
//	public int getDigitAmountFromPath(@PathVariable("num") int number)
//	{
//		return service.numberLength(number);
//	}
	
	@GetMapping("/length/{number}")//localhos//length
	public int getDigitAmountFromPath(@PathVariable int number)
	{
		return service.numberLength(number);
	}
	
	@GetMapping("/length")//localhos//length?num=11111
	public int getDigitAmountFromParams(
		@RequestParam(value="num", required = true, defaultValue = "0") int number)
	{
		return service.numberLength(number);
	}
}

//host:port/mapping/1/2/+ - path variable
//host:port/mapping?num=value&key=valeu - request params

