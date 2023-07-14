package com.opzero.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.opzero.entity.Offering;

public interface OfferingRepository extends CrudRepository<Offering, Long> {

	Offering findByOfferingId(long offeringId);

	@SuppressWarnings("unchecked")
	Offering save(Offering offering);

	List<Offering> findAll();
}