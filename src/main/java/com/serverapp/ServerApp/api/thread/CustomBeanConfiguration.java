package com.serverapp.ServerApp.api.thread;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class CustomBeanConfiguration {

    @Bean
    @Scope("prototype")
    public MyRunnableTask myRunnableTask() {
        return new MyRunnableTask();
    }
}
