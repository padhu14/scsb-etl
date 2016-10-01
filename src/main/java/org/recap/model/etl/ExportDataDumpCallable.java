package org.recap.model.etl;

import org.recap.model.export.DataDumpRequest;
import org.recap.model.jpa.BibliographicEntity;
import org.recap.repository.BibliographicDetailsRepository;
import org.recap.util.datadump.BibRecordConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * Created by premkb on 19/8/16.
 */
public class ExportDataDumpCallable implements Callable {

    private final int pageNum;
    private final int batchSize;
    private final List<String> institutionCodes;
    //private final int fetchType;
    private final String date;
    private final DataDumpRequest dataDumpRequest;
    @Autowired
    private BibliographicDetailsRepository bibliographicDetailsRepository;

    public ExportDataDumpCallable(int pageNum, int batchSize, DataDumpRequest dataDumpRequest, BibliographicDetailsRepository bibliographicDetailsRepository){
        this.pageNum = pageNum;
        this.batchSize = batchSize;
        this.bibliographicDetailsRepository = bibliographicDetailsRepository;
        this.institutionCodes = dataDumpRequest.getInstitutionCodes();
        //this.fetchType = dataDumpRequest.getFetchType();
        this.date = dataDumpRequest.getDate();
        this.dataDumpRequest = dataDumpRequest;
    }

    @Override
    public Object call() {
        BibRecordConverter BibRecordConverter = new BibRecordConverter();
        List<BibliographicEntity> bibliographicEntityList = getBibliographicEntities(pageNum,batchSize);
        return BibRecordConverter.getBibRecords(bibliographicEntityList);
    }

    private List<BibliographicEntity> getBibliographicEntities(int page, int size) {
        Page<BibliographicEntity> bibliographicEntities;
        List<BibliographicEntity> bibliographicEntityList = new ArrayList<>();
/*        if(fetchType==0){
            bibliographicEntities = bibliographicDetailsRepository.findByInstitutionCodes(new PageRequest(page, size),dataDumpRequest.getCollectionGroupIds(),this.institutionCodes);
            bibliographicEntityList = bibliographicEntities.getContent();
        }else if(fetchType==1){
            Date inputDate = DateUtil.getDateFromString(dataDumpRequest.getDate(), ReCAPConstants.DATE_FORMAT_YYYYMMDDHHMM);
            bibliographicEntities = bibliographicDetailsRepository.findByInstitutionCodeAndLastUpdatedDate(new PageRequest(page, size),dataDumpRequest.getCollectionGroupIds(),this.institutionCodes,inputDate);
            bibliographicEntityList = bibliographicEntities.getContent();
        }*/
        return bibliographicEntityList;
    }

    public BibliographicDetailsRepository getBibliographicDetailsRepository() {
        return bibliographicDetailsRepository;
    }

    public void setBibliographicDetailsRepository(BibliographicDetailsRepository bibliographicDetailsRepository) {
        this.bibliographicDetailsRepository = bibliographicDetailsRepository;
    }


}
