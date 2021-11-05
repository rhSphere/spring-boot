package com.mooc.sb2.mylistener;

import org.springframework.context.ApplicationEvent;

/**
 * @description:
 * @author: ludepeng
 * @date: 2021-09-06 11:07
 */
public class UserRegisterEvent extends ApplicationEvent {

    private String userName;


    /**
     * 也就是说当你用子类的无参构造函数创建子类对象时，会去先递归调用父类的无参构造方法
     *
     * 父类没有默认无参构造方法
     * @param source
     */
    public UserRegisterEvent(Object source) {
        super(source);
    }


    public UserRegisterEvent(Object source, String userName) {
        super(source);
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
}
