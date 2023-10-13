package com.opzero.controller;

import com.opzero.entity.Scope;
import com.opzero.entity.dto.MasterDTO;
import com.opzero.service.ScopeService;
import com.opzero.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ScopeController {
    @Autowired
    ScopeService scopeService;
    @Autowired
    MapperUtil mapperUtil;

    @GetMapping("/scope/{id}")
    public MasterDTO getScope(@PathVariable("id") Long id) {
        if (!scopeService.getScope(id).isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "scope is not found for given id " + id);
        }
        return mapperUtil.getModelMapper().map(scopeService.getScope(id).get(), MasterDTO.class);
    }

    @GetMapping("/scopes")
    public List<MasterDTO> getScopes() {
        return scopeService.getScopes().stream().map(scope -> mapperUtil.getModelMapper().map(scope, MasterDTO.class)).collect(Collectors.toList());
    }

    @GetMapping("/activeScopes")
    public List<MasterDTO> getActiveScopes() {
        List<MasterDTO> scopes = scopeService.getScopes().stream().map(scope -> mapperUtil.getModelMapper().map(scope, MasterDTO.class)).filter(masterDto -> masterDto.isActive()).collect(Collectors.toList());

        for (MasterDTO scope : scopes) {
            List<MasterDTO> childrens = scope.getChildrens().stream().filter(masterDto -> masterDto.isActive()).collect(Collectors.toList());
            scope.setChildrens(childrens);
        }
        return scopes;
    }

    @PostMapping(value = "/scope", consumes = "application/json", produces = "application/json")
    public MasterDTO saveScope(@RequestBody MasterDTO masterDTO) {
        Scope scope = scopeService.saveScope(mapperUtil.getModelMapper().map(masterDTO, Scope.class));
        return mapperUtil.getModelMapper().map(scope, MasterDTO.class);
    }

    @PutMapping(value = "/scope", consumes = "application/json", produces = "application/json")
    public MasterDTO updateScope(@RequestBody MasterDTO masterDTO) {
        if (!scopeService.getScope(masterDTO.getId()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Scope is not found for given id " + masterDTO.getId());
        }
        Scope scope = scopeService.saveScope(mapperUtil.getModelMapper().map(masterDTO, Scope.class));
        return mapperUtil.getModelMapper().map(scope, MasterDTO.class);
    }
}
