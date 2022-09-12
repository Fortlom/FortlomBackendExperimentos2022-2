package com.example.fortlomisw.backend.api;




import com.example.fortlomisw.backend.domain.model.entity.Report;
import com.example.fortlomisw.backend.domain.service.ReportService;
import com.example.fortlomisw.backend.mapping.ReportMapper;
import com.example.fortlomisw.backend.resource.Report.CreateReportResource;
import com.example.fortlomisw.backend.resource.Report.ReportResource;
import com.example.fortlomisw.backend.resource.Report.UpdateReportResource;


import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;







@RestController
@RequestMapping("/api/v1")
public class ReportController {







    @Autowired
    private ReportService reportservice;

    @Autowired
    private ReportMapper mapper;

    @Autowired
    private ModelMapper mapping;
    @ApiOperation(value="getAllReports",notes = "Esta consulta nos retorna todos los reportes existentes")
    @GetMapping("/reports")
    public Page<ReportResource> getAllReports(Pageable pageable) {
        return mapper.modelListToPage(reportservice.getAll(), pageable);
    }
    @ApiOperation(value="getReportById",notes = "Esta consulta nos ayuda a retorna un reporte segun su id")
    @GetMapping("/reports/{reportId}")
    public ReportResource getReportById(@PathVariable("reportId") Long followId) {
        return mapper.toResource(reportservice.getById(followId));
    }
    @ApiOperation(value="createReport",notes = "Esta consulta nos ayuda a crear un reporte segun el id del usuario principal y del usuario a reportar")
    @PostMapping("/usersmains/{UserMainId}/usersreports/{UserReportedId}/reports")
    public ReportResource createReport(@PathVariable Long UserMainId, @PathVariable Long UserReportedId, @RequestBody CreateReportResource request) {
        Report comment = mapping.map(request, Report.class);
        return mapping.map(reportservice.create(UserMainId, UserReportedId, comment), ReportResource.class);
    }
    @ApiOperation(value="getAllReportsByMainId",notes = "Esta consulta nos retorna todos los reportes segun el id del usuario que va a reportar")
    @GetMapping("/usersmains/{UserMainId}/reports")
    public Page<ReportResource> getAllReportsByMainId(@PathVariable Long UserMainId,Pageable pageable) {
        return mapper.modelListToPage(reportservice.findByUserMainId(UserMainId), pageable);
    }
    @ApiOperation(value="getAllReportsByReportedId",notes = "Esta consulta nos retorna todos los reportes segun el id del usuario que es reportado")
    @GetMapping("/usersreports/{UserReportedId}/reports")
    public Page<ReportResource> getAllReportsByReportedId(@PathVariable Long UserReportedId,Pageable pageable) {
        return mapper.modelListToPage(reportservice.findByUserReportedId(UserReportedId), pageable);
    }
    @ApiOperation(value="deleteReport",notes = "Esta consulta nos elimina un reporte segun su id")
    @DeleteMapping("/reports/{reportId}")
    public ResponseEntity<?> deleteReport(@PathVariable Long reportId) {
        return reportservice.delete(reportId);
    }

    @ApiOperation(value="updateReport",notes = "Esta consulta nos ayuda a actualizar un reporte segun su id")
    @PutMapping("/reports/{reportId}")
    public ReportResource updateReport(@PathVariable Long reportId, @RequestBody UpdateReportResource request) {
        return mapper.toResource(reportservice.update(reportId, mapper.toModel(request)));
    }






}
