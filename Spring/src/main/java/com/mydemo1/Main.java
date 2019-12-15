package com.mydemo1;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

    }

    @Test
    public void demo1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService)applicationContext.getBean("userService");
        UserService userService2 = (UserService)applicationContext.getBean("userService");
        System.out.println(userService);
        System.out.println(userService2);
        userService.save();
    }


    @Test
    public void demo2() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Car car = (Car)applicationContext.getBean("car");
        System.out.println(car.getName());
    }
}
