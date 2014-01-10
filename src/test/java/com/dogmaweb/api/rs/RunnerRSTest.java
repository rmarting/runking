package com.dogmaweb.api.rs;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.Scanner;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.dogmaweb.mongodb.MongoDBServiceTest;

public class RunnerRSTest {

    private static Properties prop = new Properties();

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        // Loading Properties
        InputStream in = MongoDBServiceTest.class.getResourceAsStream("/config/test.properties");
        prop.load(in);
        in.close();
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetRunners() {
        try {
            // TODO meter control de url por profile
            URL url = new URL(prop.getProperty("rest.url") + "/applications/api/rest/runner/list");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json");
            Scanner scanner;
            String response;

            // Connection and results
            Assert.assertNotNull(conn);
            Assert.assertNotNull(conn.getResponseCode());

            if (conn.getResponseCode() != 200) {
                scanner = new Scanner(conn.getErrorStream());
                response = "Error From Server \n\n";
            } else {
                scanner = new Scanner(conn.getInputStream());
                response = "Response From Server \n\n";
            }
            scanner.useDelimiter("\\Z");
            System.out.println(response + scanner.next());
            scanner.close();
            conn.disconnect();
        } catch (MalformedURLException e) {
            fail("Error in URL: " + e.getMessage());
        } catch (IOException e) {
            fail("Error IO: " + e.getMessage());
        }
    }

    @Test
    public void testGetRunner() {
        try {
            URL url = new URL(prop.getProperty("rest.url") + "/applications/api/rest/runner/52c1fbd797dd84512132274a");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type", "application/json");
            Scanner scanner;
            String response;

            // Connection and results
            Assert.assertNotNull(conn);
            Assert.assertNotNull(conn.getResponseCode());

            if (conn.getResponseCode() != 200) {
                scanner = new Scanner(conn.getErrorStream());
                response = "Error From Server \n\n";
            } else {
                scanner = new Scanner(conn.getInputStream());
                response = "Response From Server \n\n";
            }
            scanner.useDelimiter("\\Z");
            System.out.println(response + scanner.next());
            scanner.close();
            conn.disconnect();
        } catch (MalformedURLException e) {
            fail("Error in URL: " + e.getMessage());
        } catch (IOException e) {
            fail("Error IO: " + e.getMessage());
        }
    }

    @Test
    public void testCreate() {
        fail("Not yet implemented"); // TODO

        // conn.setRequestMethod("POST");
        // conn.setRequestProperty("Content-Type", "application/json");
    }

    @Test
    public void testUpdate() {
        fail("Not yet implemented"); // TODO
    }

    @Test
    public void testDelete() {
        fail("Not yet implemented"); // TODO
    }

}
