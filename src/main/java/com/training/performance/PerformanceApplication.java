package com.training.performance;

import com.abc.MyLibGroup;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication(scanBasePackages = { "com.training" })
@Import(MyLibGroup.class)
@EnableAsync
@EnableScheduling
public class PerformanceApplication {

    @Bean
    public ExecutorService myExecutor(){
        return Executors.newFixedThreadPool(5);
    }

    public static void main(String[] args) {
        SpringApplication.run(PerformanceApplication.class,
                              args);
        System.out.println("Stop Here");
    }

}
