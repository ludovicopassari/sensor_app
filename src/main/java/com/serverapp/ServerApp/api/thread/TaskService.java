package com.serverapp.ServerApp.api.thread;

import com.serverapp.ServerApp.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

@Service
public class TaskService {

    private static final Logger logger = LoggerFactory.getLogger(TaskService.class);
    private final WebApplicationContext webApplicationContext;

    public TaskService(WebApplicationContext webApplicationContext) {
        this.webApplicationContext = webApplicationContext;
    }

    public void executeTask(User user) {
       MyRunnableTask task = webApplicationContext.getBean(MyRunnableTask.class);
       task.setUser(user);
       Thread thread = new Thread(task);
       thread.start();

    }
}
