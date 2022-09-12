package com.example.fortlomisw.backend.domain.persistence;


import com.example.fortlomisw.backend.domain.model.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<Report,Long> {


    List<Report> findByUserMainId(Long UserMainId);
    List<Report> findByUserReportedId(Long UserReportedId);


}
