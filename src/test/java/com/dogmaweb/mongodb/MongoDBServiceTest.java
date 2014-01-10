package com.dogmaweb.mongodb;

import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.dogmaweb.TestConstants;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

/**
 * @author jromanmartin@gmail.com
 */
public class MongoDBServiceTest {

    /** Mongo Client */
    private static MongoClient mongoClient = null;

    /** Test DataBase */
    private static DB db = null;

    /** Test Collection */
    private static DBCollection collection = null;

    /**
     * @throws java.lang.Exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        // Loading Properties
        Properties prop = new Properties();
        InputStream in = MongoDBServiceTest.class.getResourceAsStream("/config/test.properties");
        prop.load(in);
        in.close();

        // Connection to MongoDB
        mongoClient = new MongoClient(prop.getProperty("mongodb.host"), Integer.parseInt(prop
                .getProperty("mongodb.port")));
        // Getting DataBase
        db = mongoClient.getDB(TestConstants.DATABASE_NAME);
        // Getting Test Collection
        collection = db.getCollection(TestConstants.TEST_COLLECTION);
    }

    /**
     * @throws java.lang.Exception
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        // Cleaning Database
        db.dropDatabase();
        // Closing connections
        mongoClient.close();
        mongoClient = null;
    }

    @Test
    public void testDataBase() {
        // Example: Getting Collections
        Set<String> collections = db.getCollectionNames();

        Assert.assertNotNull(collections);

        for (String s : collections) {
            System.out.println(s);
        }

        // Example: Insert a document
        BasicDBObject doc = new BasicDBObject("name", "MongoDB").append("type", "database").append("count", 1)
                .append("info", new BasicDBObject("x", 203).append("y", 102));

        collection.insert(doc);

        // Example: Finding one
        DBObject myDoc = collection.findOne();
        System.out.println(myDoc);

        // Example: Insert more documents
        for (int i = 0; i < 100; i++) {
            collection.insert(new BasicDBObject("i", i));
        }

        // Example: Counting data
        System.out.println(collection.getCount());

        // Example: Using cursors
        DBCursor cursor = collection.find();
        try {
            while (cursor.hasNext()) {
                System.out.println(cursor.next());
            }
        } finally {
            cursor.close();
        }

        // Example: Finding documents with queries
        BasicDBObject query = new BasicDBObject("i", 71);

        cursor = collection.find(query);

        try {
            while (cursor.hasNext()) {
                System.out.println(cursor.next());
            }
        } finally {
            cursor.close();
        }

        // Example: Finding documents with queries
        query = new BasicDBObject("i", new BasicDBObject("$gt", 3).append("$lte", 10));

        cursor = collection.find(query);

        try {
            while (cursor.hasNext()) {
                System.out.println(cursor.next());
            }
        } finally {
            cursor.close();
        }
    }

}
