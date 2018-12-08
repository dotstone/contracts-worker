package net.devtoon.worker;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

import static org.mockito.Mockito.verify;

@SpringBootTest(classes = {WorkerApplication.class})
class WorkListenerTest {

    @SpyBean
    private WorkerService service;

    @Autowired
    private Sink sink;

    @Test
    void testHandleMessage() {
        Message<String> msg = MessageBuilder.withPayload("helloworld").build();

        sink.input().send(msg);

        verify(service).doWork("helloworld");
    }
}