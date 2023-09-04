package telran.service;

import java.util.Set;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import telran.dto.CalculatorData;

public class CalculatorProxy implements ICalculator
{
	RestTemplate rest = new RestTemplate();
	String url = "http://localhost:8080";
	
	@Override
	public Set<String> getOperationCodes()//operations get
	{
		ResponseEntity<Set<String>> response = rest.exchange(url+"/operations", HttpMethod.GET, null,
				new ParameterizedTypeReference<Set<String>>(){});
		return response.getBody();
	}

	@Override
	public double calculate(double op1, double op2, String operation)//calculate post
	{
		CalculatorData data = new CalculatorData(op1, op2, operation);
		HttpEntity<CalculatorData> request = new HttpEntity<>(data);
		ResponseEntity<Double> response = rest.exchange(url+"/calculate", HttpMethod.POST, request,
				Double.class);
		return response.getBody();
	}

}
