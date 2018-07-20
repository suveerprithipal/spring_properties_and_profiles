package com.therandomtester.properties_and_profiles;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PropertiesAndProfilesApplicationTests {

    Logger logger = LoggerFactory.getLogger(PropertiesAndProfilesApplicationTests.class);
    @Autowired
    private Environment env;

    @Test
    public void localTest() {
        logger.info("My Active profile is " + env.getActiveProfiles()[0]);
        Assert.assertEquals("local", env.getProperty("my.app.url"));
    }

    @Test
    public void cloudTest() {
        logger.info("My Active profile is " + env.getActiveProfiles()[0]);
        Assert.assertEquals("cloud", env.getProperty("my.app.url"));
    }
}
