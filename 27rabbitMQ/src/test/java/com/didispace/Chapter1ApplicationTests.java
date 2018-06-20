package com.didispace;


import com.didispace.product.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Chapter1Application.class)
public class Chapter1ApplicationTests {

    @Autowired(required = false)
    private Sender sender;

    @Test
    public void hello() throws Exception {
        sender.send();
    }
}
