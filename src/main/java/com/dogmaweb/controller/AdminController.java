package com.dogmaweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/")
public class AdminController {

    @RequestMapping("/jboss")
    public String index() {
        return "admin.jboss.snoop";
    }

}
