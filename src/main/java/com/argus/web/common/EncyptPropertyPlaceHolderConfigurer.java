package com.argus.web.common;

import com.argus.web.util.DESUtil;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * Created by xingding on 18/4/14.
 */
public class EncyptPropertyPlaceHolderConfigurer extends PropertyPlaceholderConfigurer{
    private String[] encyptPropNames = {"username", "password"};

    @Override
    protected String convertProperty(String propertyName, String propertyValue) {
        if(isEncyptProp(propertyName)){
            System.out.println(propertyValue);
            String decryptValue = DESUtil.decrypt(propertyValue);
            System.out.println(decryptValue);
            return decryptValue;
        } else {
            return propertyValue;
        }
    }


    private boolean isEncyptProp(String propertyName){
        for(String encryptPropName: encyptPropNames){
            if(encryptPropName.equals(propertyName)){
                return true;
            }
        }
        return false;
    }
}
