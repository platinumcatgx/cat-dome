package com.platinumcat;

import com.platinumcat.UI.UI;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class test {
    @Autowired
    private UI ui;

    @Test
    public void testFindAll(){
        ui.print();
    }
}
