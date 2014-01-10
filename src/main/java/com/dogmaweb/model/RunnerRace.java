package com.dogmaweb.model;

import java.io.Serializable;

public class RunnerRace extends Auditable implements Serializable {

    private Race race;

    private Long officialTime;

    private Long realTime;

    private String observations;

    // TODO Incluir lista de corredores con los que se ha corrido

    public RunnerRace() {
        super();
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public Long getOfficialTime() {
        return officialTime;
    }

    public void setOfficialTime(Long officialTime) {
        this.officialTime = officialTime;
    }

    public Long getRealTime() {
        return realTime;
    }

    public void setRealTime(Long realTime) {
        this.realTime = realTime;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

}
