package com.opzero.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.opzero.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.opzero.entity.OfferingPortfolio;
import com.opzero.entity.dto.MasterDTO;
import com.opzero.service.OfferingPortfolioService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class OfferingPortfolioController {
    @Autowired
    OfferingPortfolioService offeringPortfolioService;
    @Autowired
    MapperUtil mapperUtil;

    @GetMapping("/offeringPortfolio/{id}")
    public MasterDTO getOfferingPortfolio(@PathVariable("id") Long id) {
        if (offeringPortfolioService.getOfferingPortfolio(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "offering Porfotilo is not found for given id " + id);
        }
        return mapperUtil.getModelMapper().map(offeringPortfolioService.getOfferingPortfolio(id).get(), MasterDTO.class);
    }

    @GetMapping("/offeringPortfolios")
    public List<MasterDTO> getOfferingPortfolios() {
        if (offeringPortfolioService.getOfferingPortfolios().size() == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "offering Porfotilos not found");
        }
        return offeringPortfolioService.getOfferingPortfolios().stream()
                .map(offeringPortfolio -> mapperUtil.getModelMapper().map(offeringPortfolio, MasterDTO.class))
                .collect(Collectors.toList());
    }

    @PostMapping(value = "/offeringPortfolio", consumes = "application/json", produces = "application/json")
    public MasterDTO saveOfferingPortfolio(@RequestBody MasterDTO masterDTO) {
        OfferingPortfolio offeringPortfolio = offeringPortfolioService
                .saveOfferingPortfolio(mapperUtil.getModelMapper().map(masterDTO, OfferingPortfolio.class));
        return mapperUtil.getModelMapper().map(offeringPortfolio, MasterDTO.class);
    }

    @PutMapping(value = "/offeringPortfolio", consumes = "application/json", produces = "application/json")
    public MasterDTO updateOfferingPortfolio(@RequestBody MasterDTO masterDTO) {
        if (offeringPortfolioService.getOfferingPortfolio(masterDTO.getId()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "offering Porfotilo is not found for given id " + masterDTO.getId());
        }
        OfferingPortfolio offeringPortfolio = offeringPortfolioService
                .saveOfferingPortfolio(mapperUtil.getModelMapper().map(masterDTO, OfferingPortfolio.class));
        return mapperUtil.getModelMapper().map(offeringPortfolio, MasterDTO.class);
    }
}
