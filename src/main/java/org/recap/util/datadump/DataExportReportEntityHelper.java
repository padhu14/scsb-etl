package org.recap.util.datadump;

import org.recap.ReCAPConstants;
import org.recap.model.jpa.ReportDataEntity;
import org.recap.model.jpa.ReportEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * Created by peris on 11/11/16.
 */

@Component
public class DataExportReportEntityHelper {
    public ReportEntity processSuccessReportEntity(List<ReportEntity> byFileName, Map values) {
        String requestingInstitutionCode = (String) values.get(ReCAPConstants.REQUESTING_INST_CODE);
        String type = (String) values.get(ReCAPConstants.BATCH_EXPORT);
        String requestId = (String) (values.get(ReCAPConstants.REQUEST_ID));
        String numBibsExported = (String) values.get(ReCAPConstants.NUM_BIBS_EXPORTED);
        String numRecords = (String) values.get(ReCAPConstants.NUM_RECORDS);

        ReportEntity reportEntity = null;
        if (CollectionUtils.isEmpty(byFileName)) {
            reportEntity = new ReportEntity();
            reportEntity.setCreatedDate(new Date());
            reportEntity.setInstitutionName(requestingInstitutionCode);
            reportEntity.setType(type);
            reportEntity.setFileName(requestId);

            ArrayList<ReportDataEntity> reportDataEntities = new ArrayList<>();
            ReportDataEntity reportDataEntity = new ReportDataEntity();
            reportDataEntities.add(reportDataEntity);
            reportDataEntity.setHeaderName(numBibsExported);
            reportDataEntity.setHeaderValue(numRecords);
            reportEntity.setReportDataEntities(reportDataEntities);

        } else {
            reportEntity = byFileName.get(0);
            List<ReportDataEntity> reportDataEntities = reportEntity.getReportDataEntities();
            for (Iterator<ReportDataEntity> iterator = reportDataEntities.iterator(); iterator.hasNext(); ) {
                ReportDataEntity reportDataEntity = iterator.next();
                if (reportDataEntity.getHeaderName().equals(numBibsExported)) {
                    reportDataEntity.setHeaderValue(String.valueOf(Integer.valueOf(reportDataEntity.getHeaderValue()) + Integer.valueOf(numRecords)));
                }
            }
        }

        return reportEntity;
    }

    public ReportEntity processFailureReportEntity(List<ReportEntity> byFileName, Map values) {
        ReportEntity reportEntity = null;

        String requestingInstitutionCode = (String) values.get(ReCAPConstants.REQUESTING_INST_CODE);
        String type = (String) values.get(ReCAPConstants.BATCH_EXPORT);
        String requestId = (String) (values.get(ReCAPConstants.REQUEST_ID));
        String numRecords = (String) values.get(ReCAPConstants.NUM_RECORDS);
        String failureCause = (String) values.get(ReCAPConstants.FAILURE_CAUSE);

        if (CollectionUtils.isEmpty(byFileName)) {
            reportEntity = new ReportEntity();
            reportEntity.setCreatedDate(new Date());
            reportEntity.setInstitutionName(requestingInstitutionCode);
            reportEntity.setType(type);
            reportEntity.setFileName(requestId);

            ArrayList<ReportDataEntity> reportDataEntities = new ArrayList<>();

            ReportDataEntity reportDataEntity = new ReportDataEntity();
            reportDataEntities.add(reportDataEntity);
            reportDataEntity.setHeaderName(ReCAPConstants.FAILED_BIBS);
            reportDataEntity.setHeaderValue(numRecords);

            ReportDataEntity reportDataEntity1 = new ReportDataEntity();
            reportDataEntity1.setHeaderName(ReCAPConstants.FAILURE_CAUSE);
            reportDataEntity1.setHeaderValue(failureCause);
            reportDataEntities.add(reportDataEntity1);
            reportEntity.setReportDataEntities(reportDataEntities);
        } else {
            reportEntity = byFileName.get(0);
            List<ReportDataEntity> reportDataEntities = reportEntity.getReportDataEntities();
            for (Iterator<ReportDataEntity> iterator = reportDataEntities.iterator(); iterator.hasNext(); ) {
                ReportDataEntity reportDataEntity = iterator.next();
                if (reportDataEntity.getHeaderName().equals(ReCAPConstants.FAILED_BIBS)) {
                    Integer exitingRecords = Integer.valueOf(reportDataEntity.getHeaderValue());
                    reportDataEntity.setHeaderValue(String.valueOf(exitingRecords + Integer.valueOf(numRecords)));
                }
            }
            ReportDataEntity reportDataEntity1 = new ReportDataEntity();
            reportDataEntity1.setHeaderName(ReCAPConstants.FAILURE_CAUSE);
            reportDataEntity1.setHeaderValue(failureCause);
            reportDataEntities.add(reportDataEntity1);
        }

        return reportEntity;
    }
}
