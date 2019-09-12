package com.upnxtblog.samples.model;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component()
@Scope(value="request", proxyMode=ScopedProxyMode.TARGET_CLASS) 
public class MyRequestBean {
	@PostConstruct
    public void init() {
        System.out.println("init");
    }

    public void doSomething() {
        System.out.println("in doSomething()");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("destroy");
    }
}
