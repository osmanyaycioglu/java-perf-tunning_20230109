package com.abc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class MyLibGroup {

    @Bean
    @Lazy
    public MyLib myLib(){
        return  new MyLib();
    }

    @Bean
    public MyOtherLib myOtherLib(){
        return  new MyOtherLib();
    }

}
