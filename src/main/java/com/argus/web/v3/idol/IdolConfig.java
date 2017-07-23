package com.argus.web.v3.idol;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xingding
 * @date 17/7/23.
 */
//等同beans.xml中配置的元素
@Configuration
public class IdolConfig {

    @Bean
    public PerformerService allen(){
        return new JugglerImpl();
    }

    @Bean
    public PoemService poem(){
        return new PoemServiceImpl();
    }

    @Bean
    public PerformerService bonnie(){
        return new PoeticJugglerImpl(15, new PoemServiceImpl());
    }

}
