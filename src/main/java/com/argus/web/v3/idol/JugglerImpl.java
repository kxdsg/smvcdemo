package com.argus.web.v3.idol;

/**
 * @author xingding
 * @date 17/7/23.
 */
public class JugglerImpl implements PerformerService{
    private int beanBags = 3;

    public JugglerImpl(){}

    public JugglerImpl(int beanBags) {
        this.beanBags = beanBags;
    }

    public void perform() {
        System.out.println("juggling " + beanBags + " beanbags");
    }
}
