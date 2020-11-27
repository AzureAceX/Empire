package com.urillah.empireproj.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.urillah.empireproj.dto.PropertyDTO;
import com.urillah.empireproj.model.Property;
import com.urillah.empireproj.repository.PropertyRepository;

@RestController
@RequestMapping("/property")
public class PropertyController {

	@Autowired
	private PropertyRepository propertyRepoObj;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping(value = "/list")
	public List<Property> getAll() {
		List<Property> properties = new ArrayList<>();
		propertyRepoObj.findAll().forEach(properties::add);
		return properties;
	}

	@GetMapping(value = "/{propertyId}")
	public Property getById(@PathVariable("propertyId") Long propertyId) {
		return propertyRepoObj.findOne(propertyId);
	}

	@PostMapping(value = "/create")
	public ResponseEntity<Property> create(@RequestBody PropertyDTO propertyDTO) {
		try {
			Property propertyObj = modelMapper.map(propertyDTO, Property.class);
			
			propertyRepoObj.save(propertyObj);
			
			return new ResponseEntity<>(propertyObj, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}
}
