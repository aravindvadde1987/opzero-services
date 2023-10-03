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

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DataDetailServiceImpl implements DataDetailService {
    @Autowired
    DataDetailRepository dataDetailRepository;

    @Autowired
    SolutionDetailRepository solutionDetailRepository;

    @Override
    public Iterable<DataDetail> saveDataDetails(List<DataDetail> dataDetail) {
        Iterable<DataDetail> savedDataDetails = dataDetailRepository.saveAll(dataDetail);
        // Iterate through saved DataDetail objects to get SolutionDetail
        for (DataDetail d : savedDataDetails) {
            // Save SolutionDetail using the SolutionDetailRepository
            if (!d.getSolutionDetails().isEmpty()) {
                for (SolutionDetail solutionDetail : d.getSolutionDetails()) {
                    solutionDetail.setDataDetail(d);
                    // Save the updated SolutionDetail using the SolutionDetailRepository
                    solutionDetailRepository.save(solutionDetail);
                }
                solutionDetailRepository.saveAll(d.getSolutionDetails());
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
    public List<DataDetail> getDataDetailsByLeverId(Long leverId,Long projectId) {
        return null==projectId ?dataDetailRepository.findByLeverIdAndEffortSavedGreaterThan(leverId,0):
                dataDetailRepository.findByProjectIdAndLeverIdAndEffortSavedGreaterThan(projectId,leverId,0);
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
        return (null == projectId ?dataDetailRepository.getCountsByLevers():dataDetailRepository.getCountsByLeversByProject(projectId))
                .stream().collect(Collectors.toMap(
                d -> d[0],
                d -> d[1]));
    }
}
