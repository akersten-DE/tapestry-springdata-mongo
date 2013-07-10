package de.kersten.tapestryspring.domain;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 */
@Document
public class Address {

    private String id;

    private String city;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(final String id) {
        this.id = id;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city
     *            the city to set
     */
    public void setCity(final String city) {
        this.city = city;
    }
}
