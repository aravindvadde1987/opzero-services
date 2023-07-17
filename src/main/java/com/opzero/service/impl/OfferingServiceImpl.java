package com.opzero.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opzero.entity.Offering;
import com.opzero.repository.OfferingRepository;
import com.opzero.service.OfferingService;

@Service
public class OfferingServiceImpl implements OfferingService {
	@Autowired
	OfferingRepository offeringRepository;

	@Override
	public Offering saveOffering(Offering offering) {
		return offeringRepository.save(offering);
	}

	@Override
	public Optional<Offering> getOffering(Long id) {
		return offeringRepository.findById(id);
	}

	@Override
	public Offering updateOffering(Offering offering) {
		return offeringRepository.save(offering);
	}

	@Override
	public java.util.List<Offering> getOfferings() {
		return offeringRepository.findAll();
	}
}
