package mx.com.newOrg.commons.transformer;

import java.util.ArrayList;
import java.util.List;

import mx.com.newOrg.commons.DTO.ReportDTO;
import mx.com.newOrg.model.entity.ReportDO;

public final class ReportTransformer {

    private ReportTransformer() {

    }

    public static ReportDTO transformDO(ReportDO entity) {

        ReportDTO dto = new ReportDTO();

        dto.setEnable(entity.getActive());
        dto.setId(entity.getReportId());
        dto.setLastDateEdit(entity.getLastModifiedDate());
        dto.setLastUserId(entity.getLastUserModified());
        dto.setMessage(entity.getMessage());
        dto.setReviewDate(entity.getReviewDate());
        dto.setShortMessage(entity.getShortMessage());
        dto.setAssignedId(entity.getAssingUserId());

        return dto;
    }

    public static ReportDO transformDTO(ReportDTO dto) {

        ReportDO entity = new ReportDO();

        entity.setActive(dto.isEnable());
        entity.setLastModifiedDate(dto.getLastDateEdit());
        entity.setLastUserModified(dto.getLastUserId());
        entity.setMessage(dto.getMessage());
        entity.setReviewDate(dto.getReviewDate());
        entity.setShortMessage(dto.getShortMessage());
        entity.setReportId(dto.getId());
        entity.setAssingUserId(dto.getAssignedId());

        return entity;
    }

    public static List<ReportDTO> transformDO(List<ReportDO> list) {

        List<ReportDTO> dtoList = new ArrayList<ReportDTO>();

        if (list != null) {
            for (ReportDO iterator : list) {
                dtoList.add(transformDO(iterator));
            }
        }

        return dtoList;
    }

    public static List<ReportDO> transformDTO(List<ReportDTO> list) {

        List<ReportDO> entityList = new ArrayList<ReportDO>();

        if (list != null) {

            for (ReportDTO iterator : list) {
                entityList.add(transformDTO(iterator));
            }

        }

        return entityList;
    }

}
