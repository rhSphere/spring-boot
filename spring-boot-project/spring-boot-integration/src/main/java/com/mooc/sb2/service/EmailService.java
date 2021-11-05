package com.mooc.sb2.service;

import com.mooc.sb2.mylistener.UserRegisterEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: ludepeng
 * @date: 2021-09-06 11:28
 */

@Service
@Slf4j
public class EmailService implements ApplicationListener<UserRegisterEvent> {

    @Async
    @Override
    public void onApplicationEvent(UserRegisterEvent event) {
        log.info("给用户[{}]发送邮件", event.getUserName());
    }
}
