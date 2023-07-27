package com.opzero.service.impl;

import com.opzero.entity.DataDetail;
import com.opzero.repository.DataDetailRepository;
import com.opzero.service.DataDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DataDetailServiceImpl implements DataDetailService {
    @Autowired
    DataDetailRepository dataDetailRepository;

    @Override
    public Iterable<DataDetail> saveDataDetails(List<DataDetail> dataDetail) {
        return dataDetailRepository.saveAll(dataDetail);
    }

    @Override
    public Optional<DataDetail> getDataDetail(Long dataDetailId) {
        return dataDetailRepository.findById(dataDetailId);
    }

    @Override
    public DataDetail updateDataDetails(DataDetail dataDetail) {
        return dataDetailRepository.save(dataDetail);
    }

    @Override
    public List<DataDetail> getDataDetails() {
        return dataDetailRepository.findAll();
    }

    @Override
    public List<DataDetail> getDataDetailsByProjectId(Long projectId) {
        return dataDetailRepository.findByProjectId(projectId);
    }

    @Override
    public List<DataDetail> getDataDetailsByFiscalYearQuarterId(Long fiscalYearQuarterId) {
        return dataDetailRepository.findByFiscalYearQuarterId(fiscalYearQuarterId);
    }
}
