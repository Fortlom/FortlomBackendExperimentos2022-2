package com.example.fortlomisw.backend.service;

import com.example.fortlomisw.backend.domain.model.entity.Person;
import com.example.fortlomisw.backend.domain.model.entity.Report;
import com.example.fortlomisw.backend.domain.persistence.ReportRepository;
import com.example.fortlomisw.backend.domain.persistence.UserRepository;
import com.example.fortlomisw.backend.domain.service.ReportService;
import com.example.fortlomisw.shared.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import javax.validation.Validator;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {




    private static final String ENTITY = "Report";
    @Autowired
    private ReportRepository reportRepository;
    @Autowired
    private UserRepository userRepository;


    public ReportServiceImpl() {

    }


    @Override
    public List<Report> getAll() {
        return reportRepository.findAll();
    }

    @Override
    public Page<Report> getAll(Pageable pageable) {
        return reportRepository.findAll(pageable);
    }

    @Override
    public Report getById(Long reportId) {
        return reportRepository.findById(reportId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, reportId));
    }

    @Override
    public Report create(Long UserMainId, Long UserReportedId, Report request) {
        Person usermain = userRepository.findById(UserMainId)
                .orElseThrow(() -> new ResourceNotFoundException("User", UserMainId));
        return userRepository.findById(UserReportedId)
                .map(report -> {
                    request.setUserReported(report);
                    request.setUserMain(usermain);
                    return reportRepository.save(request);
                })
                .orElseThrow(() -> new ResourceNotFoundException("User", UserReportedId));
    }

    @Override
    public Report update(Long reportId, Report request) {
        return null;
    }

    @Override
    public List<Report> findByUserMainId(Long UserMainId) {
        return reportRepository.findByUserMainId(UserMainId);
    }

    @Override
    public List<Report> findByUserReportedId(Long UserReportedId) {
        return reportRepository.findByUserReportedId(UserReportedId);
    }

    @Override
    public ResponseEntity<?> delete(Long reportId) {
        return reportRepository.findById(reportId).map(post -> {
            reportRepository.delete(post);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, reportId));
    }
}
