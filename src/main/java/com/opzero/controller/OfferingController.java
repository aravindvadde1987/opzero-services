package com.opzero.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opzero.entity.Offering;
import com.opzero.service.OfferingService;

@RestController
@RequestMapping("/api")
public class OfferingController {
	@Autowired
	OfferingService offeringService;

	@GetMapping("/offering/{offeringId}")
	public Offering getOffering(@PathVariable("offeringId") Long offeringId) {
		return offeringService.getOffering(offeringId);
	}

	@PostMapping(value = "/offering", consumes = "application/json", produces = "application/json")
	public Offering saveOffering(@RequestBody Offering offering) {
		return offeringService.saveOffering(offering);
	}

	@PutMapping(value = "/offering", consumes = "application/json", produces = "application/json")
	public Offering updatOffering(@RequestBody Offering offering) {
		return offeringService.saveOffering(offering);
	}
}
