package com.opzero.service;

import java.util.List;
import java.util.Optional;

import com.opzero.entity.Lever;

public interface LeverService {
	Lever saveLever(Lever lever);

	Optional<Lever> getLever(Long leverId);

	Lever updateLever(Lever lever);

	List<Lever> getLevers();
}
