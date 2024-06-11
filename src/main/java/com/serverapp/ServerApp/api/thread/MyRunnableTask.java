package com.serverapp.ServerApp.api.thread;

import com.serverapp.ServerApp.user.User;
import com.serverapp.ServerApp.user.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyRunnableTask implements Runnable {
    private User user;
    private static final Logger logger = LoggerFactory.getLogger(MyRunnableTask.class);
    @Autowired
    UserRepository userRepository;

    public MyRunnableTask() {
    }

    public void setUser(User user) {
        this.user = user;
    }


    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();

        logger.info("Esecuzione inserimento utente su thread {}", threadName);

        userRepository.save(user);

        logger.info("Inserimento utente completato su thread {}", threadName);
    }
}