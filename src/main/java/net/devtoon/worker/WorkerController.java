package net.devtoon.worker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
class WorkerController {

    @Autowired
    private WorkerService workerService;

    @RequestMapping(name = "/work", params = "cmd") String work(@PathParam("cmd") String cmd) {
        return workerService.doWork(cmd);
    }
}
