package com.argus.web;


import com.argus.web.bean.CompactDisc;
import com.argus.web.config.SpringConfig;
import com.argus.web.service.PerformanceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

/**
 * @author xingding
 * @date 17/7/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class CompactDiscTest {

    @Autowired
    private CompactDisc cd;

    @Test
    public void cdNotNull(){
        assertNotNull(cd);
    }

    @Test
    public void play(){
        cd.play();
    }

    @Autowired
    private PerformanceService service;

    @Test
    public void perform(){
        service.performance();
    }
}
