package com.dogmaweb.security;

import org.springframework.data.domain.AuditorAware;

import com.dogmaweb.model.User;

public class ModelAuditor implements AuditorAware<User> {

    private static User DEFAULT_USER = null;

    static {
        DEFAULT_USER = new User();
        DEFAULT_USER.setUsername("anonymous");
        DEFAULT_USER.setEmail("anonymous@runking.com");
    }

    @Override
    public User getCurrentAuditor() {
        return DEFAULT_USER;
    }

}
