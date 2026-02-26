package org.recap.model.search;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by rajeshbabuk on 11/7/16.
 */
public class SearchResultRow {

    private Integer bibId;
    private String title;
    private String author;
    private String publisher;
    private String publisherDate;
    private String owningInstitution;
    private String customerCode;
    private String collectionGroupDesignation;
    private String useRestriction;
    private String barcode;
    private String summaryHoldings;
    private String availability;
    private String leaderMaterialType;
    private boolean selected = false;
    private boolean showItems = false;
    private boolean selectAllItems = false;
    private List<SearchItemResultRow> searchItemResultRows = new ArrayList<>();
    private Integer itemId;

    /**
     * Gets bib id.
     *
     * @return the bib id
     */
    public Integer getBibId() {
        return bibId;
    }

    /**
     * Sets bib id.
     *
     * @param bibId the bib id
     */
    public void setBibId(Integer bibId) {
        this.bibId = bibId;
    }

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets author.
     *
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets author.
     *
     * @param author the author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * Gets publisher.
     *
     * @return the publisher
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * Sets publisher.
     *
     * @param publisher the publisher
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * Gets publisher date.
     *
     * @return the publisher date
     */
    public String getPublisherDate() {
        return publisherDate;
    }

    /**
     * Sets publisher date.
     *
     * @param publisherDate the publisher date
     */
    public void setPublisherDate(String publisherDate) {
        this.publisherDate = publisherDate;
    }

    /**
     * Gets owning institution.
     *
     * @return the owning institution
     */
    public String getOwningInstitution() {
        return owningInstitution;
    }

    /**
     * Sets owning institution.
     *
     * @param owningInstitution the owning institution
     */
    public void setOwningInstitution(String owningInstitution) {
        this.owningInstitution = owningInstitution;
    }

    /**
     * Gets customer code.
     *
     * @return the customer code
     */
    public String getCustomerCode() {
        return customerCode;
    }

    /**
     * Sets customer code.
     *
     * @param customerCode the customer code
     */
    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    /**
     * Gets collection group designation.
     *
     * @return the collection group designation
     */
    public String getCollectionGroupDesignation() {
        return collectionGroupDesignation;
    }

    /**
     * Sets collection group designation.
     *
     * @param collectionGroupDesignation the collection group designation
     */
    public void setCollectionGroupDesignation(String collectionGroupDesignation) {
        this.collectionGroupDesignation = collectionGroupDesignation;
    }

    /**
     * Gets use restriction.
     *
     * @return the use restriction
     */
    public String getUseRestriction() {
        return useRestriction;
    }

    /**
     * Sets use restriction.
     *
     * @param useRestriction the use restriction
     */
    public void setUseRestriction(String useRestriction) {
        this.useRestriction = useRestriction;
    }

    /**
     * Gets barcode.
     *
     * @return the barcode
     */
    public String getBarcode() {
        return barcode;
    }

    /**
     * Sets barcode.
     *
     * @param barcode the barcode
     */
    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    /**
     * Gets summary holdings.
     *
     * @return the summary holdings
     */
    public String getSummaryHoldings() {
        return summaryHoldings;
    }

    /**
     * Sets summary holdings.
     *
     * @param summaryHoldings the summary holdings
     */
    public void setSummaryHoldings(String summaryHoldings) {
        this.summaryHoldings = summaryHoldings;
    }

    /**
     * Gets availability.
     *
     * @return the availability
     */
    public String getAvailability() {
        return availability;
    }

    /**
     * Sets availability.
     *
     * @param availability the availability
     */
    public void setAvailability(String availability) {
        this.availability = availability;
    }

    /**
     * Gets leader material type.
     *
     * @return the leader material type
     */
    public String getLeaderMaterialType() {
        return leaderMaterialType;
    }

    /**
     * Sets leader material type.
     *
     * @param leaderMaterialType the leader material type
     */
    public void setLeaderMaterialType(String leaderMaterialType) {
        this.leaderMaterialType = leaderMaterialType;
    }

    /**
     * Is selected boolean.
     *
     * @return the boolean
     */
    public boolean isSelected() {
        return selected;
    }

    /**
     * Sets selected.
     *
     * @param selected the selected
     */
    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    /**
     * Is show items boolean.
     *
     * @return the boolean
     */
    public boolean isShowItems() {
        return showItems;
    }

    /**
     * Sets show items.
     *
     * @param showItems the show items
     */
    public void setShowItems(boolean showItems) {
        this.showItems = showItems;
    }

    /**
     * Gets search item result rows.
     *
     * @return the search item result rows
     */
    public List<SearchItemResultRow> getSearchItemResultRows() {
        return searchItemResultRows;
    }

    /**
     * Sets search item result rows.
     *
     * @param searchItemResultRows the search item result rows
     */
    public void setSearchItemResultRows(List<SearchItemResultRow> searchItemResultRows) {
        this.searchItemResultRows = searchItemResultRows;
    }

    /**
     * Is select all items boolean.
     *
     * @return the boolean
     */
    public boolean isSelectAllItems() {
        return selectAllItems;
    }

    /**
     * Sets select all items.
     *
     * @param selectAllItems the select all items
     */
    public void setSelectAllItems(boolean selectAllItems) {
        this.selectAllItems = selectAllItems;
    }

    /**
     * Gets item id.
     *
     * @return the item id
     */
    public Integer getItemId() {
        return itemId;
    }

    /**
     * Sets item id.
     *
     * @param itemId the item id
     */
    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }
}
