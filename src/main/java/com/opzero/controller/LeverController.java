package com.opzero.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.opzero.entity.Lever;
import com.opzero.entity.dto.MasterDTO;
import com.opzero.service.LeverService;

@RestController
@RequestMapping("/api")
public class LeverController {
	@Autowired
	LeverService leverService;
	@Autowired
	ModelMapper modelMapper;

	@GetMapping("/lever/{id}")
	public MasterDTO getLever(@PathVariable("id") Long id) {
		if (!leverService.getLever(id).isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Lever is not found for given id " + id);
		}
		return modelMapper.map(leverService.getLever(id).get(), MasterDTO.class);
	}

	@GetMapping("/levers")
	public List<MasterDTO> getLevers() {
		if (leverService.getLevers().size() == 0) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Levers not found");
		}
		return leverService.getLevers().stream().map(lever -> modelMapper.map(lever, MasterDTO.class))
				.collect(Collectors.toList());
	}

	@PostMapping(value = "/lever", consumes = "application/json", produces = "application/json")
	public MasterDTO saveLever(@RequestBody MasterDTO masterDTO) {
		Lever Lever = leverService.saveLever(modelMapper.map(masterDTO, Lever.class));

		return modelMapper.map(Lever, MasterDTO.class);
	}

	@PutMapping(value = "/lever", consumes = "application/json", produces = "application/json")
	public MasterDTO updateLever(@RequestBody MasterDTO masterDTO) {
		if (!leverService.getLever(masterDTO.getId()).isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Lever is not found for given id " + masterDTO.getId());
		}
		Lever lever = leverService.saveLever(modelMapper.map(masterDTO, Lever.class));

		return modelMapper.map(lever, MasterDTO.class);
	}
}
