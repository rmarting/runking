package com.dogmaweb.mongodb;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dogmaweb.TestConstants;
import com.dogmaweb.model.Category;
import com.dogmaweb.model.Race;
import com.mongodb.WriteResult;

/**
 * @author jromanmartin@gmail.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/config/test-spring-context.xml",
        "classpath:/config/test-spring-data-mongo-db.xml" })
public class SpringDataMongoDBServiceTest {

    @Autowired
    private MongoOperations mongoTemplate = null;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        Assert.assertNotNull("Template exits", mongoTemplate);

        // Create DataBase
        mongoTemplate.createCollection(TestConstants.RACES_COLLECTION);
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
        // Clean DataBase
        mongoTemplate.dropCollection(TestConstants.RACES_COLLECTION);
    }

    @Test
    public void testDataBase() {
        // Cleaning previous executions
        Query searchAllRaceQuery = new Query();
        mongoTemplate.remove(searchAllRaceQuery, Race.class);

        // Example: Insert a document
        Race race = new Race();
        race.setName("Race Test");
        race.setDistance("5Km");
        race.setCategory(Category.RUNNING);

        mongoTemplate.insert(race);

        Assert.assertNotNull("Id is not null", race.getId());
        Assert.assertNotNull("Created date is not null", race.getCreatedAt());
        Assert.assertNotNull("Modified date is not null", race.getLastModified());
        Assert.assertNotNull("Created user is not null", race.getCreatedBy());
        Assert.assertNotNull("Last modified user is not null", race.getLastModifiedBy());
        Assert.assertEquals("Created user is anonymous", "anonymous", race.getCreatedBy().getUsername());
        Assert.assertEquals("Last modified user is anonimous", "anonymous", race.getLastModifiedBy().getUsername());

        // Example: Saving a document
        Race race2 = new Race();
        race.setName("Race 2 Test");
        race.setDistance("Santiago´s Way");
        race.setCategory(Category.WALKING);

        mongoTemplate.save(race2);

        Assert.assertNotNull("Id is not null", race2.getId());
        Assert.assertNotNull("Created date is not null", race2.getCreatedAt());
        Assert.assertNotNull("Modified date is not null", race2.getLastModified());
        Assert.assertNotNull("Created user is not null", race.getCreatedBy());
        Assert.assertNotNull("Last modified user is not null", race.getLastModifiedBy());
        Assert.assertEquals("Created user is anonymous", "anonymous", race.getCreatedBy().getUsername());
        Assert.assertEquals("Last modified user is anonimous", "anonymous", race.getLastModifiedBy().getUsername());

        // Example: Finding one
        Query searchRaceQuery = new Query(Criteria.where("name").is("Race Test"));

        List<Race> races = mongoTemplate.find(searchRaceQuery, Race.class);

        Assert.assertNotNull("Races list", races);
        Assert.assertFalse("Races is not empty", races.isEmpty());
        Assert.assertEquals("Races has one item", Integer.valueOf(1), Integer.valueOf(races.size()));

        // Example: Updating a document
        WriteResult result = mongoTemplate.updateFirst(searchRaceQuery, Update.update("name", "Race Updated Test"),
                Race.class);

        Assert.assertNotNull("Update result", result);

        // Confirming update
        Query searchRaceUpdateQuery = new Query(Criteria.where("name").is("Race Updated Test"));

        Race raceUpdated = mongoTemplate.findOne(searchRaceUpdateQuery, Race.class);

        Assert.assertNotNull("Race updated", raceUpdated);
        Assert.assertEquals("Name updated", "Race Updated Test", raceUpdated.getName());

        // Example: Saving a document
        raceUpdated.setDistance("10 Km");

        mongoTemplate.save(raceUpdated);

        // Confirming update
        searchRaceUpdateQuery = new Query(Criteria.where("distance").is("10 Km"));

        Race raceUpdated2 = mongoTemplate.findOne(searchRaceUpdateQuery, Race.class);

        Assert.assertNotNull("Race updated", raceUpdated2);
        Assert.assertEquals("Name updated", "10 Km", raceUpdated.getDistance());

        // Example: Removing a document
        mongoTemplate.remove(raceUpdated);

        // Example: Removing all documents
        mongoTemplate.remove(searchAllRaceQuery, Race.class);

        // Confirming update
        races = mongoTemplate.findAll(Race.class);

        Assert.assertNotNull("Races list", races);
        Assert.assertTrue("Races is not empty", races.isEmpty());
    }

}
