package com.serverapp.ServerApp.api;

import com.serverapp.ServerApp.api.thread.TaskService;
import com.serverapp.ServerApp.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping("/user/add")
    public ResponseEntity startTask(@RequestBody User user) {
        try {
            taskService.executeTask(user);
            return ResponseEntity.ok().body("User added successfully");
        }catch (Exception e)
        {
            return ResponseEntity.badRequest().body("Erroe");
        }


    }
}

