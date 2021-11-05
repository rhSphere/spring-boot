package com.mooc.sb2.service;

import com.mooc.sb2.mylistener.UserRegisterEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Size;

/**
 * @description:
 * @author: ludepeng
 * @date: 2021-09-06 11:25
 */

@Service
@Slf4j
public class CouponService {

    @EventListener
    public void addCoupon(UserRegisterEvent event) {
        log.info("给用户[{}]发放优惠券", event.getUserName());
    }
}
