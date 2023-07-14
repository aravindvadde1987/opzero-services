package com.opzero.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.opzero.entity.OfferingPortfolio;
import com.opzero.service.OfferingPortfolioService;

@RestController
@RequestMapping("/api")
public class OfferingPortfolioController {
	@Autowired
	OfferingPortfolioService offeringPortfolioService;

	@GetMapping("/offeringPortfolio/{offeringPortfolioId}")
	public ResponseEntity<Object> getOfferingPortfolio(@PathVariable("offeringPortfolioId") Long offeringPortfolioId) {
		if (offeringPortfolioService.getOfferingPortfolio(offeringPortfolioId) == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"offering Porfotilo is not found for given id " + offeringPortfolioId);
		}
		return ResponseEntity.ok(offeringPortfolioService.getOfferingPortfolio(offeringPortfolioId));
	}

	@GetMapping("/offeringPortfolios")
	public List<OfferingPortfolio> getOfferingPortfolios() {
		if (offeringPortfolioService.getOfferingPortfolios().size() == 0) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "offering Porfotilos not found");
		}
		return offeringPortfolioService.getOfferingPortfolios();
	}

	@PostMapping(value = "/offeringPortfolio", consumes = "application/json", produces = "application/json")
	public OfferingPortfolio saveOfferingPortfolio(@RequestBody OfferingPortfolio offeringPortfolio) {
		if (offeringPortfolioService.getOfferingPortfolio(offeringPortfolio.getOfferingportfolioId()) != null) {
			throw new ResponseStatusException(HttpStatus.CONFLICT,
					"offering Porfotilo already exist for given offering portfoli id"
							+ offeringPortfolio.getOfferingportfolioId());
		}
		return offeringPortfolioService.saveOfferingPortfolio(offeringPortfolio);
	}

	@PutMapping(value = "/offeringPortfolio", consumes = "application/json", produces = "application/json")
	public OfferingPortfolio updatOfferingPortfolio(@RequestBody OfferingPortfolio offeringPortfolio) {
		if (offeringPortfolioService.getOfferingPortfolio(offeringPortfolio.getOfferingportfolioId()) == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"offering Porfotilo is not found for given id " + offeringPortfolio.getOfferingportfolioId());
		}
		return offeringPortfolioService.saveOfferingPortfolio(offeringPortfolio);
	}
}
