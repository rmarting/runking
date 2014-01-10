package com.dogmaweb.service;

import java.util.List;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dogmaweb.model.Runner;

/**
 * @author jromanmartin@gmail.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/config/test-spring-context.xml",
        "classpath:/config/test-spring-data-mongo-db.xml" })
public class RunnerServiceTest {

    @Autowired
    protected RunnerService runnerService = null;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        Assert.assertNotNull("Service instanciated", this.runnerService);
    }

    /**
     * Test method for {@link com.dogmaweb.service.RunnerService#add(com.dogmaweb.model.Runner)} .
     */
    @Test
    public void testService() {
        // Getting all
        List<Runner> runners = this.runnerService.getAll();
        Assert.assertNotNull("Runner List is not null", runners);

        // Adding
        Runner runner = new Runner("Runner", "Test", new DateTime(1976, 2, 19, 13, 00));

        this.runnerService.add(runner);

        Assert.assertNotNull("Runner id is not null", runner.getId());

        System.out.println("Runner:\n" + runner);

        // Getting by Id
        Runner runnerGetted = this.runnerService.getById(runner.getId());

        Assert.assertNotNull("Runner getted id is not null", runnerGetted);
        Assert.assertNotNull("Runner getted name is not null", runnerGetted.getName());
        Assert.assertEquals("Runner name is equals", "Runner", runnerGetted.getName());

        // Getting by Runner
        runnerGetted = this.runnerService.get(runner);

        Assert.assertNotNull("Runner getted id is not null", runnerGetted);
        Assert.assertNotNull("Runner getted name is not null", runnerGetted.getName());
        Assert.assertEquals("Runner name is equals", "Runner", runnerGetted.getName());

        // Updating
        runnerGetted.setName("Runner Updated");

        this.runnerService.update(runnerGetted);

        // Getting Updated
        Runner runnerUpdated = this.runnerService.get(runnerGetted);

        Assert.assertNotNull("Runner updated id is not null", runnerUpdated);
        Assert.assertNotNull("Runner updated name is not null", runnerUpdated.getName());
        Assert.assertEquals("Runner updated name is equals", "Runner Updated", runnerUpdated.getName());

        // Deleting
        this.runnerService.delete(runner);

        // Getting Deleted
        Runner runnerDeleted = this.runnerService.get(runnerUpdated);

        Assert.assertNull("Runner deleted is null", runnerDeleted);
    }

}
