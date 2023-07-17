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

import com.opzero.entity.OfferingPortfolio;
import com.opzero.entity.dto.MasterDTO;
import com.opzero.service.OfferingPortfolioService;

@RestController
@RequestMapping("/api")
public class OfferingPortfolioController {
	@Autowired
	OfferingPortfolioService offeringPortfolioService;
	@Autowired
	ModelMapper modelMapper;

	@GetMapping("/offeringPortfolio/{id}")
	public MasterDTO getOfferingPortfolio(@PathVariable("id") Long id) {
		if (!offeringPortfolioService.getOfferingPortfolio(id).isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"offering Porfotilo is not found for given id " + id);
		}
		return modelMapper.map(offeringPortfolioService.getOfferingPortfolio(id).get(), MasterDTO.class);
	}

	@GetMapping("/offeringPortfolios")
	public List<MasterDTO> getOfferingPortfolios() {
		if (offeringPortfolioService.getOfferingPortfolios().size() == 0) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "offering Porfotilos not found");
		}
		return offeringPortfolioService.getOfferingPortfolios().stream()
				.map(offeringPortfolio -> modelMapper.map(offeringPortfolio, MasterDTO.class))
				.collect(Collectors.toList());
	}

	@PostMapping(value = "/offeringPortfolio", consumes = "application/json", produces = "application/json")
	public MasterDTO saveOfferingPortfolio(@RequestBody MasterDTO masterDTO) {
		OfferingPortfolio offeringPortfolio = offeringPortfolioService
				.saveOfferingPortfolio(modelMapper.map(masterDTO, OfferingPortfolio.class));
		return modelMapper.map(offeringPortfolio, MasterDTO.class);
	}

	@PutMapping(value = "/offeringPortfolio", consumes = "application/json", produces = "application/json")
	public MasterDTO updateOfferingPortfolio(@RequestBody MasterDTO masterDTO) {
		if (!offeringPortfolioService.getOfferingPortfolio(masterDTO.getId()).isPresent()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"offering Porfotilo is not found for given id " + masterDTO.getId());
		}
		OfferingPortfolio offeringPortfolio = offeringPortfolioService
				.saveOfferingPortfolio(modelMapper.map(masterDTO, OfferingPortfolio.class));
		return modelMapper.map(offeringPortfolio, MasterDTO.class);
	}
}
