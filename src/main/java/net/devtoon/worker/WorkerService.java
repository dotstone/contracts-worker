package net.devtoon.worker;

import org.springframework.stereotype.Service;

@Service
class WorkerService {

    String doWork(String cmd) {
        if (cmd.isEmpty()) {
            return cmd;
        }
        return cmd.charAt(cmd.length() - 1) + cmd.substring(0, cmd.length() - 1);
    }
}
