package com.lion.common.base.message.impl;

import com.lion.common.base.message.Messages;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import java.util.Locale;

//@JsonIgnoreType
@Service
public class ResourceMessages implements Messages, ApplicationListener<ApplicationEvent> {

    protected ApplicationContext context = null;

    @Override
    public String getMessage(String code) {
        return context.getMessage(code, null, Locale.SIMPLIFIED_CHINESE);
    }

    @Override
    public String getMessage(String code, Object... args) {
        return context.getMessage(code, args, Locale.getDefault());
    }

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        if(applicationEvent instanceof ContextRefreshedEvent) {
            context = ((ContextRefreshedEvent)applicationEvent).getApplicationContext();
            return;
        }
        if(applicationEvent instanceof ContextClosedEvent) {
            context = null;
        }
    }
}
