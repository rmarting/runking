package com.dogmaweb.service.impl;

import java.net.UnknownHostException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.dogmaweb.Constants;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public abstract class BaseServiceImpl<T> {

    @Autowired
    protected MongoOperations mongoTemplate = null;

    protected MongoClient open() throws UnknownHostException {
        // Its implementation is a connection pool
        MongoClient mongoClient = new MongoClient("localhost", 27017);

        // Authenticate
        // DB db = mongoClient.getDB("database name");
        // boolean auth = db.authenticate("username", "password".toCharArray());

        return mongoClient;
    }

    protected DBCollection getRunnersCollection(MongoClient mongoClient) {
        // Select DataBase
        DB db = mongoClient.getDB(Constants.DATABASE_NAME);
        // Select Collection
        return db.getCollection(Constants.RUNNERS_COLLECTION);
    }

    protected DBCollection getRacesCollection(MongoClient mongoClient) {
        // Select DataBase
        DB db = mongoClient.getDB(Constants.DATABASE_NAME);
        // Select Collection
        return db.getCollection(Constants.RUNNERS_COLLECTION);
    }

    protected void insert(T document) {
        mongoTemplate.insert(document);
    }

    protected void update(T document) {
        mongoTemplate.save(document);
    }

    protected void delete(T document) {
        mongoTemplate.remove(document);
    }

    protected T getById(Object id, Class<T> entityClass) {
        Query searchRaceQuery = new Query(Criteria.where("id").is(id));

        T entity = mongoTemplate.findOne(searchRaceQuery, entityClass);

        return entity;
    }

    protected List<T> getAll(Class<T> entityClass) {
        return mongoTemplate.findAll(entityClass);
    }

}
