package com.opzero.repository;

import com.opzero.entity.DataDetail;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DataDetailRepository extends CrudRepository<DataDetail, Long> {
    List<DataDetail> findAll();

    List<DataDetail> findByProjectId(Long projectId);

    List<DataDetail> findByFiscalYearQuarterId(Long quarterId);
}