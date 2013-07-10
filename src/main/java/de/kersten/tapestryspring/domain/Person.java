package de.kersten.tapestryspring.domain;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 */
@Document
public class Person {

    private String id;

    private String name;

    /**
     * this is an embedded document
     */
    private Address address;

    /**
     * a referenced document
     */
    @DBRef
    private Account account;

    private int age;

    public Person(final String name, final int age) {
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", age=" + age + "]";
    }

    /**
     * @return the address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * @param address
     *            the address to set
     */
    public void setAddress(final Address address) {
        this.address = address;
    }

    /**
     * @return the account
     */
    public Account getAccount() {
        return account;
    }

    /**
     * @param account
     *            the account to set
     */
    public void setAccount(final Account account) {
        this.account = account;
    }
}
