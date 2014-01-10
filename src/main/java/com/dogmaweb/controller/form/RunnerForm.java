package com.dogmaweb.controller.form;

import java.io.Serializable;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class RunnerForm implements Serializable {

    private static final long serialVersionUID = -3759116460113858943L;

    private String id;

    @NotEmpty
    @Size(min = 6, max = 30)
    private String nickname;

    @NotEmpty
    @Size(min = 3, max = 60)
    private String name;

    @NotEmpty
    @Size(min = 3, max = 60)
    private String surname;

    public RunnerForm() {
        super();
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

}
