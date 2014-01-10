package com.dogmaweb.service;

import java.util.List;

import com.dogmaweb.model.Runner;

public interface RunnerService {

    List<Runner> getAll();

    Runner getById(String id);

    Runner get(Runner runner);

    void add(Runner runner);

    void update(Runner runner);

    void delete(Runner runner);

}
