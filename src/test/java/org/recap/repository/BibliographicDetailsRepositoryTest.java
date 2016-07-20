package org.recap.repository;

import org.junit.Test;
import org.recap.BaseTestCase;
import org.recap.model.jpa.BibliographicEntity;
import org.recap.model.jpa.BibliographicPK;
import org.recap.model.jpa.HoldingsEntity;
import org.recap.model.jpa.ItemEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by pvsubrah on 6/21/16.
 */
public class BibliographicDetailsRepositoryTest extends BaseTestCase {

    @Autowired
    BibliographicDetailsRepository bibliographicDetailsRepository;

    @Autowired
    HoldingsDetailsRepository holdingsDetailsRepository;

    @Autowired
    ItemDetailsRepository itemDetailsRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void saveAndFindBibHoldingsItemEntity() throws Exception {

        assertNotNull(bibliographicDetailsRepository);
        assertNotNull(holdingsDetailsRepository);
        assertNotNull(entityManager);

        Random random = new Random();

        String owningInstitutionBibId = String.valueOf(random.nextInt());
        int owningInstitutionId = 1;

        Page<BibliographicEntity> byOwningInstitutionId = bibliographicDetailsRepository.findByOwningInstitutionId(new PageRequest(0, 10), owningInstitutionId);

        BibliographicEntity bibliographicEntity = new BibliographicEntity();
        bibliographicEntity.setContent("Mock Bib Content".getBytes());
        bibliographicEntity.setCreatedDate(new Date());
        bibliographicEntity.setCreatedBy("etl");
        bibliographicEntity.setLastUpdatedBy("etl");
        bibliographicEntity.setLastUpdatedDate(new Date());
        bibliographicEntity.setOwningInstitutionBibId(owningInstitutionBibId);
        bibliographicEntity.setOwningInstitutionId(owningInstitutionId);

        HoldingsEntity holdingsEntity = new HoldingsEntity();
        holdingsEntity.setContent("mock holdings".getBytes());
        holdingsEntity.setCreatedDate(new Date());
        holdingsEntity.setCreatedBy("etl");
        holdingsEntity.setLastUpdatedDate(new Date());
        holdingsEntity.setLastUpdatedBy("etl");
        holdingsEntity.setOwningInstitutionHoldingsId(String.valueOf(random.nextInt()));

        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setCallNumberType("0");
        itemEntity.setCallNumber("callNum");
        itemEntity.setCreatedDate(new Date());
        itemEntity.setCreatedBy("etl");
        itemEntity.setLastUpdatedDate(new Date());
        itemEntity.setLastUpdatedBy("etl");
        itemEntity.setBarcode("1231");
        itemEntity.setOwningInstitutionItemId(".i1231");
        itemEntity.setOwningInstitutionId(1);
        itemEntity.setCollectionGroupId(1);
        itemEntity.setCustomerCode("PA");
        itemEntity.setItemAvailabilityStatusId(1);
        itemEntity.setHoldingsEntity(holdingsEntity);

        bibliographicEntity.setHoldingsEntities(Arrays.asList(holdingsEntity));
        bibliographicEntity.setItemEntities(Arrays.asList(itemEntity));

        BibliographicEntity savedBibliographicEntity = bibliographicDetailsRepository.saveAndFlush(bibliographicEntity);
        entityManager.refresh(savedBibliographicEntity);

        assertNotNull(savedBibliographicEntity);
        assertNotNull(savedBibliographicEntity.getBibliographicId());

        Long countByOwningInstitutionIdAfterAdd = bibliographicDetailsRepository.countByOwningInstitutionId(owningInstitutionId);
        assertTrue(countByOwningInstitutionIdAfterAdd > byOwningInstitutionId.getTotalElements());

        List<BibliographicEntity> byOwningInstitutionBibId = bibliographicDetailsRepository.findByOwningInstitutionBibId(owningInstitutionBibId);
        assertNotNull(byOwningInstitutionBibId);
        assertTrue(byOwningInstitutionBibId.size() > 0);

        BibliographicEntity byOwningInstitutionIdAndOwningInstitutionBibId = bibliographicDetailsRepository.findByOwningInstitutionIdAndOwningInstitutionBibId(owningInstitutionId, owningInstitutionBibId);
        assertNotNull(byOwningInstitutionIdAndOwningInstitutionBibId);

        BibliographicPK bibliographicPK = new BibliographicPK();
        bibliographicPK.setOwningInstitutionId(owningInstitutionId);
        bibliographicPK.setOwningInstitutionBibId(owningInstitutionBibId);
        BibliographicEntity entity = bibliographicDetailsRepository.getOne(bibliographicPK);
        assertNotNull(entity);

        assertNotNull(holdingsDetailsRepository);
        HoldingsEntity savedHoldingsEntity = savedBibliographicEntity.getHoldingsEntities().get(0);
        assertNotNull(savedHoldingsEntity);
        assertNotNull(savedHoldingsEntity.getHoldingsId());

        HoldingsEntity byHoldingsId = holdingsDetailsRepository.findByHoldingsId(savedHoldingsEntity.getHoldingsId());
        assertNotNull(byHoldingsId);

        assertNotNull(itemDetailsRepository);
        ItemEntity savedItemEntity = savedBibliographicEntity.getItemEntities().get(0);
        assertNotNull(savedItemEntity);
        assertNotNull(savedItemEntity.getItemId());

        ItemEntity byItemId = itemDetailsRepository.findByItemId(savedItemEntity.getItemId());
        assertNotNull(byItemId);
    }

}