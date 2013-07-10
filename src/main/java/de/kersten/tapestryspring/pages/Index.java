package de.kersten.tapestryspring.pages;

import java.util.Date;

import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.alerts.AlertManager;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.ioc.annotations.Symbol;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;

import de.kersten.tapestryspring.domain.Account;
import de.kersten.tapestryspring.domain.Address;
import de.kersten.tapestryspring.domain.Person;
import de.kersten.tapestryspring.spring.ExampleSpringBean;

/**
 * Start page of application tapestry-spring.
 */
public class Index {

    @Property
    @Inject
    @Symbol(SymbolConstants.TAPESTRY_VERSION)
    private String tapestryVersion;

    @InjectComponent
    private Zone zone;

    @Inject
    private AlertManager alertManager;

    @Property
    @Inject
    private ExampleSpringBean springBean;

    @Property
    @Inject
    private ApplicationContext springContext;

    @Inject
    private MongoTemplate mongoTemplate;

    public Date getCurrentTime() {
        return new Date();
    }

    private long countPersons() {
        return mongoTemplate.getCollection(Person.class.getSimpleName().toLowerCase()).count();
    }

    void onActionFromIncrement() {
        final Person p = new Person("andre", 37);
        final Account account = new Account();
        account.setAccountName("test-account");
        mongoTemplate.save(account);
        // no cascading saves supported
        p.setAccount(account);
        mongoTemplate.save(p);
        alertManager.info("person with ID " + p.getId() + " created, number of persons = " + countPersons());

    }

    Object onActionFromIncrementAjax() {
        final Person p = new Person("andre", 37);
        final Address a = new Address();
        a.setCity("nowhere");
        p.setAddress(a);
        mongoTemplate.save(p);
        alertManager.info("person with ID " + p.getId() + " created (via Ajax) number of persons = " + countPersons());

        return zone;
    }

}
