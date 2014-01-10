package com.dogmaweb.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dogmaweb.controller.form.RunnerForm;
import com.dogmaweb.model.Runner;
import com.dogmaweb.service.RunnerService;

@Controller
@RequestMapping(value = "/admin/runners")
public class RunnerController {

    /** Name of tile for index page */
    public static final String PAGE_INDEX = "runners.index";

    /** Name of tile for form page */
    public static final String PAGE_FORM = "runners.form";

    @Autowired
    private RunnerService service;

    private ModelAndView goIndex() {
        return new ModelAndView(PAGE_INDEX);
    }

    private ModelAndView goForm() {
        return new ModelAndView(PAGE_FORM);
    }

    @RequestMapping(value = "/index")
    public ModelAndView index(ModelMap model) {
        model.addAttribute("list", this.service.getAll());

        return goIndex();
    }

    @RequestMapping(value = "/list")
    public ModelAndView list(ModelMap model) {
        return index(model);
    }

    @RequestMapping(value = "/create")
    public ModelAndView create(ModelMap model) {
        // New runner in model
        model.put("runnerForm", new RunnerForm());

        return goForm();
    }

    @RequestMapping(value = "/edit/{id}")
    public ModelAndView edit(@PathVariable(value = "id") String id, ModelMap model) {
        // Getting runner
        Runner runner = this.service.getById(id);

        // Form and values
        RunnerForm runnerForm = new RunnerForm();
        runnerForm.setId(runner.getId());
        runnerForm.setNickname(runner.getNickname());
        runnerForm.setName(runner.getName());
        runnerForm.setSurname(runner.getSurname());

        // Register in model
        model.put("runnerForm", runnerForm);

        return goForm();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(@Valid @ModelAttribute RunnerForm runnerForm, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return goForm();
        }

        Runner runner = null;
        // Saving runner
        if ("".equals(runnerForm.getId())) {
            // TODO Service will manage this information
            runner = new Runner();
            runner.setNickname(runnerForm.getNickname());
            runner.setName(runnerForm.getName());
            runner.setSurname(runnerForm.getSurname());

            this.service.add(runner);
        } else {
            // TODO Getting runner
            runner = this.service.getById(runnerForm.getId());

            // Updating data
            runner.setNickname(runnerForm.getNickname());
            runner.setName(runnerForm.getName());
            runner.setSurname(runnerForm.getSurname());

            this.service.update(runner);
        }

        return goForm();
    }

    @RequestMapping(value = "/delete/{id}")
    public ModelAndView delete(@PathVariable(value = "id") String id, ModelMap model) {
        // Getting runner
        Runner runner = this.service.getById(id);
        // Deleting
        this.service.delete(runner);

        return index(model);
    }

}
