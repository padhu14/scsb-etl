package org.recap.model.search;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rajeshbabuk on 6/7/16.
 */
public class SearchRecordsRequest implements Serializable {


    private String fieldValue = "";

    private String fieldName;

    private List<String> owningInstitutions = null;

    private List<String> collectionGroupDesignations = null;

    private List<String> availability = null;

    private List<String> materialTypes = null;

    private List<String> useRestrictions = null;

    private List<SearchResultRow> searchResultRows = new ArrayList<>();

    private Integer totalPageCount = 0;

    private String totalBibRecordsCount = "0";

    private String totalItemRecordsCount = "0";

    private String totalRecordsCount = "0";

    private Integer pageNumber = 0;

    private Integer pageSize = 10;

    private boolean showResults = false;

    private boolean selectAll = false;

    private boolean selectAllFacets = false;

    private boolean showTotalCount = false;

    private Integer index;

    private String errorMessage;

    private boolean isDeleted = false;

    private String requestingInstitution = "";

    /**
     * Gets field value.
     *
     * @return the field value
     */
    public String getFieldValue() {
        return fieldValue;
    }

    /**
     * Sets field value.
     *
     * @param fieldValue the field value
     */
    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }

    /**
     * Gets field name.
     *
     * @return the field name
     */
    public String getFieldName() {
        return fieldName;
    }

    /**
     * Sets field name.
     *
     * @param fieldName the field name
     */
    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    /**
     * Gets owning institutions.
     *
     * @return the owning institutions
     */
    public List<String> getOwningInstitutions() {
        if (null == owningInstitutions) {
            owningInstitutions = new ArrayList<>();
        }
        return owningInstitutions;
    }

    /**
     * Sets owning institutions.
     *
     * @param owningInstitutions the owning institutions
     */
    public void setOwningInstitutions(List<String> owningInstitutions) {
        this.owningInstitutions = owningInstitutions;
    }

    /**
     * Gets collection group designations.
     *
     * @return the collection group designations
     */
    public List<String> getCollectionGroupDesignations() {
        if (null == collectionGroupDesignations) {
            collectionGroupDesignations = new ArrayList<>();
        }
        return collectionGroupDesignations;
    }

    /**
     * Sets collection group designations.
     *
     * @param collectionGroupDesignations the collection group designations
     */
    public void setCollectionGroupDesignations(List<String> collectionGroupDesignations) {
        this.collectionGroupDesignations = collectionGroupDesignations;
    }

    /**
     * Gets availability.
     *
     * @return the availability
     */
    public List<String> getAvailability() {
        if (null == availability) {
            availability = new ArrayList<>();
        }
        return availability;
    }

    /**
     * Sets availability.
     *
     * @param availability the availability
     */
    public void setAvailability(List<String> availability) {
        this.availability = availability;
    }

    /**
     * Gets material types.
     *
     * @return the material types
     */
    public List<String> getMaterialTypes() {
        if (null == materialTypes) {
            materialTypes = new ArrayList<>();
        }
        return materialTypes;
    }

    /**
     * Sets material types.
     *
     * @param materialTypes the material types
     */
    public void setMaterialTypes(List<String> materialTypes) {
        this.materialTypes = materialTypes;
    }

    /**
     * Gets use restrictions.
     *
     * @return the use restrictions
     */
    public List<String> getUseRestrictions() {
        if(null == useRestrictions) {
            useRestrictions = new ArrayList<>();
        }
        return useRestrictions;
    }

    /**
     * Sets use restrictions.
     *
     * @param useRestrictions the use restrictions
     */
    public void setUseRestrictions(List<String> useRestrictions) {
        this.useRestrictions = useRestrictions;
    }

    /**
     * Gets search result rows.
     *
     * @return the search result rows
     */
    public List<SearchResultRow> getSearchResultRows() {
        if (null == searchResultRows) {
            searchResultRows = new ArrayList<>();
        }
        return searchResultRows;
    }

    /**
     * Sets search result rows.
     *
     * @param searchResultRows the search result rows
     */
    public void setSearchResultRows(List<SearchResultRow> searchResultRows) {
        this.searchResultRows = searchResultRows;
    }

    /**
     * Gets total page count.
     *
     * @return the total page count
     */
    public Integer getTotalPageCount() {
        return totalPageCount;
    }

    /**
     * Sets total page count.
     *
     * @param totalPageCount the total page count
     */
    public void setTotalPageCount(Integer totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    /**
     * Gets page number.
     *
     * @return the page number
     */
    public Integer getPageNumber() {
        return pageNumber;
    }

    /**
     * Sets page number.
     *
     * @param pageNumber the page number
     */
    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    /**
     * Gets page size.
     *
     * @return the page size
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * Sets page size.
     *
     * @param pageSize the page size
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * Gets total bib records count.
     *
     * @return the total bib records count
     */
    public String getTotalBibRecordsCount() {
        return totalBibRecordsCount;
    }

    /**
     * Sets total bib records count.
     *
     * @param totalBibRecordsCount the total bib records count
     */
    public void setTotalBibRecordsCount(String totalBibRecordsCount) {
        this.totalBibRecordsCount = totalBibRecordsCount;
    }

    /**
     * Gets total item records count.
     *
     * @return the total item records count
     */
    public String getTotalItemRecordsCount() {
        return totalItemRecordsCount;
    }

    /**
     * Sets total item records count.
     *
     * @param totalItemRecordsCount the total item records count
     */
    public void setTotalItemRecordsCount(String totalItemRecordsCount) {
        this.totalItemRecordsCount = totalItemRecordsCount;
    }

    /**
     * Gets total records count.
     *
     * @return the total records count
     */
    public String getTotalRecordsCount() {
        return totalRecordsCount;
    }

    /**
     * Sets total records count.
     *
     * @param totalRecordsCount the total records count
     */
    public void setTotalRecordsCount(String totalRecordsCount) {
        this.totalRecordsCount = totalRecordsCount;
    }

    /**
     * Is show results boolean.
     *
     * @return the boolean
     */
    public boolean isShowResults() {
        return showResults;
    }

    /**
     * Sets show results.
     *
     * @param showResults the show results
     */
    public void setShowResults(boolean showResults) {
        this.showResults = showResults;
    }

    /**
     * Is select all boolean.
     *
     * @return the boolean
     */
    public boolean isSelectAll() {
        return selectAll;
    }

    /**
     * Is select all facets boolean.
     *
     * @return the boolean
     */
    public boolean isSelectAllFacets() {
        return selectAllFacets;
    }

    /**
     * Sets select all facets.
     *
     * @param selectAllFacets the select all facets
     */
    public void setSelectAllFacets(boolean selectAllFacets) {
        this.selectAllFacets = selectAllFacets;
    }

    /**
     * Sets select all.
     *
     * @param selectAll the select all
     */
    public void setSelectAll(boolean selectAll) {
        this.selectAll = selectAll;
    }

    /**
     * Is show total count boolean.
     *
     * @return the boolean
     */
    public boolean isShowTotalCount() {
        return showTotalCount;
    }

    /**
     * Sets show total count.
     *
     * @param showTotalCount the show total count
     */
    public void setShowTotalCount(boolean showTotalCount) {
        this.showTotalCount = showTotalCount;
    }

    /**
     * Gets index.
     *
     * @return the index
     */
    public Integer getIndex() {
        return index;
    }

    /**
     * Sets index.
     *
     * @param index the index
     */
    public void setIndex(Integer index) {
        this.index = index;
    }

    /**
     * Gets error message.
     *
     * @return the error message
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * Sets error message.
     *
     * @param errorMessage the error message
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * Reset page number.
     */
    public void resetPageNumber() {
        this.pageNumber = 0;
    }

    /**
     * Is deleted boolean.
     *
     * @return the boolean
     */
    public boolean isDeleted() {
        return isDeleted;
    }

    /**
     * Sets deleted.
     *
     * @param deleted the deleted
     */
    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }


    /**
     * Gets requesting institution.
     *
     * @return the requesting institution
     */
    public String getRequestingInstitution() {
        return requestingInstitution;
    }

    /**
     * Sets requesting institution.
     *
     * @param requestingInstitution the requesting institution
     */
    public void setRequestingInstitution(String requestingInstitution) {
        this.requestingInstitution = requestingInstitution;
    }

    /**
     * Reset.
     */
    public void reset() {
        this.totalBibRecordsCount = String.valueOf(0);
        this.totalItemRecordsCount = String.valueOf(0);
        this.totalRecordsCount = String.valueOf(0);
        this.showTotalCount = false;
        this.errorMessage = null;
    }
}
