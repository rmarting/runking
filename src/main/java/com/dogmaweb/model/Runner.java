package com.dogmaweb.model;

import java.io.Serializable;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.dogmaweb.Constants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Document(collection = Constants.RUNNERS_COLLECTION)
public class Runner extends Auditable implements Serializable {

    private static final long serialVersionUID = -4395121900616234590L;

    @Id
    private String id;

    private String nickname;

    private String name;

    private String surname;

    private DateTime birthday;

    private List<RunnerRace> races;

    public Runner() {
        super();
    }

    public Runner(String name, String surname) {
        super();
        this.name = name;
        this.surname = surname;
    }

    public Runner(String name, String surname, DateTime birthday) {
        super();
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public DateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(DateTime birthday) {
        this.birthday = birthday;
    }

    public List<RunnerRace> getRaces() {
        return races;
    }

    public void setRaces(List<RunnerRace> races) {
        this.races = races;
    }

    @Override
    public String toString() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        return gson.toJson(this);
    }

}
