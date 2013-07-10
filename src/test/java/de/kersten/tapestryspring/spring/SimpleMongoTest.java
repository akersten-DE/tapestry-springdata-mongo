package de.kersten.tapestryspring.spring;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.MongoCollectionUtils;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mongodb.DBCollection;

import de.kersten.tapestryspring.domain.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class SimpleMongoTest {

    @Autowired
    MongoOperations operations;

    @Before
    public void setUp() {
        if (operations.getCollectionNames().contains("MyNewCollection")) {
            operations.dropCollection("MyNewCollection");
        }

        final String collectionName = MongoCollectionUtils.getPreferredCollectionName(Person.class);
        if (operations.getCollectionNames().contains(collectionName)) {
            operations.dropCollection(collectionName);
        }
        operations.createCollection(collectionName);
    }

    @Test
    public void createAndDropCollection() {
        assertFalse(operations.getCollectionNames().contains("MyNewCollection"));

        /* create a new collection */
        DBCollection collection = null;
        if (!operations.getCollectionNames().contains("MyNewCollection")) {
            collection = operations.createCollection("MyNewCollection");
        }

        assertNotNull(collection);
        assertTrue(operations.getCollectionNames().contains("MyNewCollection"));

        operations.dropCollection("MyNewCollection");

        assertFalse(operations.getCollectionNames().contains("MyNewCollection"));
    }
}
