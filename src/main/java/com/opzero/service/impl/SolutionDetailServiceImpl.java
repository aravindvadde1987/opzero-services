package com.opzero.service.impl;

import com.opzero.entity.SolutionDetail;
import com.opzero.repository.SolutionDetailRepository;
import com.opzero.service.SolutionDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SolutionDetailServiceImpl implements SolutionDetailService {
    @Autowired
    SolutionDetailRepository solutionDetailRepository;

    @Override
    public SolutionDetail saveSolutionDetail(SolutionDetail solutionDetail) {
        return solutionDetailRepository.save(solutionDetail);
    }

    @Override
    public Optional<SolutionDetail> getSolutionDetail(Long solutionDetailId) {
        return solutionDetailRepository.findById(solutionDetailId);
    }

    @Override
    public SolutionDetail updateSolutionDetail(SolutionDetail solutionDetail) {
        return solutionDetailRepository.save(solutionDetail);
    }

    @Override
    public List<SolutionDetail> getSolutionDetails() {
        return solutionDetailRepository.findAll();
    }
}