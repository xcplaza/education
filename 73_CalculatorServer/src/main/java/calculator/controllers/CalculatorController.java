package calculator.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import calculator.dto.CalculatorData;
import calculator.service.ICalculator;

@RestController
//@RequestMapping("/calculator")
public class CalculatorController
{
//	Solution 1 -> above field
	@Autowired
	ICalculator service;

//	Solution 2 -> above constructor
//	ICalculator service;
//
//	@Autowired
//	public CalculatorController(ICalculator service)
//	{
//		super();
//		this.service = service;
//	}
	
//	Solution 3 -> above getter
//	ICalculator service;
//	
//	@Autowired
//	public ICalculator getService()
//	{
//		return service;
//	}

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

//dn/post/add
//dn/post/delete

//dn/comment/add
//dn/comment/delete

//dn/user/add
//dn/user/delete

//dn/calculate/operations
//dn/calculate/calculate