package com.dogmaweb.service;

import java.util.List;

import com.dogmaweb.model.Race;

public interface RaceService {

    List<Race> getAll();

    Race getById(String id);

    Race get(Race race);

    void add(Race race);

    void update(Race race);

    void delete(Race race);

}
