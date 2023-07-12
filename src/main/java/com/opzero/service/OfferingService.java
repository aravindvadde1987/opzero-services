package com.opzero.service;

import com.opzero.entity.Offering;

public interface OfferingService {
	Offering saveOffering(Offering offering);

	Offering getOffering(Long offeringId);

	Offering updateOffering(Offering offering);
}
