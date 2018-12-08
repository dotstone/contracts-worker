package net.devtoon.worker;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class WorkerServiceTest {

    @Autowired
    private WorkerService worker;

    @Test
    void testEmpty() {
        assertThat(worker.doWork("")).isEqualTo("");
    }

    @Test
    void testSingleChar() {
        assertThat(worker.doWork("A")).isEqualTo("A");
    }

    @Test
    void testString() {
        assertThat(worker.doWork("some longer string")).isEqualTo("gsome longer strin");
    }
}
