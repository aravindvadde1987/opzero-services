package com.opzero.service;

import com.opzero.entity.DataDetail;

import java.util.List;
import java.util.Optional;

public interface DataDetailService {
    Iterable<DataDetail> saveDataDetails(List<DataDetail> dataDetail);

    Optional<DataDetail> getDataDetail(Long dataDetailId);

    DataDetail updateDataDetails(DataDetail dataDetail);

    List<DataDetail> getDataDetails();

    public List<DataDetail> getDataDetailsByProjectId(Long projectId);

    public List<DataDetail> getDataDetailsByFiscalYearQuarterId(Long fiscalYearQuarterId);
}
