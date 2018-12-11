package com.argus.web.util;

import org.springframework.context.ApplicationContext;

/**
 * Created by xingding on 18/12/11.
 */
public class SpringContextUtil {

    private static SpringContextUtil instance = new SpringContextUtil();
    private ApplicationContext context;

    public static SpringContextUtil getInstance()
    {
        if (instance == null) {
            instance = new SpringContextUtil();
        }
        return instance;
    }

    private SpringContextUtil()
    {
        this.context = null;
    }

    public static Object getClassInstance(Class clazz)
    {
        ApplicationContext context = getInstance().getContext();
        if (context == null) {
            return null;
        }
        String[] beanNames = context.getBeanNamesForType(clazz);
        if ((beanNames == null) || (beanNames.length == 0)) {
            return null;
        }
        return context.getBean(beanNames[0]);
    }

    public ApplicationContext getContext()
    {
        return this.context;
    }

    public void setContext(ApplicationContext context)
    {
        this.context = context;
    }
}
