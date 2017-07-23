package com.argus.web;

import com.argus.web.v3.idol.IdolConfig;
import com.argus.web.v3.idol.JugglerImpl;
import com.argus.web.v3.idol.PerformerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author xingding
 * @date 17/7/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = IdolConfig.class)
public class IdolTest {

    @Autowired
    PerformerService allen;

    @Test
    public void allen(){
        allen.perform();
    }
}
