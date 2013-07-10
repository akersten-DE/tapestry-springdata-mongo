package de.kersten.tapestryspring.domain;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 */
@Document
public class Account {

    public String id;

    public String accountName;

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
     * @return the accountName
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * @param accountName
     *            the accountName to set
     */
    public void setAccountName(final String accountName) {
        this.accountName = accountName;
    }
}
