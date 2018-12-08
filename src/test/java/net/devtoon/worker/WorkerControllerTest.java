package net.devtoon.worker;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class WorkerControllerTest {

    @InjectMocks
    private WorkerController workerController;

    @Mock
    private WorkerService workerService;

    @Test
    void testServiceCall() {
        String cmd = "some cmd";
        when(workerService.doWork(cmd)).thenReturn("result");
        String response = workerController.work(cmd);
        verify(workerService).doWork(cmd);
        assertThat(response).isEqualTo("result");
    }
}
