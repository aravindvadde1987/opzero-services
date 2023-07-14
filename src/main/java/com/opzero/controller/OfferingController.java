package com.opzero.controller;

import java.util.List;

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

import com.opzero.entity.Offering;
import com.opzero.service.OfferingService;

@RestController
@RequestMapping("/api")
public class OfferingController {
	@Autowired
	OfferingService offeringService;

	@GetMapping("/offering/{offeringId}")
	public Offering getOffering(@PathVariable("offeringId") Long offeringId) {
		if (offeringService.getOffering(offeringId) == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "offering is not found for given id " + offeringId);
		}
		return offeringService.getOffering(offeringId);
	}

	@GetMapping("/offerings")
	public List<Offering> getOfferings() {
		if (offeringService.getOfferings().size() == 0) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "offerings not found");
		}
		return offeringService.getOfferings();
	}

	@PostMapping(value = "/offering", consumes = "application/json", produces = "application/json")
	public Offering saveOffering(@RequestBody Offering offering) {
		if (offeringService.getOffering(offering.getOfferingId()) != null) {
			throw new ResponseStatusException(HttpStatus.CONFLICT,
					"offering already exist for given id" + offering.getOfferingId());
		}
		return offeringService.saveOffering(offering);
	}

	@PutMapping(value = "/offering", consumes = "application/json", produces = "application/json")
	public Offering updatOffering(@RequestBody Offering offering) {
		if (offeringService.getOffering(offering.getOfferingId()) == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"offering is not found for given id " + offering.getOfferingId());
		}
		return offeringService.saveOffering(offering);
	}
}
