package mx.com.newOrg.services;

import java.util.List;

import mx.com.newOrg.commons.DTO.ReportDTO;
import mx.com.newOrg.commons.DTO.ThirtUserDTO;

public interface IReportService {
    
    void createReport(ReportDTO dto);
    
    void updateReport(ReportDTO dto);
    
    void deleteReport(ReportDTO dto);
    
    List<ReportDTO> findAll();
    
    List<ReportDTO> findByUserId(Long id);
     
    List<ReportDTO> findAssignedReports(Long id);
    
    List<ReportDTO> findAllClosedReports();
    
    List<ReportDTO> findAllOpenReports();
    
    List<ReportDTO> findAllClosedReports(Long userId);
    
    List<ReportDTO> findAllOpenReports(Long userId);
    
    List<ReportDTO> findAllClosedReports(ThirtUserDTO dto);
    
    List<ReportDTO> findAllOpenReports(ThirtUserDTO dto);

}
