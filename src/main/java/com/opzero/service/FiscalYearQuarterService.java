package com.opzero.service;

import com.opzero.entity.FiscalYearQuarter;

import java.util.List;
import java.util.Optional;

public interface FiscalYearQuarterService {
    FiscalYearQuarter saveFiscalYearQuarter(FiscalYearQuarter fiscalYearQuarter);

    Optional<FiscalYearQuarter> getFiscalYearQuarter(Long fiscalYearQuarterId);

    FiscalYearQuarter updateFiscalYearQuarter(FiscalYearQuarter fiscalYearQuarter);

    List<FiscalYearQuarter> getFiscalYearQuarters();
}
