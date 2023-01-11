package com.abc;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class MyApi {

    public String hello(){
        return "Hello";
    }

}
