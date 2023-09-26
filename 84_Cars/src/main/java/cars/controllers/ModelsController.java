package cars.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import cars.dto.ModelDTO;
import cars.service.ICars;

@RestController
public class ModelsController
{
	@Autowired
	ICars service;

	@PostMapping("/model")
	public boolean addModel(@RequestBody ModelDTO modelDto)
	{
		return service.addModel(modelDto);
	}

	@GetMapping("/model/{modelName}")
	public ModelDTO getModel(@PathVariable String modelName)
	{
		return service.getModel(modelName);
	}

	@DeleteMapping("/model/{modelName}")
	public boolean removeModel(@PathVariable String modelName)
	{
		return service.removeModel(modelName);
	}
}
