package com.opzero.repository;

import com.opzero.entity.FiscalYearQuarter;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FiscalYearQuarterRepository extends CrudRepository<FiscalYearQuarter, Long> {
	List<FiscalYearQuarter> findAll();
}