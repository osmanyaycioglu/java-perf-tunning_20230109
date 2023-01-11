package com.training.performance.spring;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.sql.Connection;

@Component
@Lazy
public class MyBean {

    private String xyz;

    public String xyzDo() {
        return xyz;
    }
}
