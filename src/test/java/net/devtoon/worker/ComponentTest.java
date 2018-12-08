package net.devtoon.worker;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ComponentTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testWorkCall() {
        ResponseEntity<String> entity = restTemplate.getForEntity("http://localhost:" + port + "/work?cmd=helloworld", String.class);
        assertThat(entity.getStatusCode().value()).isEqualTo(200);
        assertThat(entity.getBody()).isEqualTo("dhelloworl");
    }

    @Test
    void testCallWithoutCmd() {
        ResponseEntity<String> entity = restTemplate.getForEntity("http://localhost:" + port + "/work", String.class);
        assertThat(entity.getStatusCode().value()).isEqualTo(400);
    }
}
