package org.recap.model.search;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by angelind on 26/10/16.
 */
public class DataDumpSearchResult {

    private Integer bibId;
    private List<Integer> itemIds = new ArrayList<>();

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
     * Gets item ids.
     *
     * @return the item ids
     */
    public List<Integer> getItemIds() {
        return itemIds;
    }

    /**
     * Sets item ids.
     *
     * @param itemIds the item ids
     */
    public void setItemIds(List<Integer> itemIds) {
        this.itemIds = itemIds;
    }
}
