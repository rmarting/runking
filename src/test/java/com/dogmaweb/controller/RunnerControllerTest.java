package com.dogmaweb.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.ModelAndView;

import com.dogmaweb.model.Runner;
import com.dogmaweb.service.impl.RunnerServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = { "classpath:/config/test-spring-context.xml",
        "classpath:/config/test-spring-data-mongo-db.xml", "file:src/main/webapp/WEB-INF/config/spring-mvc.xml" })
public class RunnerControllerTest {

    @InjectMocks
    private RunnerController controller;

    @InjectMocks
    private RunnerServiceImpl serviceMock;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        // Process mock annotations
        MockitoAnnotations.initMocks(this);

        // Setup Spring test in standalone mode
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void testIndex() throws Exception {
        Runner first = new Runner();
        first.setId("1");
        first.setName("Lorem ipsum");
        first.setSurname("Foo");

        Runner second = new Runner();
        first.setId("2");
        first.setName("Lorem ipsum");
        first.setSurname("Bar");

        when(serviceMock.getAll()).thenReturn(Arrays.asList(first, second));

        this.mockMvc.perform(get("/admin/runners/index")).andExpect(status().isOk())
                .andExpect(forwardedUrl(RunnerController.PAGE_INDEX)).andExpect(model().hasNoErrors())
                .andExpect(model().attributeExists("list")).andExpect(model().attribute("list", Matchers.hasSize(2)));
    }

    @Test
    public void testList() throws Exception {
        // this.mockMvc
        // .perform(
        // post("/index").param("email", "<error>")
        // .param("firstName", "<error>")
        // .param("lastName", "<error>"))
        // .andExpect(status().isOk())
        // .andExpect(forwardedUrl(IndexController.PAGE_INDEX))
        // .andExpect(
        // model().attributeHasFieldErrors("signupForm", "email"));

        ModelAndView modelAndView = controller.list(null);
        assertEquals("Runners Index", "runners/index", modelAndView.getViewName());
    }

    @Test
    public void testCreate() throws Exception {
        // //// this.mockMvc.perform(post("/index")
        // //// .param("email", "<error>")
        // //// .param("firstName", "<error>")
        // //// .param("lastName", "<error>"))
        // //// .andExpect(status().isOk())
        // //// .andExpect(forwardedUrl(IndexController.PAGE_INDEX))
        // //// .andExpect(model().attributeHasFieldErrors("signupForm",
        // "email"));
        // ////
        // //
        // // ModelAndView modelAndView = controller.create((null);
        // assertEquals("Runners Index", "runners/index",
        // modelAndView.getViewName());
    }

    @Test
    public void testEdit() throws Exception {
        // this.mockMvc.perform(post("/index")
        // .param("email", "<error>")
        // .param("firstName", "<error>")
        // .param("lastName", "<error>"))
        // .andExpect(status().isOk())
        // .andExpect(forwardedUrl(IndexController.PAGE_INDEX))
        // .andExpect(model().attributeHasFieldErrors("signupForm", "email"));
        //
        //
        // ModelAndView modelAndView = controller.edit(id, model)(null);
        // assertEquals("Runners Index", "runners/index",
        // modelAndView.getViewName());
    }

    @Test
    public void testSave() throws Exception {
        // this.mockMvc.perform(post("/index")
        // .param("email", "<error>")
        // .param("firstName", "<error>")
        // .param("lastName", "<error>"))
        // .andExpect(status().isOk())
        // .andExpect(forwardedUrl(IndexController.PAGE_INDEX))
        // .andExpect(model().attributeHasFieldErrors("signupForm", "email"));
        //
        //
        // ModelAndView modelAndView = controller.save(runnerForm, result,
        // model)list(null);
        // assertEquals("Runners Index", "runners/index",
        // modelAndView.getViewName());
    }

    @Test
    public void testDelete() throws Exception {
        // this.mockMvc
        // .perform(
        // post("/index").param("email", "<error>")
        // .param("firstName", "<error>")
        // .param("lastName", "<error>"))
        // .andExpect(status().isOk())
        // .andExpect(forwardedUrl(IndexController.PAGE_INDEX))
        // .andExpect(
        // model().attributeHasFieldErrors("signupForm", "email"));
        //
        // ModelAndView modelAndView = controller.delete(id, model);
        // assertEquals("Runners Index", "runners/index",
        // modelAndView.getViewName());
    }

}
