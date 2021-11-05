package com.mooc.sb2.service;

import com.mooc.sb2.mylistener.UserRegisterEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: ludepeng
 * @date: 2021-09-06 11:30
 */

@Service
@Slf4j
public class UserService implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void register(String userName) {
        log.info("执行用户[{}]的注册逻辑", userName);
        applicationEventPublisher.publishEvent(new UserRegisterEvent(this, userName));
    }
}
