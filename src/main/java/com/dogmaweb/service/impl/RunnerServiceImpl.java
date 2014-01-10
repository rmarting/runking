package com.dogmaweb.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dogmaweb.model.Runner;
import com.dogmaweb.service.RunnerService;

/**
 * @author jromanmartin@gmail.com
 */
@Service("runnerService")
public class RunnerServiceImpl extends BaseServiceImpl<Runner> implements RunnerService {

    @Override
    public List<Runner> getAll() {
        return super.getAll(Runner.class);
    }

    @Override
    public Runner getById(String id) {
        return super.getById(id, Runner.class);
    }

    @Override
    public Runner get(Runner runner) {
        return super.getById(runner.getId(), Runner.class);
    }

    @Override
    public void add(Runner runner) {
        super.insert(runner);
    }

    @Override
    public void update(Runner runner) {
        super.update(runner);
    }

    @Override
    public void delete(Runner runner) {
        super.delete(runner);
    }

}
