package net.devtoon.worker;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WorkerApplication.class)
public abstract class BaseClass {

    @Autowired
    private WorkerController controller;

    @Before
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(controller);
    }
}
