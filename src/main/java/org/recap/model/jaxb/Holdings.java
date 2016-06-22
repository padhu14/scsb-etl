package org.recap.model.jaxb;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * Created by pvsubrah on 6/21/16.
 */
public class Holdings {
    private List<Holding> holding;

    @XmlElement
    public List<Holding> getHolding() {
        return holding;
    }

    public void setHolding(List<Holding> holding) {
        this.holding = holding;
    }
}
