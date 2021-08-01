package com.rdm.jpa.jpademo.controller;

import java.util.Arrays;
import java.util.List;

interface MockInterface{
    public List<String> getData();
}

class TestMock implements  MockInterface{

    @Override
    public List<String> getData() {

        return  Arrays.asList("hello","Sie hello");
    }
}
public class MockController {
    MockInterface mockInterface ;
    TestMock testMock = new TestMock();
    MockController(MockInterface mockInterface){
        super();
        this.mockInterface = mockInterface ;
    }

    public int getInformation(String user){
        int count = 0 ;
        List<String> users = testMock.getData();

        for(String usr:users){
            if(usr.contains("hello")){
                count++;
            }
        }
        return count;
    }
}
