package org.recap.controller.swagger;

import org.recap.RecapConstants;
import org.recap.camel.dynamicrouter.DynamicRouteBuilder;
import org.recap.model.export.DataDumpRequest;
import org.recap.service.preprocessor.DataDumpExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by premkb on 19/8/16.
 */
@RestController
@RequestMapping("/dataDump")
public class DataDumpRestController {


    @Autowired
    private DataDumpExportService dataDumpExportService;

    @Autowired
    private DynamicRouteBuilder dynamicRouteBuilder;

    /**
     * Gets data dump export service.
     *
     * @return the data dump export service
     */
    public DataDumpExportService getDataDumpExportService() {
        return dataDumpExportService;
    }

    /**
     * Gets dynamic route builder.
     *
     * @return the dynamic route builder
     */
    public DynamicRouteBuilder getDynamicRouteBuilder() {
        return dynamicRouteBuilder;
    }

    /**
     * API to initiate the data dump export.
     *
     * @param institutionCodes          the institution codes
     * @param requestingInstitutionCode the requesting institution code
     * @param fetchType                 the fetch type
     * @param outputFormat              the output format
     * @param date                      the date
     * @param toDate                    the toDate
     * @param collectionGroupIds        the collection group ids
     * @param transmissionType          the transmission type
     * @param emailToAddress            the email to address
     * @return string
     */
    @RequestMapping(value="/exportDataDump", method = RequestMethod.GET)
    @ResponseBody
    public String exportDataDump(@RequestParam String institutionCodes,
                                         @RequestParam String requestingInstitutionCode,
                                         @RequestParam String fetchType,
                                         @RequestParam String outputFormat,
                                         @RequestParam(required=false) String date,
                                         @RequestParam(required=false) String toDate,
                                         @RequestParam(required=false) String collectionGroupIds,
                                         @RequestParam(required=false) String transmissionType,
                                         @RequestParam(required=false) String emailToAddress
    ){
        RecapConstants.EXPORT_SCHEDULER_CALL = false;
        DataDumpRequest dataDumpRequest = new DataDumpRequest();
        getDynamicRouteBuilder().addDataDumpExportRoutes();
        getDataDumpExportService().setDataDumpRequest(dataDumpRequest,fetchType,institutionCodes,date, toDate, collectionGroupIds,transmissionType,requestingInstitutionCode,emailToAddress,outputFormat);
        String responseMessage = getDataDumpExportService().validateIncomingRequest(dataDumpRequest);
        if(responseMessage!=null) {
            return responseMessage;
        }
        responseMessage = getDataDumpExportService().startDataDumpProcess(dataDumpRequest);
        return responseMessage;
    }
}
