package com.opzero.controller;

import com.opzero.entity.DataDetail;
import com.opzero.entity.FiscalYearQuarter;
import com.opzero.entity.Project;
import com.opzero.entity.dto.MasterDTO;
import com.opzero.service.DataDetailService;
import com.opzero.service.FiscalYearQuarterService;
import com.opzero.service.ProjectService;
import com.opzero.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class DataDetailController {
    @Autowired
    DataDetailService dataDetailService;
    @Autowired
    ProjectService projectService;

    @Autowired
    FiscalYearQuarterService fiscalYearQuarterService;
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

    @GetMapping("/dataDetail/leverProjects/{leverId}")
    public List<MasterDTO> getProjectDataDetailsByLeverId(@PathVariable("leverId") Long leverId,@RequestParam(value = "projectId", required = false) Long projectId) {
        List<MasterDTO> response = dataDetailService.getDataDetailsByLeverId(leverId,projectId).stream().map(dataDetails -> mapperUtil.getModelMapper().map(dataDetails, MasterDTO.class)).collect(Collectors.toList());
        for (MasterDTO masterDTO : response) {
            Project proj = projectService.getProject(masterDTO.getProjectId()).get();
            masterDTO.setProjectName(proj.getProjectName());
            masterDTO.setActive(proj.isActive());
            masterDTO.setFiscalYearQuarterDesc((fiscalYearQuarterService.getFiscalYearQuarter(masterDTO.getFiscalYearQuarterId())).get().getFiscalYearQuarterDesc());
        }
        return response;
    }

    @GetMapping("/dataDetail/leverProjects/{leverId}/{fiscalYearQuarterId}")
    public List<MasterDTO> getProjectDataDetailsByLeverIdAndFiscalYearQuarterId(@PathVariable("leverId") Long leverId, @PathVariable("fiscalYearQuarterId") Long fiscalYearQuarterId) {
        if (dataDetailService.getDataDetailsByLeverIdAndfinQtrId(leverId, fiscalYearQuarterId).size() == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "DataDetail is not found for given leverId " + leverId);
        }
        List<MasterDTO> response = dataDetailService.getDataDetailsByLeverIdAndfinQtrId(leverId, fiscalYearQuarterId).stream().map(dataDetails -> mapperUtil.getModelMapper().map(dataDetails, MasterDTO.class)).collect(Collectors.toList());
        for (MasterDTO masterDTO : response) {
            Project proj = projectService.getProject(masterDTO.getProjectId()).get();
            masterDTO.setProjectName(proj.getProjectName());
            masterDTO.setActive(proj.isActive());
        }
        return response;
    }

    @GetMapping("/dataDetail/project/{projectId}/{quarterId}")
    public List<MasterDTO> getDataDetailByProjectIdAndQuarterId(@PathVariable("projectId") Long projectId, @PathVariable("quarterId") Long quarterId) {
        List<MasterDTO> response = dataDetailService.getDataDetailByProjectIdAndQuarterId(projectId, quarterId).stream().map(dataDetails -> mapperUtil.getModelMapper().map(dataDetails, MasterDTO.class)).collect(Collectors.toList());
        if (response.isEmpty()) {
            Optional<DataDetail> latestDataDetails = dataDetailService.getDataDetailsByProjectId(projectId)
                    .stream()
                    .max(Comparator.comparing(dataDetails ->
                            fiscalYearQuarterService.getFiscalYearQuarter(dataDetails.getFiscalYearQuarterId())
                                    .orElse(new FiscalYearQuarter()) // Provide a default in case Optional is empty
                                    .getEndDate()));

            List<MasterDTO> responseList = latestDataDetails.map(dataDetails ->
                            Collections.singletonList(mapperUtil.getModelMapper().map(dataDetails, MasterDTO.class)))
                    .orElse(Collections.emptyList());
            if (!responseList.isEmpty()) {
                return dataDetailService.getDataDetailByProjectIdAndQuarterId
                                (projectId, responseList.get(0).getFiscalYearQuarterId()).stream().map(dataDetails -> mapperUtil.getModelMapper().map(dataDetails, MasterDTO.class)).
                        collect(Collectors.toList());
            } else {
                return Collections.emptyList();
            }
        } else return response;
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

    @PostMapping(value = "/dataDetails", consumes = "application/json", produces = "application/json")
    public List<MasterDTO> saveDataDetail(@RequestBody List<MasterDTO> masterDTOList) {
        List<DataDetail> dataDetailList = masterDTOList.stream().map(masterDTO -> mapperUtil.getModelMapper().map(masterDTO, DataDetail.class)).collect(Collectors.toList());

        Iterable<DataDetail> savedDataDetails = dataDetailService.saveDataDetails(dataDetailList);

        return StreamSupport.stream(savedDataDetails.spliterator(), false).map(dataDetail -> mapperUtil.getModelMapper().map(dataDetail, MasterDTO.class)).collect(Collectors.toList());
    }

    @PutMapping(value = "/dataDetails", consumes = "application/json", produces = "application/json")
    public List<MasterDTO> updateDataDetails(@RequestBody List<MasterDTO> masterDTOList) {
        List<DataDetail> dataDetailList = masterDTOList.stream().map(masterDTO -> mapperUtil.getModelMapper().map(masterDTO, DataDetail.class)).collect(Collectors.toList());

        Iterable<DataDetail> savedDataDetails = dataDetailService.saveDataDetails(dataDetailList);

        return StreamSupport.stream(savedDataDetails.spliterator(), false).map(dataDetail -> mapperUtil.getModelMapper().map(dataDetail, MasterDTO.class)).collect(Collectors.toList());
    }

    @GetMapping("/dataDetail/countsByLevers")
    public Map<Long, Long> getCountsByLevers(@RequestParam(value = "projectId", required = false) Long projectId) {
        return dataDetailService.getCountsByLevers(projectId);
    }
}