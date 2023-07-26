package com.opzero.controller;

import com.opzero.entity.DataDetail;
import com.opzero.entity.dto.MasterDTO;
import com.opzero.service.DataDetailService;
import com.opzero.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class DataDetailController {
    @Autowired
    DataDetailService dataDetailService;
    @Autowired
    MapperUtil mapperUtil;

    @GetMapping("/dataDetail/{id}")
    public MasterDTO getDataDetail(@PathVariable("id") Long id) {
        if (dataDetailService.getDataDetail(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "DataDetail is not found for given id " + id);
        }
        return mapperUtil.getModelMapper().map(dataDetailService.getDataDetail(id).get(), MasterDTO.class);
    }

    @GetMapping("/dataDetail/project/{projectId}")
    public List<MasterDTO> getDataDetailByProjectId(@PathVariable("projectId") Long projectId) {
        if (dataDetailService.getDataDetailsByProjectId(projectId).size() == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "DataDetail is not found for given projectId " + projectId);
        }
        return dataDetailService.getDataDetailsByProjectId(projectId).stream().map(dataDetails -> mapperUtil.getModelMapper().map(dataDetails, MasterDTO.class)).collect(Collectors.toList());
    }

    @GetMapping("/dataDetail/project/{projectId}/{quarterId}")
    public List<MasterDTO> getDataDetailByProjectIdAndQuarterId(@PathVariable("projectId") Long projectId,@PathVariable("quarterId") Long quarterId) {
        return dataDetailService.getDataDetailByProjectIdAndQuarterId(projectId,quarterId).stream().map(dataDetails -> mapperUtil.getModelMapper().map(dataDetails, MasterDTO.class)).collect(Collectors.toList());
    }

    @GetMapping("/dataDetail/fiscalYearQuarter/{quarterId}")
    public List<MasterDTO> getDataDetailByQuarterId(@PathVariable("quarterId") Long quarterId) {
        if (dataDetailService.getDataDetailsByFiscalYearQuarterId(quarterId).size() == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "DataDetail is not found for given quarterId " + quarterId);
        }
        return dataDetailService.getDataDetailsByFiscalYearQuarterId(quarterId).stream().map(dataDetails -> mapperUtil.getModelMapper().map(dataDetails, MasterDTO.class)).collect(Collectors.toList());
    }

    @GetMapping("/dataDetails")
    public List<MasterDTO> getDataDetails() {
        return dataDetailService.getDataDetails().stream().map(dataDetails -> mapperUtil.getModelMapper().map(dataDetails, MasterDTO.class)).collect(Collectors.toList());
    }

    @PostMapping(value = "/dataDetail", consumes = "application/json", produces = "application/json")
    public MasterDTO saveDataDetail(@RequestBody MasterDTO masterDTO) {
        DataDetail dataDetail = dataDetailService.saveDataDetail(mapperUtil.getModelMapper().map(masterDTO, DataDetail.class));

        return mapperUtil.getModelMapper().map(dataDetail, MasterDTO.class);
    }

    @PutMapping(value = "/dataDetail", consumes = "application/json", produces = "application/json")
    public MasterDTO updateDataDetail(@RequestBody MasterDTO masterDTO) {
        if (dataDetailService.getDataDetail(masterDTO.getId()).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "dataDetail is not found for given id " + masterDTO.getId());
        }
        DataDetail dataDetail = dataDetailService.saveDataDetail(mapperUtil.getModelMapper().map(masterDTO, DataDetail.class));

        return mapperUtil.getModelMapper().map(dataDetail, MasterDTO.class);
    }
}
