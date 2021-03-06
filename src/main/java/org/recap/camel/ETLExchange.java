package org.recap.camel;

import org.recap.model.jpa.BibliographicEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by chenchulakshmig on 4/7/16.
 */
public class ETLExchange implements Serializable {

    private List<BibliographicEntity> bibliographicEntities;
    private Map institutionEntityMap;
    private Map collectionGroupMap;

    /**
     * Gets bibliographic entities.
     *
     * @return the bibliographic entities
     */
    public List<BibliographicEntity> getBibliographicEntities() {
        return bibliographicEntities;
    }

    /**
     * Sets bibliographic entities.
     *
     * @param bibliographicEntities the bibliographic entities
     */
    public void setBibliographicEntities(List<BibliographicEntity> bibliographicEntities) {
        this.bibliographicEntities = bibliographicEntities;
    }

    /**
     * Gets institution entity map.
     *
     * @return the institution entity map
     */
    public Map getInstitutionEntityMap() {
        return institutionEntityMap;
    }

    /**
     * Sets institution entity map.
     *
     * @param institutionEntityMap the institution entity map
     */
    public void setInstitutionEntityMap(Map institutionEntityMap) {
        this.institutionEntityMap = institutionEntityMap;
    }

    /**
     * Gets collection group map.
     *
     * @return the collection group map
     */
    public Map getCollectionGroupMap() {
        return collectionGroupMap;
    }

    /**
     * Sets collection group map.
     *
     * @param collectionGroupMap the collection group map
     */
    public void setCollectionGroupMap(Map collectionGroupMap) {
        this.collectionGroupMap = collectionGroupMap;
    }
}
