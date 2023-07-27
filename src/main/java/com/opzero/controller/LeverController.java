package com.opzero.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.opzero.service.CategoryService;
import com.opzero.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.opzero.entity.Lever;
import com.opzero.entity.dto.MasterDTO;
import com.opzero.service.LeverService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class LeverController {
	@Autowired
	LeverService leverService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	MapperUtil mapperUtil;

	@GetMapping("/lever/{id}")
	public MasterDTO getLever(@PathVariable("id") Long id) {
		if (!leverService.getLever(id).isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Lever is not found for given id " + id);
		}
		return mapperUtil.getModelMapper().map(leverService.getLever(id).get(), MasterDTO.class);
	}

	@GetMapping("/levers")
	public List<MasterDTO> getLevers() {
		return leverService.getLevers().stream().map(lever -> mapperUtil.getModelMapper().map(lever, MasterDTO.class))
				.collect(Collectors.toList());
	}

	@PostMapping(value = "/lever", consumes = "application/json", produces = "application/json")
	public MasterDTO saveLever(@RequestBody MasterDTO masterDTO) {
		Lever input = mapperUtil.getModelMapper().map(masterDTO, Lever.class);
		input.setCategory(categoryService.getCategory(masterDTO.getParentId()).get());
		Lever lever = leverService.saveLever(input);

		return mapperUtil.getModelMapper().map(lever, MasterDTO.class);
	}

	@PutMapping(value = "/lever", consumes = "application/json", produces = "application/json")
	public MasterDTO updateLever(@RequestBody MasterDTO masterDTO) {
		if (!leverService.getLever(masterDTO.getId()).isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Lever is not found for given id " + masterDTO.getId());
		}
		Lever input = mapperUtil.getModelMapper().map(masterDTO, Lever.class);
		input.setCategory(categoryService.getCategory(masterDTO.getParentId()).get());
		Lever lever = leverService.saveLever(input);
		return mapperUtil.getModelMapper().map(lever, MasterDTO.class);
	}
}
