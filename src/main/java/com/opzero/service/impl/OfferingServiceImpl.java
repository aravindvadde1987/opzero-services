package com.opzero.service.impl;

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
	public Offering getOffering(Long offeringId) {
		return offeringRepository.findByOfferingId(offeringId);
	}

	@Override
	public Offering updateOffering(Offering offering) {
		return offeringRepository.save(offering);
	}

}
