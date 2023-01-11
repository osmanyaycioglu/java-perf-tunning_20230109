package com.training.performance.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MyOtherBean {

    private MyBean myBean;
    private ApplicationContext applicationContext;

    public MyOtherBean(MyBean myBeanParam,
                       ApplicationContext applicationContextParam) {
        myBean = myBeanParam;
        applicationContext = applicationContextParam;
        // init
    }

    public String abcDo(){
        return myBean.xyzDo();
    }

}
