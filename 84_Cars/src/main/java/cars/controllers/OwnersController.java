package cars.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import cars.dto.OwnerDTO;
import cars.service.ICars;

@RestController
public class OwnersController
{
	@Autowired
	ICars service;

	@PostMapping("/owner")
	public boolean addOwner(@RequestBody OwnerDTO ownerDto)
	{
		return service.addOwner(ownerDto);
	}

	@GetMapping("/owner/{id}")
	public OwnerDTO getOwner(@PathVariable("id") int ownerId)
	{
		return service.getOwner(ownerId);
	}

	@GetMapping("/owner/car/{regNumber}")
	public OwnerDTO getCarOwner(@PathVariable long regNumber)
	{
		return service.getCarOwner(regNumber);
	}

	@GetMapping("/owners/model/{modelName}")
	public List<OwnerDTO> getOwnersByModel(@PathVariable String modelName)
	{
		return service.getOwnersByModel(modelName);
	}

	@DeleteMapping("/owner/{ownerId}")
	public boolean removeOwner(@PathVariable int ownerId)
	{
		return service.removeOwner(ownerId);
	}
}
