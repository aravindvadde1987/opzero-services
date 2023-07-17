package com.opzero.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.opzero.entity.Offering;

public interface OfferingRepository extends CrudRepository<Offering, Long> {
	List<Offering> findAll();
}