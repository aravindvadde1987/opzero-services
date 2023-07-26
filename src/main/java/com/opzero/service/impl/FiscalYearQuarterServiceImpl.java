package com.opzero.service.impl;

import com.opzero.entity.FiscalYearQuarter;
import com.opzero.repository.FiscalYearQuarterRepository;
import com.opzero.service.FiscalYearQuarterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FiscalYearQuarterServiceImpl implements FiscalYearQuarterService {
    @Autowired
    FiscalYearQuarterRepository fiscalYearQuarterRepository;

    @Override
    public FiscalYearQuarter saveFiscalYearQuarter(FiscalYearQuarter fiscalYearQuarter) {
        return fiscalYearQuarterRepository.save(fiscalYearQuarter);
    }

    @Override
    public Optional<FiscalYearQuarter> getFiscalYearQuarter(Long fiscalYearQuarterId) {
        return fiscalYearQuarterRepository.findById(fiscalYearQuarterId);
    }

    @Override
    public FiscalYearQuarter updateFiscalYearQuarter(FiscalYearQuarter fiscalYearQuarter) {
        return fiscalYearQuarterRepository.save(fiscalYearQuarter);
    }

    @Override
    public List<FiscalYearQuarter> getFiscalYearQuarters() {
        return fiscalYearQuarterRepository.findAll();
    }
}
