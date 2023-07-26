package com.opzero.service;

import com.opzero.entity.DataDetail;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface DataDetailService {
    DataDetail saveDataDetail(DataDetail dataDetail);

    Optional<DataDetail> getDataDetail(Long dataDetailId);

    DataDetail updateDataDetail(DataDetail dataDetail);

    List<DataDetail> getDataDetails();

    public List<DataDetail> getDataDetailsByProjectId(Long projectId);

    public List<DataDetail> getDataDetailsByFiscalYearQuarterId(Long fiscalYearQuarterId);

    List<DataDetail> getDataDetailByProjectIdAndQuarterId(Long projectId, Long quarterId);
}
