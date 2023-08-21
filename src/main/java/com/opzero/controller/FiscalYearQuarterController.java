package com.opzero.controller;

import com.opzero.entity.FiscalYearQuarter;
import com.opzero.entity.dto.MasterDTO;
import com.opzero.service.FiscalYearQuarterService;
import com.opzero.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class FiscalYearQuarterController {
    @Autowired
    FiscalYearQuarterService fiscalYearQuarterService;
    @Autowired
    MapperUtil mapperUtil;

    @GetMapping("/fiscalYearQuarter/{id}")
    public MasterDTO getFiscalYearQuarter(@PathVariable("id") Long id) {
        if (fiscalYearQuarterService.getFiscalYearQuarter(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "FiscalYearQuarter is not found for given id " + id);
        }
        return mapperUtil.getModelMapper().map(fiscalYearQuarterService.getFiscalYearQuarter(id).get(), MasterDTO.class);
    }

    @GetMapping("/fiscalYearQuarters")
    public List<MasterDTO> getFiscalYearQuarters() {
        Date currentDate = new Date();
        return fiscalYearQuarterService.getFiscalYearQuarters().stream().filter(fiscalYearQuarter -> fiscalYearQuarter.getEndDate().compareTo(currentDate) <= 0).map(fiscalYearQuarter -> mapperUtil.getModelMapper().map(fiscalYearQuarter, MasterDTO.class)).sorted(Comparator.comparing(MasterDTO::getFiscalYearQuarterDesc).reversed()) // Sort in descending order
                .collect(Collectors.toList());
    }

    @PostMapping(value = "/fiscalYearQuarter", consumes = "application/json", produces = "application/json")
    public MasterDTO saveFiscalYearQuarter(@RequestBody MasterDTO masterDTO) {
        FiscalYearQuarter fiscalYearQuarter = fiscalYearQuarterService.saveFiscalYearQuarter(mapperUtil.getModelMapper().map(masterDTO, FiscalYearQuarter.class));

        return mapperUtil.getModelMapper().map(fiscalYearQuarter, MasterDTO.class);
    }

    @PutMapping(value = "/fiscalYearQuarter", consumes = "application/json", produces = "application/json")
    public MasterDTO updateFiscalYearQuarter(@RequestBody MasterDTO masterDTO) {
        if (fiscalYearQuarterService.getFiscalYearQuarter(masterDTO.getId()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "FiscalYearQuarter is not found for given id " + masterDTO.getId());
        }
        FiscalYearQuarter fiscalYearQuarter = fiscalYearQuarterService.saveFiscalYearQuarter(mapperUtil.getModelMapper().map(masterDTO, FiscalYearQuarter.class));

        return mapperUtil.getModelMapper().map(fiscalYearQuarter, MasterDTO.class);
    }
}
