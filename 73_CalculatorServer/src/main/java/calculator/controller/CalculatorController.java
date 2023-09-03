package calculator.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import calculator.dto.CalculatorData;
import calculator.service.ICalculator;

@RestController
//@RequestMapping("/calculate")  -> /calculate/operation OR /calculate/calculate
public class CalculatorController {

//	solution 1 -> above filed (над каждым полем!)
	@Autowired
	ICalculator service;
	
//	solution 2 -> above constructor
//	ICalculator service;
//	@Autowired
//	public CalculatorController(ICalculator service) {
//	super();
//	this.service = service;
//}
	
//	solution 3 -> above getter
//	ICalculator service;
//	@Autowired
//	public ICalculator getService() {
//		return service;
//	}

	@GetMapping(value = "/operation")
	public Set<String> getOperationCodes() {
		return service.getOperationCodes();
	}

	@PostMapping("/calculate")
	public double calculate(@RequestBody CalculatorData data) {
		return service.calculate(data.getOp1(), data.getOp2(), data.getOperator());
	}
}
