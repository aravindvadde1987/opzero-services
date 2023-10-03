package com.opzero.service;

import com.opzero.entity.SolutionDetail;

import java.util.List;
import java.util.Optional;

public interface SolutionDetailService {
    SolutionDetail saveSolutionDetail(SolutionDetail lever);

    Optional<SolutionDetail> getSolutionDetail(Long solutionDetailId);

    SolutionDetail updateSolutionDetail(SolutionDetail solutionDetail);

    List<SolutionDetail> getSolutionDetails();
}
