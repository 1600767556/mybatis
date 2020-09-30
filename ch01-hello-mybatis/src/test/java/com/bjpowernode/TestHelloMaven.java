package com.bjpowernode;

import org.junit.Assert;
import org.junit.Test;

public class TestHelloMaven {
    @Test
    public  void  testAdd(){
        HelloMaven helloMaven = new HelloMaven();
        int add = helloMaven.add(10, 20);
        Assert.assertEquals(30,add);

    }

}
