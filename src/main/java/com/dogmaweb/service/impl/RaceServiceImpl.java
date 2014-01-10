package com.dogmaweb.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dogmaweb.model.Race;
import com.dogmaweb.service.RaceService;

/**
 * @author jromanmartin@gmail.com
 */
@Service("raceService")
public class RaceServiceImpl extends BaseServiceImpl<Race> implements RaceService {

    @Override
    public List<Race> getAll() {
        return super.getAll(Race.class);
    }

    @Override
    public Race getById(String id) {
        return super.getById(id, Race.class);
    }

    @Override
    public Race get(Race Race) {
        return super.getById(Race.getId(), Race.class);
    }

    @Override
    public void add(Race Race) {
        super.insert(Race);
    }

    @Override
    public void update(Race Race) {
        super.update(Race);
    }

    @Override
    public void delete(Race Race) {
        super.delete(Race);
    }

}
