package com.opzero.service;

import java.util.List;

import com.opzero.entity.Offering;

public interface OfferingService {
	Offering saveOffering(Offering offering);

	Offering getOffering(Long offeringId);

	Offering updateOffering(Offering offering);

	List<Offering> getOfferings();
}
