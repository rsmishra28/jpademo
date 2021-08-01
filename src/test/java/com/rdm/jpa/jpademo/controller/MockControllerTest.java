package com.rdm.jpa.jpademo.controller;

import com.rdm.jpa.jpademo.controller.MockController;
import com.rdm.jpa.jpademo.controller.MockInterface;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MockControllerTest {

    @Mock
    MockInterface mockInterface;


    @InjectMocks
    MockController mockController ;

    @Test
    public void getInformationTest(){
        //Below line is replace ment of @Mock
      //  MockInterface mockInterface = mock(MockInterface.class);
        List<String> users = Arrays.asList("I am hello","he2llo","hello sir");
        when(mockInterface.getData()).thenReturn(users);

        //Below code replace with @InjectMock
        //   MockController mockController = new MockController(mockInterface);

        int count = mockController.getInformation("dummy");
        System.out.println("count "+count);
        Assertions.assertEquals(2 , count);
    }

}
