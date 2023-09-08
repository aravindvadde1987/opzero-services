package com.opzero.repository;

import com.opzero.entity.DataDetail;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DataDetailRepository extends CrudRepository<DataDetail, Long> {
    List<DataDetail> findAll();

    List<DataDetail> findByProjectId(Long projectId);

    List<DataDetail> findByLeverIdAndEffortSavedGreaterThan(Long leverId,int effortSavedGreaterThan);

    List<DataDetail> findByProjectIdAndLeverIdAndEffortSavedGreaterThan(long projectId,Long leverId,int effortSavedGreaterThan);

    List<DataDetail> findByLeverIdAndFiscalYearQuarterId(Long leverId,Long fiscalYearQuarterId);

    List<DataDetail> findByFiscalYearQuarterId(Long quarterId);

    Optional<List<DataDetail>> findByProjectIdAndFiscalYearQuarterId(Long projectId, Long quarterId);

    @Query("select leverId,count(*) from DataDetail where effortSaved > 0 group by leverId")
    List<Long[]> getCountsByLevers();

    @Query("select leverId,count(*) from DataDetail where projectId=:projectId and  effortSaved > 0 group by leverId")
    List<Long[]> getCountsByLeversByProject(@Param("projectId")long projectId);


}