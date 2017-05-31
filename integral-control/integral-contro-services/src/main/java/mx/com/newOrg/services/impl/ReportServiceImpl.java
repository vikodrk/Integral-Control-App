package mx.com.newOrg.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import mx.com.newOrg.commons.CustomAppCache;
import mx.com.newOrg.commons.DTO.ReportDTO;
import mx.com.newOrg.commons.DTO.ThirtUserDTO;
import mx.com.newOrg.commons.transformer.ReportTransformer;
import mx.com.newOrg.model.entity.ReportDO;
import mx.com.newOrg.services.IReportService;
import mx.com.newOrg.services.IThirtUserService;

public class ReportServiceImpl implements IReportService {

    private static int count;

    private static CustomAppCache<Long, ReportDTO, ReportDO> LOCAL_CACHE =
        new CustomAppCache<Long, ReportDTO, ReportDO>();

    private static CustomAppCache<ThirtUserDTO, ThirtUserDTO, ReportDO> LIST_LOCAL_CACHE =
        new CustomAppCache<ThirtUserDTO, ThirtUserDTO, ReportDO>();

    private IThirtUserService thirtService = new ThirtUserServiceImpl();

    public void createReport(ReportDTO dto) {

        ReportDO entity = ReportTransformer.transformDTO(dto);
        entity.setReportId(Long.valueOf(count++));
        dto.setId(entity.getReportId());
        LOCAL_CACHE.putOnCache(entity.getReportId(), dto, entity);

        ThirtUserDTO thirtDTO = thirtService.findById(entity.getAssingUserId());
        List<ReportDTO> list = thirtDTO.getAsignedReports();
        if (list == null) {
            list = new ArrayList<ReportDTO>();
        }
        list.add(dto);

        thirtDTO.setAsignedReports(list);
        thirtService.updateThirtUser(thirtDTO);

        if (LIST_LOCAL_CACHE.getID_MAP().containsKey(thirtDTO)) {
            LIST_LOCAL_CACHE.updateToCache(thirtDTO, thirtDTO,
                ReportTransformer.transformDTO(list));
        } else {
            LIST_LOCAL_CACHE.putOnCache(thirtDTO, thirtDTO,
                ReportTransformer.transformDTO(list));
        }

    }

    public void updateReport(ReportDTO dto) {

        ReportDO entity = ReportTransformer.transformDTO(dto);

        LOCAL_CACHE.updateToCache(entity.getReportId(), dto, entity);

        ThirtUserDTO thirtDTO = thirtService.findById(dto.getAssignedId());
        List<ReportDTO> reportList = thirtDTO.getAsignedReports();

        int indx = reportList.indexOf(entity);
        reportList.remove(indx);
        reportList.add(dto);

        thirtDTO.setAsignedReports(reportList);
        thirtService.updateThirtUser(thirtDTO);

        LIST_LOCAL_CACHE.updateToCache(thirtDTO, thirtDTO,
            ReportTransformer.transformDTO(reportList));

    }

    public void deleteReport(ReportDTO dto) {

        LOCAL_CACHE.deleteFromCache(dto.getId());

        ThirtUserDTO userDTO = thirtService.findById(dto.getAssignedId());
        List<ReportDTO> reportList = userDTO.getAsignedReports();

        reportList.remove(dto);

        userDTO.setAsignedReports(reportList);
        thirtService.updateThirtUser(userDTO);

        LIST_LOCAL_CACHE.updateToCache(userDTO, userDTO,
            ReportTransformer.transformDTO(reportList));

    }

    public List<ReportDTO> findAll() {

        List<ReportDTO> reportList = new ArrayList<ReportDTO>();

        Set<Long> ids = LOCAL_CACHE.getID_MAP().keySet();
        for (Long iterator : ids) {
            reportList.add(LOCAL_CACHE.getFromCache(iterator));
        }

        return reportList;
    }

    public List<ReportDTO> findByUserId(Long id) {

        List<ReportDTO> finalReportList = new ArrayList<ReportDTO>();

        List<ReportDTO> allReports = findAll();

        for (ReportDTO iterator : allReports) {
            if (iterator.getLastUserId() == id) {

                finalReportList.add(iterator);

            }

        }

        return finalReportList;
    }

    public List<ReportDTO> findAssignedReports(Long id) {

        ThirtUserDTO userDTO = thirtService.findById(id);
        List<ReportDTO> reportList = ReportTransformer
            .transformDO(LIST_LOCAL_CACHE.getListFromCache(userDTO));
        return reportList;
    }

    public List<ReportDTO> findAllClosedReports() {

        List<ReportDTO> resultList = new ArrayList<ReportDTO>();
        List<ReportDTO> allReports = findAll();
        for (ReportDTO iterator : allReports) {
            if (!iterator.isEnable()) {
                resultList.add(iterator);
            }
        }
        return resultList;
    }

    public List<ReportDTO> findAllOpenReports() {

        List<ReportDTO> allReports = findAll();
        List<ReportDTO> resultList = new ArrayList<ReportDTO>();

        for (ReportDTO iterator : allReports) {
            if (iterator.isEnable()) {
                resultList.add(iterator);
            }
        }

        return resultList;
    }

    public List<ReportDTO> findAllClosedReports(Long userId) {

        List<ReportDTO> resultList = new ArrayList<ReportDTO>();
        List<ReportDTO> allReports = findAssignedReports(userId);

        for (ReportDTO iterator : allReports) {
            if (!iterator.isEnable()) {
                resultList.add(iterator);
            }
        }

        return resultList;
    }

    public List<ReportDTO> findAllOpenReports(Long userId) {

        List<ReportDTO> resultList = new ArrayList<ReportDTO>();
        List<ReportDTO> allReports = findAssignedReports(userId);

        for (ReportDTO iterator : allReports) {
            if (iterator.isEnable()) {
                resultList.add(iterator);
            }
        }

        return resultList;
    }

    public List<ReportDTO> findAllClosedReports(ThirtUserDTO dto) {

        List<ReportDO> resultList = LIST_LOCAL_CACHE.getListFromCache(dto);
        List<ReportDTO> dtoList = new ArrayList<ReportDTO>();
        for (ReportDO item : resultList) {
            if (!item.getActive()) {
                dtoList.add(ReportTransformer.transformDO(item));
            }
        }

        return dtoList;
    }

    public List<ReportDTO> findAllOpenReports(ThirtUserDTO dto) {

        List<ReportDO> resultList = LIST_LOCAL_CACHE.getListFromCache(dto);
        List<ReportDTO> dtoList = new ArrayList<ReportDTO>();
        for (ReportDO item : resultList) {
            if (item.getActive()) {
                dtoList.add(ReportTransformer.transformDO(item));
            }
        }

        return dtoList;
    }

}
