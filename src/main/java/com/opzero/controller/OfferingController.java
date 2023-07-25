package com.opzero.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.opzero.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.opzero.entity.Offering;
import com.opzero.entity.dto.MasterDTO;
import com.opzero.service.OfferingService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class OfferingController {
    @Autowired
    OfferingService offeringService;

    @Autowired
    MapperUtil mapperUtil;


    @GetMapping("/offering/{id}")
    public MasterDTO getOffering(@PathVariable("id") Long id) {
        if (offeringService.getOffering(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "offering is not found for given id " + id);
        }
        return mapperUtil.getModelMapper().map(offeringService.getOffering(id), MasterDTO.class);
    }

    @GetMapping("/offerings")
    public List<MasterDTO> getOfferings() {
        if (offeringService.getOfferings().size() == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "offerings not found");
        }
        return offeringService.getOfferings().stream().map(offering -> mapperUtil.getModelMapper().map(offering, MasterDTO.class))
                .collect(Collectors.toList());
    }

    @PostMapping(value = "/offering", consumes = "application/json", produces = "application/json")
    public MasterDTO saveOffering(@RequestBody MasterDTO masterDTO) {
        Offering offering = offeringService.saveOffering(mapperUtil.getModelMapper().map(masterDTO, Offering.class));
        return mapperUtil.getModelMapper().map(offering, MasterDTO.class);
    }

    @PutMapping(value = "/offering", consumes = "application/json", produces = "application/json")
    public MasterDTO updatOffering(@RequestBody MasterDTO masterDTO) {
        if (offeringService.getOffering(masterDTO.getId()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "offering is not found for given id " + masterDTO.getId());
        }
        Offering offering = offeringService.saveOffering(mapperUtil.getModelMapper().map(masterDTO, Offering.class));
        return mapperUtil.getModelMapper().map(offering, MasterDTO.class);
    }
}
