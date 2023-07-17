package com.opzero.service;

import java.util.List;
import java.util.Optional;

import com.opzero.entity.Offering;

public interface OfferingService {
	Offering saveOffering(Offering offering);

	Optional<Offering> getOffering(Long offeringId);

	Offering updateOffering(Offering offering);

	List<Offering> getOfferings();
}
