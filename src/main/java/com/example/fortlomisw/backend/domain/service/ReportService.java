package com.example.fortlomisw.backend.domain.service;
import com.example.fortlomisw.backend.domain.model.entity.Report;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;


import java.util.List;
public interface ReportService {

    List<Report> getAll();
    Page<Report> getAll(Pageable pageable);
    Report getById(Long reportId);
    Report create(Long UserMainId, Long UserReportedId, Report report);
    Report update(Long reportId, Report request);
    List<Report> findByUserMainId(Long UserMainId);
    List<Report> findByUserReportedId(Long UserReportedId);
    ResponseEntity<?> delete(Long rateId);

}
