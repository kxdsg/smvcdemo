package com.argus.web.v3.idol;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xingding
 * @date 17/7/23.
 */
public class PerformerMain {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
//        JugglerImpl allen = (JugglerImpl)ctx.getBean("allen");
//        //通过反射创建Bean allen = new com.argus.web.v3.idol.JugglerImpl();
//        allen.perform();
//
//        PoeticJugglerImpl bonnie = (PoeticJugglerImpl)ctx.getBean("bonnie");
//        bonnie.perform();

        PerformerService allen = (PerformerService)ctx.getBean("allen");
        allen.perform();
    }


}
