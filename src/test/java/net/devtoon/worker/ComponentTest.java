package net.devtoon.worker;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.support.MessageBuilder;

import static org.mockito.Mockito.verify;

@SpringBootTest
class ComponentTest {

    @Autowired
    private Sink sink;

    @SpyBean
    private WorkerService service;

    @Test
    void testWorkCall() {
        sink.input().send(MessageBuilder.withPayload("hello world").build());
        verify(service).doWork("hello world");
    }
}
