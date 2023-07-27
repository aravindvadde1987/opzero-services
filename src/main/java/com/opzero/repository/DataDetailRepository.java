package com.opzero.repository;

import com.opzero.entity.DataDetail;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DataDetailRepository extends CrudRepository<DataDetail, Long> {
    List<DataDetail> findAll();

    List<DataDetail> findByProjectId(Long projectId);

    List<DataDetail> findByFiscalYearQuarterId(Long quarterId);

    Optional<List<DataDetail>> findByProjectIdAndFiscalYearQuarterId(Long projectId, Long quarterId);
}