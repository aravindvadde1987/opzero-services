package com.opzero.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opzero.entity.Lever;
import com.opzero.repository.LeverRepository;
import com.opzero.service.LeverService;

@Service
public class LeverServiceImpl implements LeverService {
	@Autowired
	LeverRepository leverRepository;

	@Override
	public Lever saveLever(Lever lever) {
		return leverRepository.save(lever);
	}

	@Override
	public Optional<Lever> getLever(Long leverId) {
		return leverRepository.findById(leverId);
	}

	@Override
	public Lever updateLever(Lever lever) {
		return leverRepository.save(lever);
	}

	@Override
	public List<Lever> getLevers() {
		return leverRepository.findAll();
	}
}
