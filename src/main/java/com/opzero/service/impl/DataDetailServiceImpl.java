package com.opzero.service.impl;

import com.opzero.entity.DataDetail;
import com.opzero.entity.SolutionDetail;
import com.opzero.repository.DataDetailRepository;
import com.opzero.repository.SolutionDetailRepository;
import com.opzero.service.DataDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

@Service
public class DataDetailServiceImpl implements DataDetailService {
    @Autowired
    DataDetailRepository dataDetailRepository;

    @Autowired
    SolutionDetailRepository solutionDetailRepository;

    public List<DataDetail> saveDataDetails(List<DataDetail> dataDetails) {
        List<DataDetail> savedDataDetails = new ArrayList<>();

        for (DataDetail dataDetailIterator : dataDetails) {
            if (dataDetailIterator.getId() != null) {
                // Existing DataDetail, update it
                DataDetail persistedDataDetail = dataDetailRepository.save(dataDetailIterator);

                for (SolutionDetail solutionDetail : persistedDataDetail.getSolutionDetails()) {

                    solutionDetailRepository.delete(solutionDetail);
                }
                // Clear existing solutionDetails and add new ones
                persistedDataDetail.getSolutionDetails().clear();
                for (SolutionDetail solutionDetail : dataDetailIterator.getSolutionDetails()) {
                    solutionDetail.setDataDetail(persistedDataDetail);
                    // Save the updated SolutionDetail using the SolutionDetailRepository
                    persistedDataDetail.getSolutionDetails().add(solutionDetailRepository.save(solutionDetail));
                }

                savedDataDetails.add(persistedDataDetail);
            } else {
                // New DataDetail, directly save it
                DataDetail persistedDataDetail = dataDetailRepository.save(dataDetailIterator);

                // Save the new SolutionDetails
                List<SolutionDetail> solutionDetails = new CopyOnWriteArrayList<>(dataDetailIterator.getSolutionDetails());

                for (SolutionDetail solutionDetail : solutionDetails) {
                    solutionDetail.setDataDetail(persistedDataDetail);
                    // Save the SolutionDetail using the SolutionDetailRepository
                    persistedDataDetail.getSolutionDetails().add(solutionDetailRepository.save(solutionDetail));
                }
                savedDataDetails.add(persistedDataDetail);
            }
        }
        return savedDataDetails;
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
    public List<DataDetail> getDataDetailsByLeverId(Long leverId, Long projectId) {
        return null == projectId ? dataDetailRepository.findByLeverIdAndEffortSavedGreaterThan(leverId, 0) :
                dataDetailRepository.findByProjectIdAndLeverIdAndEffortSavedGreaterThan(projectId, leverId, 0);
    }

    @Override
    public List<DataDetail> getDataDetailsByLeverIdAndfinQtrId(Long leverId, Long fiscalYearQuarterId) {
        return dataDetailRepository.findByLeverIdAndFiscalYearQuarterId(leverId, fiscalYearQuarterId);
    }

    @Override
    public List<DataDetail> getDataDetailByProjectIdAndQuarterId(Long projectId, Long quarterId) {
        return dataDetailRepository.findByProjectIdAndFiscalYearQuarterId(projectId, quarterId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "DataDetail is not found for given projectId " + projectId));
    }

    @Override
    public List<DataDetail> getDataDetailsByFiscalYearQuarterId(Long fiscalYearQuarterId) {
        return dataDetailRepository.findByFiscalYearQuarterId(fiscalYearQuarterId);
    }

    @Override
    public Map<Long, Long> getCountsByLevers(Long projectId) {
        return (null == projectId ? dataDetailRepository.getCountsByLevers() : dataDetailRepository.getCountsByLeversByProject(projectId))
                .stream().collect(Collectors.toMap(
                        d -> d[0],
                        d -> d[1]));
    }
}
