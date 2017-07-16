package com.argus.web.bean;

import org.springframework.stereotype.Component;

/**
 * @author xingding
 * @date 17/7/15.
 */
@Component
public class CompactDiscImpl implements CompactDisc{

    public void play() {
        System.out.println("compact disc impl, ahaha...");
    }
}
