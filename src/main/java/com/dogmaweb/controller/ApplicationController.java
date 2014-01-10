package com.dogmaweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/")
public class ApplicationController {

    /** Name of tile for index page */
    public static final String PAGE_INDEX = "application.index";

    private ModelAndView goIndex() {
        return new ModelAndView(PAGE_INDEX);
    }

    @RequestMapping(value = "/")
    public ModelAndView index(ModelMap model) {
        return goIndex();
    }

}
