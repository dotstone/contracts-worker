package net.devtoon.worker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

@Component
public class WorkListener {

    private static final Logger LOG = LoggerFactory.getLogger(WorkListener.class);

    @Autowired
    private WorkerService workerService;

    private String lastCmd = "";

    @StreamListener(Sink.INPUT)
    public void onWorkReceived(String cmd) {
        String result = workerService.doWork(cmd);
        LOG.info("Handled an incoming request[{}]: {}", cmd, result);
        lastCmd = cmd;
    }

    String getLastCmd() {
        return lastCmd;
    }
}
